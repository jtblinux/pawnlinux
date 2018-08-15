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
 background-color:#eee!important;
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
  top:30px;
}
.paybtn{
  position:absolute;
  right:30px;
  bottom:30px;
}
#tool{
  padding: 20px 0px 20px 0px;
}
.card{
  height:100px;
  position:relative;
  border:1px solid #fff;
}
.describe{
  position:absolute;
  top:30px;
  left:30px;
}
.time{
  position:absolute;
  top:50px;
  left:30px;
}
.coash{
  position:absolute;
  top:25px;
  right:30px;
}
.appointbtn{
  position:absolute;
  top:50px;
  right:30px;
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
    <!-- 过滤层 -->
      <div id="classes">
        <div class="card">
          	<div class="describe">超级驾照套餐(一个月包过)</div>
          	<div class="time">2018-7-30 8:00:00~2018-7-30 11:30:00</div>
          	<div class="coash">胡教练</div>
        </div>
        <div class="card">
          	<div class="describe">超级驾照套餐(一个月包过)</div>
          	<div class="time">2018-7-30 8:00:00~2018-7-30 11:30:00</div>
          	<div class="coash">胡教练</div>
        </div>
     </div>  
  </div>
</div>
</body>
</html>