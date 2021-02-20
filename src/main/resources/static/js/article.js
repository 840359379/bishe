/**
 * 转到个人主页
 * @param my
 */
function visitThis(my){
  window.open(`http://127.0.0.1:8080/blog/visit/index?account=${my.parentNode.getAttribute("abbr")}`);
}

/**
 * 添加一个评论
 * @param my
 */
function addContent(my){
  $.ajax({
    type: "POST",
    dataType: "json",
    url: "http://127.0.0.1:8080/blog/content/add/content",
    data: {number:$("#number").attr("abbr"),account:my.id,content:$("#content-text").val()},
    success:function (data){
      if(data.code === 200){
        location.reload();
      }else {
        alert("操作失败");
      }
    },error:function (){
      alert("请求出现错误，请重新尝试");
    }
  })
}

/**
 * 删除一个评论
 * @param my
 */
function deleteContent(my){
  // console.log($("#contentStartTime").text());
  // console.log(my.parentNode.parentNode.id);
  if (confirm("你确定要删除评论 吗")) {
      $.ajax({
        type:"POST",
        data:{id:my.parentNode.parentNode.id},
        dataType:"json",
        url:"http://127.0.0.1:8080/blog/content/delete/content",
        success:function (data){
          if(data.code === 200){
            location.reload();
          }else {
            alert("操作失败");
          }
        },error:function(){
          //请求出错处理
          alert("请求出现错误，请重新尝试");
        }
      })
  }
}

/**
 * 关于背景的js
 */
$(document).ready(function(){
  var stars=2000;  /*星星的密集程度，数字越大越多*/
  var $stars=$(".stars");
  var r=800;   /*星星的看起来的距离,值越大越远,可自行调制到自己满意的样子*/
  for(var i=0;i<stars;i++){
    var $star=$("<div/>").addClass("star");
    $stars.append($star);
  }
  $(".star").each(function(){
    var cur=$(this);
    var s=0.2+(Math.random()*1);
    var curR=r+(Math.random()*300);
    cur.css({
      transformOrigin:"0 0 "+curR+"px",
      transform:" translate3d(0,0,-"+curR+"px) rotateY("+(Math.random()*360)+"deg) rotateX("+(Math.random()*-50)+"deg) scale("+s+","+s+")"

    })
  })
})