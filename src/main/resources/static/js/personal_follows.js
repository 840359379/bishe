window.onload = function () {
  ajax_invitation();
};

// 关注的人的属性注入
function data_follow(follow) {
  // console.log(follow);
  if (follow) {
    follow.forEach((element) => {
      var fa = newdiv(document.getElementById("invitation_area"), "follow");
      fa.id = follow.a
      newimg(fa, "follow_format", "/static/picture/zhang.jpg");
      newp(fa, "follow_name", element.covername);
      newbutton(fa, "btn btn-success follow_button", "回关");
    });
  }
}

function ajax_invitation() {
  $.ajax({
    type: "GET",
    url: "http://127.0.0.1:8080/blog/follow/look/follow",
    dataType: "json", //返回的数据类型格式
    success: function (data) {
      if (data) {
        data_follow(data.data);
      } else {
        alert("数据获取失败");
      }
    },
    error: function () {
      //请求出错处理
      alert("数据请求失败");
    },
  });
}
