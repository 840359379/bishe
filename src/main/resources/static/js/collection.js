window.onload = function () {
    ajaxObtain();
}

/**
 * 操作收藏的函数
 * @param my
 */
function collection(my){
    let id = my.parentNode.id;
    $.ajax({
        type:"POST",
        url: "http://127.0.0.1:8080/blog/collection/operation/collection",
        data: {number:id},
        dataType: "json",
        success:function (data){
            if(data.code == 200){
                my.lastElementChild.innerHTML = data.message;
            }else {
                alert("操作失败");
            }
        },error:function (){
            alert("获取失败");
        }
    })
}

/**
 * 操作点赞的函数
 * @param my
 */
function operationGood(my){
    let id = my.parentNode.id;
    $.ajax({
        type:"POST",
        url: "http://127.0.0.1:8080/blog/good/operation/good",
        data: {number:id,situation:my.id},
        dataType: "json",
        success:function (data){
            if(data.code >= 200 && data.code < 300){
                location.reload();
                // good(my,data);
            }else {
                alert("操作失败");
            }
        },error:function (){
            alert("获取失败");
        }
    })
}

/**
 * 关于点赞的逻辑
 * @param my
 * @param data
 */
function good(my,data){
    if(data.message === "取消"){
        my.lastElementChild.innerHTML = my.lastElementChild.innerHTML.replace("已","");

        // my.lastElementChild.innerHTML = my.lastElementChild.innerHTML.replace();
    }else if(data.message === "修改成功"){
        $("#1").children().last().html($("#1").children().last().text().replace("已",""));
        $("#2").children().last().html($("#2").children().last().text().replace("已",""));
        my.lastElementChild.innerHTML = "已" + my.lastElementChild.innerHTML;
    }else {my.lastElementChild.innerHTML = "已" + my.lastElementChild.innerHTML;}
}

/**
 * 填充获取的数据
 * @param data
 */
function obtain(data){
    $("#yesterdayAdd").html(data.yesterdayAdd);
    $("#myCount").html(data.myCount);
    $("#lookTime").html(data.lookTime);
    $("#yesterdayGood").html(data.yesterdayGood);
}

function lookinvitation(my){
    window.open(`http://127.0.0.1:8080/blog/invitation/look/invitation?number=${my.parentNode.id}`);
}

/**
 * 获取一些数据填充
 */
function ajaxObtain(){
    $.ajax({
        type:"GET",
        url:"http://127.0.0.1:8080/blog/collection/obtain",
        dataType:"json",
        success:function (data){
            if(data.code === 200){
                obtain(data.data);
            }else {
                alert("操作失败");
            }
        },error:function (){
            alert("获取失败");
        }
    })
}


/**
 * 添加一条留言
 * @param my
 */
function addContent(my){
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "http://127.0.0.1:8080/blog/message/add/message",
        data: {coverAccount:my.id,substance:$("#content-text").val()},
        success:function (data){
            if(data.code === 200){
                location.reload();
            }else {
                alert("操作失败");
            }
        },error:function (){
            alert("请求出现错误，请重新尝试");
        }
    })
}