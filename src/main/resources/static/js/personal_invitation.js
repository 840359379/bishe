window.onload = function () {
  document.getElementById("send").onclick = send;
};

function send() {
  var title = document.getElementById("title").value;
  var subtitle = document.getElementById("subtitle").value;
  var content = document.getElementById("content").innerHTML;
  console.log(content);
  $.ajax({
    type: "POST",
    url: "http://127.0.0.1:8080/blog/invitation/addInvitation",
    data: { title: title, subtitle: subtitle, text: content },
    dataType: "json", //返回的数据类型格式
    success: function (data) {
      if (data.data) {
        alert("提交成功");
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