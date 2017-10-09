function plzLogin() {
  alert('로그인을 먼저 해주세요!');
}

$(document).ready(function() {
  $('#SF').submit(function(event) {
    event.preventDefault();
    var num = $('#num').val();
    var name = $('#name').val();
    $.post("http://httpbin.org/post", {
        num: num,
        name: name
      },
      function(data) {
        var mm = $('#mymodal-ss');
        mm.modal();
        mm.find(".modal-body").text(data.form.name + "님 회원가입 되었습니다.");
      });
  });
});
