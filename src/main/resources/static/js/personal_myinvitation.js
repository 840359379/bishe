
//看帖子转发连接
function lookinvitation(data) {
  var url = `http://127.0.0.1:8080/blog/invitation/look/invitation?number=${data.id}`;
  window.open(url);
}
