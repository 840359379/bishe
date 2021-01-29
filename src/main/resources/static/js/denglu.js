function onloads() {
  p_onclick();
}

function onfocus_0(my) {
  var p = document.getElementById(my.name);
  p.style.visibility = "hidden";
  var warning = document.getElementById("warning");
  warning.className = "wa dis";
}

function onblur_0(my) {
  var p = document.getElementById(my.name);
  if (my.value == 0) p.style.visibility = "visible";
}

function verification() {
  var inputs = document.getElementsByClassName("Box");
  for (var x = 0; x < inputs.length; x++) {
    if (inputs[x].value == 0) {
      alert("密码或账号为空");
      return false;
    }
  }
}
function p_onclick() {
  var ps = document.getElementsByClassName("form_0");
  [].forEach.call(ps, function (p) {
    p.onclick = function () {
      document.getElementsByName(this.id)[0].select();
    };
  });
}

function ajax_user() {
  let id = document.getElementById("sid").value;
  let pw = document.getElementById("spw").value;
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
        $("#warning").removeClass("dis");
      }
    },
    error: function (data) {
      //请求出错处理
      alert("请求出现错误，请重新尝试");
    },
  });
}
