
/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

//看帖子转发连接
function lookinvitation(data) {
  var url = `http://127.0.0.1:8080/blog/invitation/look/invitation?number=${data.id}`;
  window.open(url);
}
