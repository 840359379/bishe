window.onload = function () {
  ajax_invitation();
};

function data_good(data, my) {
  document.getElementById("good").innerHTML = `${data.length} 人赞同`;
  data.forEach((element) => {
    if (element.account === my.account) {
      console.log(
        document.getElementById("good_img").setAttribute("fill", "red")
      );
    }
  });
}