window.onload = function () {
    begin();
}

function conversion(my){
    $("#conversion").attr("src",my.getAttribute("href"));
}

/**
 * 关于操作的关注的操作
 * @param my
 */
function addFollow(my){
    if($("#follow").text()==="关注"){
        $.ajax({
            dataType:"json",
            data:{coveraccount:my.parentNode.getAttribute("abbr"),covername:$("#name").text()},
            url:"http://127.0.0.1:8080/blog/follow/add/follow",
            type:"POST",
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
    }else {
        if (confirm("你确定要取消关注吗")) {
            $.ajax({
                dataType:"json",
                data:{coveraccount:my.parentNode.getAttribute("abbr")},
                url:"http://127.0.0.1:8080/blog/follow/delete/follow",
                type:"POST",
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
    }
}

function begin(){
    $.ajax({
        type: "GET",
        url: "http://127.0.0.1:8080/blog/follow/existence",
        data: {coveraccount:$("#account").attr("abbr")},
        dataType: "json",
        success:function (data){
            if(data.data === true){
                $("#follow").html("已关注");
            }
        },
        error:function (){
            alert("请求出现错误，请重新尝试");
        }
    })
}