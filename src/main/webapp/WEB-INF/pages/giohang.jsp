<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<LINK REL="SHORTCUT ICON" HREF="image/sanpham/logoTittle.png">
<title>Thế giới di đông</title>
<link href="stylesheet/header.css" rel="stylesheet">
<link href="stylesheet/footer.css" rel="stylesheet">
<link href="stylesheet/giohang.css" rel="stylesheet">
</head>
<body>
	<%@ include file="template/header.jsp"%>
	<div class="container">
			<a href="./"> < Mua thêm sản phẩm khác </a>
			<p class="thep">Giỏ hàng của bạn</p>
	<c:choose>
		<c:when test="${listGioHang != null && listGioHang.size() > 0}">
			<div class="contentGioHang">
				<form class="formKhachHang" name="formGioHang" method="POST" action="xacnhandathang" onsubmit="return checkGioHang()">
					<div class="listSanPham">
						<c:set var = "hinhanh" value = "dienthoai"/>
						<c:forEach items="${listGioHang}" var="giohang">
						<div class="motsanpham">
							<c:if test ="${giohang.getMaDanhMuc() == 2 }">
								<c:set var = "hinhanh" value = "tablet"/>
							</c:if>
							<img src="image/sanpham/${hinhanh}/${giohang.getHinhAnh() }" width="80px" height="80px">
							<h4>${giohang.getTenSanPham()} </h4>
							<c:set var = "dongia" value="${giohang.getDonGia()}"/>
							<p>Giá: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dongia}"/>đ</p>
							<c:set var = "giamgia" value="0"/>
							<c:if test="${giohang.getkhuyenMai() > 0}">
								<h5>Giảm: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${giohang.getKhuyenMai()}"/>đ</h5>
							</c:if>
							<a href="xoagiohang?Masp=${giohang.getMaSanPham()}">Xóa</a>
							<c:set var = "tiensanpham" value = "${giohang.getDonGia()*giohang.getSoLuong() - giamgia}"/>
							<strong>Tổng: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${tiensanpham}"/>đ</strong>
							<c:set var = "tongtien" value = "${tongtien + dongia*giohang.getSoLuong()}"/> <!-- CONG DON TONG TIEN CAC SAN PHAM -->
							<div class="soluong">
								<div class="btn btntru" onclick="TruSoLuong(${giohang.getMaSanPham()})"> - </div>
									<div id="soluongSanpham${giohang.getMaSanPham()}" class="inputsoluong">${giohang.getSoLuong() }</div>
								<div class="btn btncong" onclick="CongSoLuong(${giohang.getMaSanPham()})"> + </div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="thanhtien">
					<label class="tongtien">Tổng tiền </label> <label class="tonggiatien"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sessionScope.tongtien}"/>đ</label>
					<label class="tiengiam">Tiền giảm</label><label class="sotiengiamgia"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sessionScope.giamgia}"/>đ</label>
					<strong class="canthanhtoan">Cần thanh toán </strong> <strong class="tienthanhtoan"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sessionScope.thanhtoan}"/>đ</strong>			
				</div>
				<div class="thongtinKhachhang">
					<input placeholder="Họ tên " name="hoTenKH" class="input inputKh"/>
					<input placeholder="Số điện thoại" name="sodienthoai" class="input inputsdt"/>
					<input placeholder="Yêu cầu khác(Không bắt buộc)" name="ghichu" class="input inputGhiChu"/>
					<label class="label"><strong>Để được phục vụ nhanh hơn, </strong>hãy chọn thêm: </label>
					<input id="tainha" type="radio" name="loaimua" value="1"/><label  for="tainha">Giao hàng tại nhà</label> 
					<input id="taiquay" type="radio" name="loaimua" value="0"/><label style="color:dodgerblue;"  for="taiquay">Nhận tại siêu thị</label>  
					<input placeholder="Tỉnh, thành phố" name="tinhthanhpho" class="input tinhtp"/>
					<input placeholder="Quận, huyện" name="quanhuyen" class="input"/>
					<input placeholder="Phường, xã" name="phuongxa" class="input"/>
					<input placeholder="Số nhà" name="sonha" class="input"/>	
				</div>
				<input type="submit" class="btnXacnhan" value="XÁC NHẬN ĐẶT HÀNG"></input>
			</form>
			</div>
		</c:when>
		<c:otherwise>
			<h3>Giỏ hàng trống</h3>
		</c:otherwise>
	</c:choose>
	</div>
	<c:if test="${check == true}">
		<script>alert("Đặt hàng thành công! Vui lòng đợi điện thoại xác nhận của nhân viên"); window.location.href="/BanHang/"</script>
	</c:if>
	<c:if test="${check == false}">
		<script>alert("Hệ thống có lỗi không thể đặt hàng");window.location.href="/BanHang/"</script>
	</c:if>
	<%@ include file="template/footer.jsp"%>
	 <script src="script/giohang.js"></script>
</body>
</html>