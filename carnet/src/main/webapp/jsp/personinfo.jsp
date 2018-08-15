<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>头部</title>
<style type="text/css">
*{
  padding:0;
  margin:0;
}

#outframe{
  width:1000px;
  margin:0 auto;
}
#header{
   padding: 10px; 
   color:#19536f;
}
#usermenu{
  float:right; 
}
.step{
  margin-left:5px;
}
#exit{
  cursor:pointer;
}
#content{
  height:100px;
  padding:0px 10px 0px 10px;
}
#tab{
  border-bottom:3px solid #ccc;
  height:40px;
}
.subtab{
  height:40px;
  line-height:40px;
  margin-right:30px;
  cursor:pointer;
}
.card{
  height:100px;
  position:relative;
  border:2px solid #ccc;
}
.describe{
  position:absolute;
  top:30px;
  left:30px;
}
.money{
  position:absolute;
  right:30px;
  top:30px;
}
.paybtn{
  position:absolute;
  right:30px;
  bottom:30px;
}
.box{
   height:90px;
   border-bottom:1px solid #ccc;
}
.st{
  line-height:90px;
}
#save{
  background-color:#0f66e8;
  color:#ccc;
  padding:10px;
  border-radius:4px;
  cursor:pointer;
}
a{
   text-decoration: none;
   color:#000;
}
</style>
</head>
<body>
<div id="outframe">
   <jsp:include page="header.jsp"></jsp:include>
  <div id="content">
     <div class="box"><span class="st">用户名:</span>&nbsp;&nbsp;<span class="st" id="username"></span></div>
     <div class="box"><span class="st">性别:</span>&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="0" checked name="gender" id="man" class="gender">
     <label for="man">男</label>
     &nbsp;&nbsp;<input type="radio" name="gender" value="1" id="woman" class="gender"><label for="woman">女</label></div>
     <div class="box"><span class="st">邮箱:</span>&nbsp;&nbsp;<input type="text" id="email"></div>
     <div class="box"><span class="st">电话:</span>&nbsp;&nbsp;<input type="text" id="phone"></div>
     <div class="box"><span class="st" id="save">保存修改</span></div>
  </div>
</div>
</body>
</html>