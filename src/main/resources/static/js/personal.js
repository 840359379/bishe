/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

window.onload = function () {
};

//修改资料的按钮事件
function modify() {
  var unconventional = document.getElementsByClassName("unconventional")[1];
  unconventional.className = "important unconventional";
  //此时加载表单的检查事件
  judge();
}
//取消按钮的事件
function invisible() {
  var unconventional = document.getElementsByClassName("unconventional")[1];
  unconventional.className = "important unconventional display_none";
}

//修改资料的ajax
function submission() {
  let changes = document.getElementsByName("changes");
  $.ajax({
    type: "POST",
    url: "http://127.0.0.1:8080/blog/landing/updateuser",
    data: {
      name: changes[0].value,
      personality: changes[4].value,
      mailbox: changes[1].value,
      gender: changes[2].value,
      birthday: changes[3].value,
    },
    dataType: "json", //返回的数据类型格式
    success: function (data) {
      location.reload();
    },
    error: function () {
      //请求出错处理
      alert("修改失败");
    },
  });
}

//检查
function judge() {
  var inputs = document.getElementsByName("changes");
  for (var x = 0; x < inputs.length; x++) {
    inputs[x].onfocus = onfocus_judge;
    inputs[x].onblur = onblur_judge;
  }
}

//输入框获得焦点的时候触发的事件
function onfocus_judge(){
  // console.log(this.nextElementSibling);
  this.nextElementSibling.className = "change_vice visibility_none";
}

//输入表单失去焦点时的事件
function onblur_judge(){
  var bool = main(this);
  // console.log(bool);
  if(!bool){
    this.nextElementSibling.className = "change_vice";
  }
}