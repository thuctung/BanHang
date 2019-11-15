<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<LINK REL="SHORTCUT ICON" HREF="image/sanpham/logoTittle.png">
<title>Thế giới di đông </title>
<link href="stylesheet/timkiem.css" rel="stylesheet">

</head>
<body>
<!-- 	REQUIRE TEMPLATE HEADER -->
	<%@ include file="template/header.jsp" %> 
<!-- Done Header -->
<!-- CONTAINER -->
<div class ="container">
		<div class="thongtinsoluong">
			<p>Tìm thấy <strong>${listDT.size()+ listTL.size()} </strong> kết quả</p>
		</div>
		<div class="danhmucsoluong">
			<div class="soluong">
				<p>Điện thoại (${listDT.size()+0})</p>
			</div>
			<div class="soluong">
				<p>Tablet (${listTL.size()+0})</p>
			</div>
			<div class="soluong">
				<p>Laptop (0)</p>
			</div>
			<div class="soluong">
				<p>Đồng hồ (0)</p>
			</div>
			<div class="soluong">
				<p>Phụ kiện (0)</p>
			</div>
			<div class="soluong">
				<p>Tablet (0)</p>
			</div>
		</div>
		
	<c:if test = "${listDT.size() > 0}">
		<div class ="listdienthoai">
			<h1>Kết quả tìm kiếm <strong>Điện thoại</strong> </h1>
			<div class="listsanpham">
				<c:forEach items="${listDT}" var="dienthoai">
					<a href="./chitietsanpham?Masp=${dienthoai.getMaSanPham() }">
	            		<img src="image/sanpham/dienthoai/${dienthoai.getHinhAnh()} " width="180px" height="180px" />
	            		<p class="tenSanPham">${dienthoai.getTenSanPham() }</p>
	            		<c:set var = "dongia" value = "${dienthoai.getDonGia() }" />
	            		<p class="donGiaSP">
	            			<fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dongia}"/>đ
	            		</p>
           			</a>
				</c:forEach>
			</div>
		</div>
	</c:if>
		
	<c:if test = "${listTL.size() > 0}">
		<div class ="listdienthoai">
			<h1>Kết quả tìm kiếm <strong>Tablet</strong> </h1>
			<div class="listsanpham">
				<c:forEach items="${listTL}" var="tablet">
					<a href="./chitietsanpham?Masp=${tablet.getMaSanPham() }">
	            		<img src="image/sanpham/tablet/${tablet.getHinhAnh()} " width="180px" height="180px" />
	            		<p class="tenSanPham">${tablet.getTenSanPham() }</p>
	            		<c:set var = "dongia" value = "${tablet.getDonGia() }" />
	            		<p class="donGiaSP">
	            			<fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dongia}"/>đ
	            		</p>
           			</a>
				</c:forEach>
			</div>
		</div>
	</c:if>
</div>
<!-- XONGCONTAINER -->

<!-- HTML FOOTER -->
	<%@ include file="template/footer.jsp" %> 
<!-- XONG HML FOOTER -->	
    <script src="script/hienthisanpham.js"></script>
</body>
</html>