<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册界面</title>
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
 }
 .st >input[type='text'],input[type='password']{
    border:none;
    outline:none;
    height:35px;
    width:300px;
 }
 #submit{
      border:none;
      outline:none;
      height:35px;
      width:300px;
      background:#2b58ab;
      color:#fff;
      cursor:pointer;
      text-align:center;
 }
 #transfer{
    float:right;
    color:#fff;
    font-size:10px;
    text-decoration: none;
 }
</style>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery.min.js"></script>
</head>
<body>
  <div id="header"><span id="title" >欢迎注册</span></div>
  <div id="loginbg">
     <form  id="registerForm">
      <div id="cast">
          <div class="cast-title"><span>欢迎注册</span><a id="transfer" href="${pageContext.request.contextPath }/showLogin.do">直接登陆</a></div>
          <div class="st"><input type="text" id="username" name="username"  placeholder="请输入您的用户名"></div>
          <div class="st"><input type="password" id="password" name="password" placeholder="请输入您的密码"></div>
          <div class="st"><input type="password" id="spassword" name="spassword" placeholder="再次输入您的密码"></div>
          <div class="st"><input type="text" id="phone" name="phone" placeholder="请输入您的电话号码"></div>
          <div class="st"><input type="text" id="email" name="email" placeholder="请输入您的邮箱"></div>
          <div class="st"><input type="text" id="submit" value="注册"></div>
      </div>
      </form>
  </div>  
</body>
<script type="text/javascript">
  
   var isClick=false;
   $(function (){
	    console.log($("#registerForm").serialize());
	    $("#submit").click(function (){
	    	  //防止多次点击。
	    	 if(!isClick){
	    		 isClick=true;
	    	  $.ajax({
	    		  url:"../register.do",
	    		  type:"post",
	    		  data:$("#registerForm").serialize(),
	    		  dataType:"json",
	    		  success:function (result){    			   
	    			    alert(result.msg);
	    			    if(result.state==0){
	    				     window.location="../showLogin.do";
	    			    }
	    			    isClick=false;
	    		  },
	    		  error:function (e){
	    			  alert("系统异常");
	    		  }
	    	   });
	    	 }
	    });
   });
</script>
</html>