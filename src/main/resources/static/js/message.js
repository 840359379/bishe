window.onload = function () {
    ajaxObtain();
}

function deleteMessage(my){
    if (confirm("你确定要删除留言吗")) {
        $.ajax({
            type: "POST",
            data:{id:my.parentNode.id},
            dataType: "json",
            url: "http://127.0.0.1:8080/blog/message/delete/message",
            success:function (data){
                if(data.code === 200){
                    location.reload();
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
 * 关于一些属性的注入
 * @param data
 */
function obtain(data){
    $("#yesterdayAdd").html(data.yesterdayAdd);
    $("#myCount").html(data.myCount);
    $("#lookTime").html(data.lookTime);
    $("#yesterdayGood").html(data.yesterdayGood);
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

