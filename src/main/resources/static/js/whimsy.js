function transformation(my){
    $("#iframe").attr("src",my.id);
}

function signIn(my){
    if(my.innerHTML === "签到"){
        $.ajax({
            dataType:"json",
            data:{status:1},
            url:"http://127.0.0.1:8080/blog/task/signIn",
            type:"POST",
            success:function (data){
                if(data.code){
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