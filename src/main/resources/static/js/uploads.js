/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

/**
 * 关于上传框的样式
 */
$(document).ready(function () {
    bsCustomFileInput.init()
})

/**
 * 下载文件的
 * @param my
 */
function uploads(my){
    window.open(`http://127.0.0.1:8080/blog/uploads/select/uploads?name=${my.parentNode.firstElementChild.innerHTML}`);
}

function deleteUploads(my){

}

/**
 * 上传文件的ajax
 */
function addUploads(){
    let formFile = new FormData();
    formFile.append("action", "UploadVMKImagePath");
    formFile.append("file", $('#inputGroupFile01').get(0).files[0]);
    formFile.append("name",$("#content-text").val());
    $.ajax({
        data:formFile,
        type:"POST",
        dataType:"json",
        cache: false,//上传文件无需缓存
        processData: false,//用于对data参数进行序列化处理 这里必须false
        contentType: false, //必须
        url:"http://127.0.0.1:8080/blog/uploads/add/uploads",
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

