/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

window.onload = function () {
  initializationAjax();
};

/**
 * 转到个人主页
 * @param my
 */
function visitThis(my){
  window.open(`http://127.0.0.1:8080/blog/visit/index?account=${my.parentNode.getAttribute("abbr")}`);
}

/**
 * 关于贴子初始化
 */
function initializationAjax(){
  $.ajax({
    type:"GET",
    dataType:"JSON",
    url:"http://127.0.0.1:8080/blog/good/look/goodNumber",
    data:{number:$("#number").attr("abbr")},
    success:function (data){
      if(data.code === 200){
        $("#good-text").html(data.data.count);
        if(data.data.situation === 1){
          $("#good_img").attr("fill","#FF0000")
        }else {
          $("#good_img").attr("fill","#696969")
        }
        $("#good-text").attr("abbr",data.data.situation);
        data.data.collection == 1 ? $("#collectionDate").html("取消收藏") : $("#collectionDate").html("收藏");
      }else {
        alert("操作失败");
      }
    },error:function (){
      alert("请求出现错误，请重新尝试");
    }
  })
}

function addCollection(my){
  $.ajax({
    type:"POST",
    url: "http://127.0.0.1:8080/blog/collection/operation/collection",
    data: {number:$("#number").attr("abbr")},
    dataType: "json",
    success:function (data){
      if(data.code == 200){
        my.lastElementChild.innerHTML = data.msg;
      }else {
        alert("操作失败");
      }
    },error:function (){
      alert("获取失败");
    }
  })
}

/**
 * 点赞的函数
 */
function addGood(){
  let situation = $("#good-text").attr("abbr") == 0 ? 1 : 0;
  $.ajax({
    type: "POST",
    dataType: "JSON",
    url: "http://127.0.0.1:8080/blog/good/operation/good",
    data: {number: $("#number").attr("abbr"),situation:situation},
    success:function (data){
      if(data.code >= 200 && data.code < 300){
        location.reload();
      }else {
        alert("操作失败");
      }
    },error:function (){
      alert("获取失败");
    }
  })
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
    data: {number:$("#number").attr("abbr"),account:my.id,content:$("#publish-text").val()},
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

/**
 * 关于投币框的显示
 * @param my
 */
function turnOn(my){
  if($("#addCoin").css("opacity")==0){
    $("#addCoin").attr('style','opacity:1;');
  }else {
    $("#addCoin").attr('style','opacity:0;');
  }
}
/**
 * 关于投币框的显示
 */
function shutOff(){
  $("#addCoin").attr('style','opacity:0;');
}

/**
 * 向后端发送投币的请求
 * @param my
 */
function addCoin(my){
  let count = $("#content-text").val();
  // console.log(count);
  $.ajax({
    type:"POST",
    url:"http://127.0.0.1:8080/blog/whimsy/add/coin",
    data:{count:count,coverAccount:$("#user").attr("abbr"),number: $("#number").attr("abbr")},
    dataType:"JSON",
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