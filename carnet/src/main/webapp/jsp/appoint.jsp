<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<title>头部</title>
<!-- DHtmlX 日期控件 -->
<link rel="stylesheet" type="text/css" href="../static/dhtmlx/codebase/fonts/font_roboto/roboto.css"/>
<link rel="stylesheet" type="text/css" href="../static/dhtmlx/codebase/dhtmlxcalendar.css">
<script type="text/javascript" src="../static/dhtmlx/codebase/dhtmlxcalendar.js"></script> 
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
     <div id="tool">
        <span>教练:&nbsp;</span><input type="text" id="coashsearch">
        <span>开始时间:&nbsp;</span><input type="text" id="starttime"><span><img id="calendar_icon1" src="../img/calendar.png" border="0"></span>
        &nbsp;&nbsp;&nbsp;
        <span>结束时间:&nbsp;</span><input type="text" id="endtime"><span><img id="calendar_icon2" src="../img/calendar.png" border="0"></span>
        &nbsp;&nbsp;&nbsp;
        <span>查询</span>
     </div>
     <div id="classes">
        <div class="card">
          	<div class="describe">超级驾照套餐(一个月包过)</div>
          	<div class="time">2018-7-30 8:00:00~2018-7-30 11:30:00</div>
          	<div class="coash">胡教练</div>
          	<div class="appointbtn">预约</div>
        </div>
        <div class="card">
          	<div class="describe">超级驾照套餐(一个月包过)</div>
          	<div class="time">2018-7-30 8:00:00~2018-7-30 11:30:00</div>
          	<div class="coash">胡教练</div>
          	<div class="appointbtn">预约</div>
        </div>
     </div>
     <div style="clear:both;"></div>
  </div>
</div>
<script type="text/javascript">
    var myCalendar1,myCalendar2;
    window.onload=function (){
        //events handlers
  	   myCalendar1=new dhtmlXCalendarObject({input:"starttime",button:"calendar_icon1"}); 
  	   myCalendar2=new dhtmlXCalendarObject({input:"endtime",button:"calendar_icon2"}); 
        //禁止日期框输入
        var starttime=document.getElementById("starttime");
        var endtime=document.getElementById("endtime");
        starttime.onkeypress=function (e){
        	  e.preventDefault();
        	  return false;
        }
        endtime.onkeypress=function (e){
      	  e.preventDefault();
    	  return false;
        }    
    }
	
</script>
</body>
</html>