window.onload = function () {
  ajax_invitation();
};

// 粉丝的属性注入
function data_follow(follow) {
  // console.log(follow);
  if (follow) {
    follow.forEach((element) => {
      var fa = newdiv(document.getElementById("invitation_area"), "follow");
      fa.id = element.account;
      newimg(fa, "follow_format", "/static/picture/timg.jpg");
      newp(fa, "follow_name", element.name);
      newbutton(fa, "btn btn-secondary follow_button", "删除");
    });
  }
}

function ajax_invitation() {
  $.ajax({
    type: "GET",
    url: "http://127.0.0.1:8080/blog/follow/look/cover",
    dataType: "json", //返回的数据类型格式
    success: function (data) {
      if (data) {
        data_follow(data.data);
      } else {
        alert("数据错误");
      }
    },
    error: function () {
      //请求出错处理
      alert("获取失败");
    },
  });
}
