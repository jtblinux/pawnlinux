<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>头部</title>
</head>
<body>
  <div id="header">
     <div id="usermenu"><a class="step" id="user" href="${pageContext.request.contextPath  }/showPersoninfo.do">${user.username }</a>|<a class="step" href="${pageContext.request.contextPath  }/logout.do" id="exit">退出</a></div>
     <div style="clear:both;"></div>
  </div>
  <div id="tab">
    <a id="order" class="subtab" href="${pageContext.request.contextPath  }/showIndex.do">订单</a>
    <a id="appoint" class="subtab" href="${pageContext.request.contextPath  }/showAppoint.do">预约</a>
    <a id="appoint" class="subtab" href="${pageContext.request.contextPath  }/showMyappoint.do">我的预约</a>
  </div>
</body>
</html>