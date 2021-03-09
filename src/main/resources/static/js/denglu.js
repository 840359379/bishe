function onloads() {
}

function register(){
  $.ajax({
    type: "POST",
    url: "http://127.0.0.1:8080/blog/landing/register",
    data: { account: $("#upAccount").val(), password: $("#upPassword").val(),name:$("#name").val(),mailbox:$("#mailbox").val()},
    dataType: "json", //返回的数据类型格式
    success: function (data) {
      if (data.code === 200) {
        location.reload();
      } else {
        alert("失败");
      }
    },
    error: function (data) {
      //请求出错处理
      alert("请求出现错误，请重新尝试");
    },
  });
}

/**
 * 登录
 */
function ajax_user() {
  let id = document.getElementById("account").value;
  let pw = document.getElementById("password").value;
  //	  console.log(id);
  $.ajax({
    type: "POST",
    url: "http://127.0.0.1:8080/blog/landing/enroll",
    data: { id: id, pw: pw },
    dataType: "json", //返回的数据类型格式
    success: function (data) {
      if (data.code == 200) {
        window.location.href = "/blog/homepage/index";
      } else {
        alert("失败");
      }
    },
    error: function (data) {
      //请求出错处理
      alert("请求出现错误，请重新尝试");
    },
  });
}
