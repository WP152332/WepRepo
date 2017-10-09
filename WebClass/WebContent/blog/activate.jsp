<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" type="text/css" href="/WebClass/css/activate.css">
  <!-- Bootstrap CSS -->
  <title>Starter's 활동</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
</head>

<body class="div-inline">
  <%@ include file="menu.jsp"%>
  <h1>그는 무얼하는가?</h1>
  <br>
  <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators" id="OlBar">
      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
    </ol>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <div class="image" id="VS">
          <div class="Bord">
            <br>
            <h3>Visual Studio 사용자</h3>
            <br><h3>C 개발에 사용</h3>
            <br><h3>C++ 개발에 사용</h3>
            <br><h3>C# 개발에 사용</h3>
            <br><h3>UWP 개발에 사용</h3>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="image" id="Pycharm">
          <div class="Bord">
            <br>
            <h3>Pycharm 사용자</h3>
            <br><h3>Python 개발에 사용</h3>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="image" id="Atom">
          <div class="Bord">
            <br>
            <h3>Atom 사용자</h3>
            <br><h3>HTML 개발에 사용</h3>
            <br><h3>CSS 개발에 사용</h3>
            <br><h3>JavaScript 개발에 사용</h3>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="image" id="C">
          <div class="Bord">
            <br>
            <h3>C언어 개발자</h3>
            <br><h3>가장 오래한 언어</h3>
            <br><h3>초등학교 5학년 시작</h3>
            <br><h3>정보 올림피아드 수상 경력</h3>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="image" id="Python">
          <div class="Bord">
              <br>
              <h3>Python 개발자 (학습 중)</h3>
              <br><h3>Tensorflow 학습 중</h3>
              <br><h3>게임 개발에 사용 중</h3>
          </div>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  <!-- Modal -->
  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</body>
</html>
