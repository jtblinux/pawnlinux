<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
<style type="text/css">
*{
  padding:0;
  margin:0;
}
body{
  background-color:#fff;
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
  background-color:#0066ff;
  color:#fff;
  margin-top:10px;
  border:1px solid #fff;
}
.describe{
  position:absolute;
  top:30px;
  left:30px;
}
.money{
  position:absolute;
  right:30px;
  top:25px;
}
.paybtn{
  position:absolute;
  right:30px;
  bottom:25px;
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
     <div class="card">
        <div  class="describe">超级驾照套餐(一个月包过)</div>
        <div  class="money">$5000</div>
        <div class="paybtn">付款</div>
     </div>
     <div class="card">
        <div  class="describe">中级驾照套餐(二个月包过)</div>
        <div  class="money">$4000</div>
        <div class="paybtn">付款</div>
     </div>
   
  </div>
</div>
</body>
</html>