<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎界面</title>
<style type="text/css">
 *{
    padding:0px;
    margin:0px;
 }
 #loginbg{
    height:600px;
    background-image:url("../img/timg.jpg");
    background-repeat: no-repeat;
    background-size: 100% 600px;
    position:relative;
 }
 #header{
    font-size:30px;
    font-weight: bolder;
    position:relative;
    height:100px;
 }
 #title{
    position:absolute;
    left:200px;
    top:20px;
 }
 #cast{
    position:absolute;
    background-color:rgba(0,0,0,0.7);
    width:300px;
    right:40px;
    top:70px;
    padding:10px;
    color:#fff;
 }
 .cast-title{
    border-bottom:1px solid #fff;
    padding-bottom:10px;
 }
 .st{
    height:70px;
    line-height:70px;
    margin-top:20px;
 }
 .st >input[type='text'],input[type='password']{
    border:none;
    outline:none;
    height:35px;
    width:300px;
 }
 input[type='submit']{
      border:none;
      outline:none;
      height:35px;
      width:300px;
      background:#2b58ab;
      color:#fff;
      cursor:pointer;
 }
#transfer{
    float:right;
    color:#fff;
    font-size:10px;
    text-decoration: none;
 }
</style>
</head>
<body>
  <div id="header"><span id="title">欢迎登陆</span></div>
  <div id="loginbg">
     <form action="${pageContext.request.contextPath }/login.do" method="post">
      <div id="cast">
          <div class="cast-title"><span>欢迎登陆</span><a id="transfer" href="${pageContext.request.contextPath }/showRegister.do">欢迎注册</a></div>
          <div class="st"><input type="text" id="username" name="username"  placeholder="请输入您的用户名"></div>
          <div class="st"><input type="password" id="password" name="password" placeholder="请输入您的密码"></div>
          <div class="st"><input type="submit" value="登陆"></div>
      </div>
      </form>
  </div>
</body>
</html>