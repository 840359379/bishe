window.onload = function () {
    ajaxObtain();
}


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
                alert("操作成功");
            }else {
                alert("操作失败");
            }
        },error:function (){
            alert("获取失败");
        }
    })
}

function operationGood(my){
    let id = my.parentNode.id;
    $.ajax({
        type:"POST",
        url: "http://127.0.0.1:8080/blog/good/operation/good",
        data: {number:id,situation:my.id},
        dataType: "json",
        success:function (data){
            if(data.code === 200){
                my.lastElementChild.innerHTML = data.message + my.lastElementChild.innerHTML;
            }else {
                my.lastElementChild.innerHTML = my.lastElementChild.innerHTML.replace("已","");
            }
        },error:function (){
            alert("获取失败");
        }
    })
}

function obtain(data){
    $("#yesterdayAdd").html(data.yesterdayAdd);
    $("#myCount").html(data.myCount);
    $("#lookTime").html(data.lookTime);
    $("#yesterdayGood").html(data.yesterdayGood);
}

function lookinvitation(my){
    window.open(`http://127.0.0.1:8080/blog/invitation/look/invitation?number=${my.parentNode.id}`);
}

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