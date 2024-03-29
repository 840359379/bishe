/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

window.onload = function () {
    begin();
}

/**
 * 转到的函数
 * @param my
 */
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

/**
 * 关注的按钮事件
 */
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

function privateChat(){
    window.location.href = `/blog/chat/index?account=${$("#account").attr("abbr")}`;
    // $.ajax({
    //     type:"POST",
    //     url:"http://",
    //     data:{account:},
    //     dataType:"JSON"
    // })
}