/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

var picture = [];

function addWhimsy(){
    console.log(picture);
    console.log(picture[0]);
    console.log($('#uploadFile').get(0).files[0])
    let formFile = new FormData();
    formFile.append("action", "UploadVMKImagePath");
    for(let x=0;x < picture.length; x++){
        formFile.append("file",picture[x]);
    }
    formFile.append("title",$("#title").val());
    formFile.append("subtitle",$("#subtitle").val());
    formFile.append("route",$("#route").val());
    $.ajax({
        type:"POST",
        dataType:"json",
        cache: false,//上传文件无需缓存
        processData: false,//用于对data参数进行序列化处理 这里必须false
        contentType: false, //必须
        data:formFile,
        url:"http://127.0.0.1:8080/blog/whimsy/increase/whimsy",
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

window.onload=function(){
    let input=document.getElementById("uploadFile");
    let div;
    // 当用户上传时触发事件
    input.onchange=function(){
        readFile(this);
    }
    //处理图片并添加都dom中的函数
    let readFile=function(obj){
        // 获取input里面的文件组
        let fileList=obj.files;
        //对文件组进行遍历，可以到控制台打印出fileList去看看
        for(let i=0;i<fileList.length;i++){
            let reader= new FileReader();
            picture.push(fileList[i]);
            reader.readAsDataURL(fileList[i]);
            // 当文件读取成功时执行的函数
            reader.onload=function(e){
                let fa = document.getElementById("img-box");
                let div = newdiv(fa,"card file-box");
                newimg(div,"card-img ",this.result);
            }
        }
    }
}