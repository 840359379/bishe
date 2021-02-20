window.onload = function () {
  data_rili_time();
  this.setInterval("data_rili_time()", 1000);
  ajax_invitation();
};

//日历的更新
function data_rili_time() {
  var data = new Date();
  // console.log(data.getFullYear());
  document.getElementsByClassName(
    "data_rili"
  )[0].innerHTML = `${data.getFullYear()}-${data.getMonth()}-${data.getDate()} ${data.getHours()}:${data.getMinutes()}:${data.getSeconds()}`;
}

//关于帖子的属性注入
function post_area_entity(data) {
  for (var x = 0; x < data.length; x++) {
    //		console.log(data[x]);
    var divfa = newdiv(
      document.getElementById("invitation_area"),
      "post_area_entity"
    );
    divfa.id = data[x]["number"];
    divfa.onclick = lookinvitation;
    newh(divfa, "title", data[x]["title"], "3");
    newp(divfa, "subtitle", data[x]["subtitle"]);
    newp(divfa, "post_data", data[x]["time"]);
    newp(divfa, "post_data", `作者:${data[x]["name"]}`);
    //	    newp(divfa, "post_data", "4");
  }
}

//看帖子转发连接
function lookinvitation() {
  var url = `http://127.0.0.1:8080/blog/invitation/look/invitation?number=${this.id}`;
  window.open(url);
}


function ajax_invitation() {
  if(($("#hidden").attr("abbr"))===undefined){
    $.ajax({
      type: "POST",
      url: "http://127.0.0.1:8080/blog/homepage/invitations",
      dataType: "json", //返回的数据类型格式
      success: function (data) {
        post_area_entity(data.data);
      },
      error: function () {
        //请求出错处理
        alert("请求出现错误，请重新尝试");
      },
    });
  }else {
    $.ajax({
      type: "POST",
      url: "http://127.0.0.1:8080/blog/homepage/search/invitations",
      data:{search:($("#hidden").attr("abbr"))},
      dataType: "json", //返回的数据类型格式
      success: function (data) {
        post_area_entity(data.data);
      },
      error: function () {
        //请求出错处理
        alert("请求出现错误，请重新尝试");
      },
    });
  }
}
