<%@page import="detai.cnjva.modelFile.UserInfo"%>
<%@page import="detai.cnjva.DAOFile.UserInfoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% ArrayList<UserInfo> list = new ArrayList<UserInfo>();
		UserInfoDAO userifDao = new UserInfoDAO();
		list = userifDao.getAllUserInfo();	
		for(UserInfo user : list){
	%>	
		<h1><%= user.getEmail() %></h1>
	<%} %>
	<%=  list.size()%>
	<h2>ngu</h2>
</body>
</html>