<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<LINK REL="SHORTCUT ICON" HREF="image/sanpham/logoTittle.png">
<link href="stylesheet/header.css" rel="stylesheet">

<link href="stylesheet/footer.css" rel="stylesheet">
<link href="stylesheet/quanly.css" rel="stylesheet">
<link href="stylesheet/donhang.css" rel="stylesheet">
<link href="stylesheet/login.css" rel="stylesheet">
<link href="stylesheet/quanlytaikhoan.css" rel="stylesheet">
<title>Quản Lý</title>
</head>
<body>
	<div class="denbaophu"></div>
	<div class="header">
		<div class="contentHeader">
			<div class="logo">
				<div class="home">
					<a href="./" class="avartarr"></a> 
					<a href="./" class="titlee"></a>
				</div> 
				<a class="items" href="./logoutadmin">
				 <img class="imgLogin" src="image/adminlogout.png" />
					<p class="plogin">Logout</p>
				</a>
			</div>
		</div>
	</div>

	<div class="containerr">
		<div class="menu">
			<ul class="menu-area">
				<li><a href="">Quản lý sản phẩm</a>
					<ul>
						<li><a href="">Danh sách sản phẩm </a></li>
						<li><a href="">Thêm sản phẩm</a></li>
					</ul></li>
				<li><a href="quanlytaikhoan">Quản lý tài khoản</a>
<!-- 					<ul>
						<li><a href="quanlytaikhoan">Danh sách tài khoản</a></li>
						<li><a href="">Thêm tài khoản quản lý</a></li>
					</ul></li> -->
				<li><a href="">Thay đổi quảng cáo</a></li>
				<li><a href="quanlydonhang?tinhtrang=0">Quản lý đơn hàng</a>
					<c:if test="${sodonhangchoxacnhan > 0}"><p class="sodonhang">${sodonhangchoxacnhan}</p></c:if>
				</li>
			</ul>
		</div>
		<div class="content">
			<!-- chucnang = 1 thì sẽ trả về trang quản lý đơn hàng 
				biến chucnang được khai báo trong controller-->
			<c:if test="${chucnang == 1}">
				<%@ include file="template/DonHang.jsp" %> 
			</c:if>
			<!-- chucnang = 2 thì sẽ trả về trang quản lý tài khoản -->
			<c:if test="${chucnang == 2 }">
				<%@ include file="template/TaiKhoan.jsp" %>
			</c:if>
			<!-- chucnang = 3 thì sẽ trả về trang thay đổi thông tin-->
			<c:if test="${chucnang == 3 }">
				<%@ include file="template/thaydoithongtin.jsp" %>
			</c:if>
		</div>
	</div>
	<script src="script/donhang.js"></script>
	<script src="script/login.js"></script>
	<script src="script/quanlytaikhoan.js"></script>
	<script src="script/updateuser.js"></script>
</body>
</html>