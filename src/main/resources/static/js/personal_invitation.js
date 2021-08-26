/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

window.onload = function () {
  document.getElementById("send").onclick = send;
};

function send() {
  var title = document.getElementById("title").value;
  var subtitle = document.getElementById("subtitle").value;
  var content = document.getElementById("content").innerHTML.replace(/<[^>]+>/g," ");
  console.log(content);
  $.ajax({
    type: "POST",
    url: "http://127.0.0.1:8080/blog/invitation/addInvitation",
    data: { title: title, subtitle: subtitle, text: content },
    dataType: "json", //返回的数据类型格式
    success: function (data) {
      if (data.code === 200) {
        location.reload();
        window.open(`http://127.0.0.1:8080/blog/invitation/look/invitation?number=${data.data}`);
      } else {
        alert("提交失败");
      }
    },
    error: function (data) {
      //未登录的时候
      alert("提交错误");
    },
  });
}