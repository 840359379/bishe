var socket;
window.onload = function (){
}

/**
 * 关于生成新的东西
 * @param list
 */
function newContent(list){
    let main = document.getElementById("socket-content");
    let account = main.getAttribute("abbr");
    if(account !== list.account) {
        let div = newdiv(main, "socket-data text-left");
        newimg(div, "picture-data", `/static/picture/${list.account}.jpg`);
        let sonDiv = newdiv(div, "time-name");
        newp(sonDiv, "", list.name);
        newp(sonDiv, "", list.startTime);
        newp(newdiv(div, ""), "chat", list.content);
    } else {
        let div = newdiv(main, "socket-data text-right");
        let sonDiv = newdiv(div, "time-name");
        newp(sonDiv, "", list.name);
        newp(sonDiv, "", list.startTime);
        newimg(div, "picture-data", `/static/picture/${list.account}.jpg`);
        newp(newdiv(div, ""), "chat", list.content);
    }
    $("#socket-content").scrollTop($("#socket-content").prop('scrollHeight'));
}

/**
 * 关于聊天属性的注入
 * @param data
 */
function socketContent(data){
    if(!socket){
        openSocket();
    }
    let main = document.getElementById("socket-content");
    main.innerHTML = "";
    let account = main.getAttribute("abbr");
    if(data.length){
        $("#coverPicture").attr("src",`/static/picture/${data[0].account === account ? data[0].cover : data[0].account}.jpg`);
        $("#coverName").html(data[0].account === account ? data[0].coverName : data[0].name);
        data.forEach(function (list){
            newContent(list);
        })
    }
}

//获取聊天记录的ajax
function ajaxData(my){
    if(my.className.indexOf("active") === -1){
        $.ajax({
            data:{cover:my.id},
            dataType:"json",
            url:"http://127.0.0.1:8080/blog/chat/look/socket",
            type:"POST",
            success:function (data){
                if(data.code){
                    socketContent(data.data);
                    change(my);
                }else {
                    alert("操作失败");
                }
            },error:function (){
                alert("获取失败");
            }
        })
    }
}

/**
 * 关于切换聊天的js
 * @param my
 */
function change(my){
    let cla = $("#socket-content").children(':last-child').attr("class")
    if(cla === undefined || cla.indexOf("text-left") !== -1){
        $("#unread").html(0);
    }
    if($(".active").length === 1){
        my.className = my.className + " active";
    }else {
        $(".active")[1].className = $(".active")[1].className.replace(" active","");
        my.className = my.className + " active";
    }
}

//全局连天对象


function openSocket() {
    if(typeof(WebSocket) == "undefined") {
        console.log("您的浏览器不支持WebSocket");
    }else{
        console.log("您的浏览器支持WebSocket");
        //实现化WebSocket对象，指定要连接的服务器地址与端口  建立连接
        //等同于socket = new WebSocket("ws://localhost:8888/xxxx/im/25");
        //var socketUrl="${request.contextPath}/im/"+$("#userId").val();
        var socketUrl="http://127.0.0.1:8080/line/"+$("#socket-content").attr("abbr");
        socketUrl=socketUrl.replace("https","ws").replace("http","ws");
        console.log(socketUrl);
        if(socket!=null){
            socket.close();
            socket=null;
        }
        socket = new WebSocket(socketUrl);
        //打开事件
        socket.onopen = function() {
            console.log("websocket已打开");
            //socket.send("这是来自客户端的消息" + location.href + new Date());
        };
        //获得消息事件
        socket.onmessage = function(msg) {
            if(msg.data !== "连接成功"){
                let data =  JSON.parse(msg.data)
                if(($(".active")[1].id === data.account) || ($(".active")[1].id === data.coveraccount) || (data.account === $("#socket-content").attr("abbr"))){
                    newContent(data);
                }else {
                    offLine(data);
                }
            }
            console.log(msg.data);
            //发现消息进入    开始处理前端触发逻辑
        };
        //关闭事件
        socket.onclose = function() {
            console.log("websocket已关闭");
        };
        //发生了错误事件
        socket.onerror = function() {
            console.log("websocket发生了错误");
        }
    }
}

/**
 * 离线消息接收
 * @param data
 */
function offLine(data){
    let coverAccount = data.account;
    $(`#${coverAccount}`).children(':last-child').children(":first").html(parseInt($(`#${coverAccount}`).children(':last-child').children(":first").html())+1);
    $.ajax({
        data:data,
        type: "POST",
        dataType: "JSON",
        url: "http://127.0.0.1:8080/blog/chat/off/line",
        success:function (data){
            if(data.code){
                alert("成功");
            }else {
                alert("操作失败");
            }
        },error:function (){
            alert("获取失败");
        }
    })
}

/**
 * 发送消息的函数
 * @param my
 */
function sendMessage(my) {
    let data = new Date();
    let startTime = `${data.getFullYear()}-${data.getMonth()}-${data.getDate()} ${data.getHours()}:${data.getMinutes()}:${data.getSeconds()}`;
    if(typeof(WebSocket) == "undefined") {
        console.log("您的浏览器不支持WebSocket");
    }else {
        console.log("您的浏览器支持WebSocket");
        socket.send(`{cover:"${$(".active")[1].id}",
        content:"${$("#content-text").val()}",
        name:"${my.id}",
        coverName:"${$("#coverName").html()}",
        startTime:"${startTime}"}`);
    }
}
