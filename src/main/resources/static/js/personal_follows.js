window.onload = function () {
  ajax_invitation();
};

// 关注的人的属性注入
function data_follow(follow) {
  if (follow) {
    follow.forEach((element) => {
      let fa = newdiv(document.getElementById("invitation_area"), "follow");
      fa.id = element.coveraccount;
      let img = newimg(fa, "follow_format", `/static/picture/${element.coveraccount}.jpg`);
      img.id = element.coveraccount;
      img.onclick = visitThis;
      newp(fa, "follow_name", element.covername);
      let button_follow = newbutton(fa, "btn btn-success follow_button", "取关");
      button_follow.onclick = ajaxDeleteFollow;
    });
  }
}

/**
 * 转发到个人主页
 */
function visitThis(){
  window.open(`http://127.0.0.1:8080/blog/visit/index?account=${this.id}`);
}
//取关操作
function ajaxDeleteFollow(){
  let id = this.parentNode.id;
  $.ajax({
    type: "POSt",
    url: "http://127.0.0.1:8080/blog/follow/delete/follow",
    data: {coveraccount:id,account:$("#material").attr("account")},
    dataType: "json",
    success:function (data){
      if(data.code === 200){
        location.reload()
      }else {
        alert("修改失败");
      }
    },error: function () {
      //请求出错处理
      alert("数据请求失败");
    }
  })
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
