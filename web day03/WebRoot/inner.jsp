<%@page import="com.zr.entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page  import="java.io.*" %>
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
	<style type="text/css">
	table{
	border: 1px solid gray;
	border-collapse: collapse;
	width:100%;
	}
	td{
	border: 1px solid gray;
	}
	</style>
	<%
	//从request中取出集合
	List<Student> list = (List<Student>)request.getAttribute("students");
	%>
  </head>
  
  <body>
    <table>
    	<tr>
    		<td>编号</td>
    		<td>名称</td>
    		<td>URL</td>
    		<td>ID</td>
    		<td>国籍</td>
    		<td>操作</td>
    	</tr>
    	<%
    	if(list != null){
    		for(Student s : list){ 
        		%>
        		<tr>
        			<td><%=s.getId() %></td>
        			<td><%=s.getStuno() %></td>
        			<td><%=s.getName() %></td>
        			<td><%=s.getGender() %></td>
        			<td><%=s.getAge() %></td>
        			<td><a href="StudentDelServlet?id=<%=s.getId() %>">删除</a>
        			<a href="stuch.jsp">修改</a>
        			<a href="stuins.jsp?id=<%=s.getId() %>">增加</a>
        			<a href="stuser.jsp">查找</a>
        			</td>
        		</tr>
        		<%
        	}
    	}
    	%>
    </table>
  </body>
</html>









