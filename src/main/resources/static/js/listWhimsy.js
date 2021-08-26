/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

function goWhimsy(my){
    window.location.href = `/blog/whimsy/look/whimsy?account=${my.id}&&series=${my.getAttribute("abbr")}`;
}