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
      let button_follow = newbutton(fa, "btn btn-success follow_button", "回关");
      button_follow.onclick = ajax_add_follow;
      let button_delete = newbutton(fa, "btn btn-secondary follow_button", "删除");
      button_delete.onclick = ajaxDeleteFollow;
    });
  }
}

function ajaxDeleteFollow(){
  let id = this.parentNode.id;
  $.ajax({
    type: "POSt",
    url: "http://127.0.0.1:8080/blog/follow/delete/follow",
    data: {account:id,coveraccount:$("#material").attr("account")},
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

//添加关注的ajax
function ajax_add_follow(){
  let id = this.parentNode.id;
  $.ajax({
    type: "POST",
    dataType: "json",
    url: "http://127.0.0.1:8080/blog/follow/add/follow",
    data: {coveraccount:id,account:$("#material").attr("account"),name:$("#name").text(),covername:this.previousElementSibling.innerHTML},
    success:function (data){
      if(data.code === 200){
        if(data.data){
          window.location.replace("/blog/personal/follow");
        }else {
          alert(data.message);
        }
      }else {
        alert("失败了");
      }
    },error:function (){
      alert("获取失败");
    }
  })
}

//获取粉丝数据的ajax
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
