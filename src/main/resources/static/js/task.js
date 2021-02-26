function updateTask(my){
    if (my.innerHTML === "完成"){
        $.ajax({
            data:{task:my.id,status:2},
            url:"http://127.0.0.1:8080/blog/task/update/task",
            type:"POST",
            dataType:"json",
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