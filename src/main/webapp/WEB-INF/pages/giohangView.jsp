<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang giỏ hàng</title>
<link rel="stylesheet" type="text/css" href="fontawesome/css/all.css">
<link rel="stylesheet" type="text/css" href="stylesheet/bootstrap.css">
</head>
<body>
	<div align="center">
		<a class="nav-link" href="${pageContext.request.contextPath}/"> < Mua thêm sản phẩm khác</a>
		<table>
			<tr>
				<td>ID</td>
				<td>TEN</td>
				<td>DONGIA</td>
				<td>Giảm</td>
				<td>SOLUONG</td>
				<td>Tăng</td>
				<td>Thành tiền</td>
				<td>Xóa</td>
				<td>Hình ảnh</td>
			</tr>
			<c:forEach items="${listCart}" var="listCart">
				<tr>
					<td>${listCart.value.maSanPham}</td>
					<td>${listCart.value.tenSanPham}</td>
					<td>${listCart.value.donGia}</td>
					<td><a href="giamSoLuong?maSanPham==${listCart.value.maSanPham}" style="text-decoration: none;">-</a></td>
					<c:forEach items="${listSL}" var="itemsl">
						<c:if test="${listCart.key == itemsl.key}">
						<td>
						<input readonly value="${itemsl.value}"/>
						</td>
						</c:if>
					</c:forEach>
					<td><a href="tangSoLuong?maSanPham==${listCart.value.maSanPham}" style="text-decoration: none;">+</a></td>
					<c:forEach items ="${listTT}" var="listTT">
						<c:if test="${listCart.key == listTT.key }">
						<td>
							${listTT.value}
						</td>
						</c:if>
					</c:forEach>
					<td>
						<a class="far fa-trash-alt" title="Xóa sản phẩm" href="xoasession?maSanPham=${listCart.value.maSanPham}"></a>
					</td>
					<td>
						<img alt="Không tồn tại ảnh này!" src="image/sanpham/tablet/${listCart.value.hinhAnh }">
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">@</span>
  </div>
  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
</div>
<i class="fas fa-list">List</i>
<a class="far fa-trash-alt"></a>
</body>
<script type="text/javascript" src="script/jquery.js"></script>
<script type="text/javascript" src="script/bootstrap.js"></script>
</html>