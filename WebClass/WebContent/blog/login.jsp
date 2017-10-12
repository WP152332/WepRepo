<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" type="text/css" href="/WebClass/css/myblog.css">
  <!-- Bootstrap CSS -->
  <title>Stater's 로그인</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
      <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</head>

<body class="div-inline">
 <div class="row">
    <div class="col-6 col-md-4">
    </div>
    <div id="RB" class="col-6 col-md-4">
      <div class="inBox">
        <h1>로그인해서 <br> 다양한 컨텐츠를 <br> 즐기세요!</h1><br>
        <form class="form my-2 my-lg-0" action="/WebClass/bloglogin" method="post" id="LF">
          <input class="form-control mr-sm-2" type="text" placeholder="ID" aria-label="ID" id="id" name="id"
          <% if(request.getParameter("id") != null) {%>
		  value="<%= request.getParameter("id")%>" <% } %>  required>
          <input class="form-control mr-sm-2" type="password" placeholder="Password" aria-label="Password" id="pwd" name="pwd"
          <% if(request.getParameter("pwd") != null) {%>
		  value="<%= request.getParameter("pwd")%>" <% } %>  required>
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">로그인</button>
        </form>
      </div>
      <div class="inBox">c
        <h1>아직 계정이 없으신가요?</h1><br>
        <form class="form my-2 my-lg-0" id="SF">
          <div id="GRDIV">
            <input class="GR" type="radio" name="grade" value="1" required>1학년
            <input class="GR" type="radio" name="grade" value="2">2학년
            <input class="GR" type="radio" name="grade" value="3">3학년 <br>
          </div>
          <select name="list" id="LS" required>
            <option value="">당신의 반을 선택하세요!</option>
            <option value="1">1반</option>
            <option value="2">2반</option>
            <option value="3">3반</option>
            <option value="4">4반</option>
            <option value="5">5반</option>
            <option value="6">6반</option>
          </select>
          <input class="form-control mr-sm-2" type="text" placeholder="번호" aria-label="num" id="num" required>
          <input class="form-control mr-sm-2" type="text" placeholder="이름" aria-label="name" id="name" required>
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">회원가입</button>
        </form>
      </div>
    </div>
    <div class="col-6 col-md-4">
    </div>
  </div>
  <!-- Modal -->
  <div class="modal" id="myModal">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLongTitle">JOIN</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        ...
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>

  <div class="modal" id="mymodal-ss">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="signModalLongTitle">회원가입 결과</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        </div>
        <div class="modal-body">
          ...
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
  <script>
	<%
	if("error".equals(request.getAttribute("msg"))) {
		
	%>	
		var myModal = $('#myModal');
		myModal.find('.modal-title').text('Login Error');
		myModal.find('.modal-body').text('Invalid username or password');
		myModal.modal();
	<%
	}
	%>
	</script>
</body>
</html>
