<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" type="text/css" href="/WebClass/css/inform.css">
  <title>Starter's 정보</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
</head>

<body class="div-inline">
  <%@ include file="menu.jsp"%>
  <h1>그는 누구인가?</h1>
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
        <div class="image" id="WP">
          <div class="Bord">
            <br>
            <h3>15기 웹프로그래밍과 소속</h3>
            <br><h3>2학년 3반 32번</h3>
            <br><h3>최준용</h3>
            <br><h3>키는 170cm로 추정</h3>
            <br><h3>몸무게 45kg</h3>
            <br><h3>2000년 10월 23일생</h3>
            <br><h3>혈액형 : A형</h3>
            <br><h3>별자리 : 천칭 - 전갈자리</h3>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="image" id="HH">
          <div class="Bord">
            <br>
            <h3>15기 학생홍보팀 소속</h3>
            <br><h3>입학 설명회 의자 설치</h3>
            <br><h3>입학 설명회 원활한 진행 도움</h3>
            <br><h3>홍보 우편 포장 작업</h3>
            <br><h3>홍보 사진 촬영</h3>
            <br><h3>주차 관리 등</h3>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="image" id="DT">
          <div class="Bord">
            <br>
            <h3>15기 DETS STAFF 소속</h3>
            <br><h3>DETS 강의 개설</h3>
            <br><h3>DETS 강의 관리</h3>
            <br><h3>DETS 수강자 관리 등</h3>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="image" id="MPF">
          <div class="Bord">
              <br>
              <h3>15기 JNJ COMMUNICATIONS 소속</h3>
              <br><h3>Dimigo In 관리</h3>
              <br><h3>현재 JNJ 내에서 교육자로 활동 중</h3>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="image" id="RD">
          <div class="Bord">
            <br>
            <h3>15기 Rendezvous 소속</h3>
            <br><h3>Python을 이용한 인공지능 개발</h3>
            <br><h3>Python을 이용한 게임 개발</h3>
            <br><h3>OpenGL을 사용한 시뮬레이션 개발 등</h3>
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
  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</body>
</html>
