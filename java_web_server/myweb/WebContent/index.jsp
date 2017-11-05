<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  
   <form action="<%=basePath%>servlet/LoginServlet" method="post">
  用户：<input type="text" name="userID"><br/>
  密码:<input type="text" name="password"><br/>
  <input type="submit" value="提交">
  </form>
  
  <%--  <form action="${pageContext.request.contextPath}/servlet/UploadHandleServlet" enctype="multipart/form-data" method="post">
  上传用户：<input type="text" name="username"><br/>
  上传文件1：<input type="file" name="file1"><br/>
  上传文件2：<input type="file" name="file2"><br/>
  <input type="submit" value="提交">
 </form>
 
 <a href="<%=basePath%>/servlet/DownLoadServlet?filename=001.png">001.png 下载</a>
  --%>
  </body>
</html>
