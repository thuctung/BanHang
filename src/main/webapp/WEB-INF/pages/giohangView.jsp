<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<title>Trang giỏ hàng</title>
	<link rel="stylesheet" type="text/css" href="stylesheet/giohang.css">
</head>
<body>
	<div class="divTong">
		<div class="divVeTrangChu">
			<div class="divMuaThemSanPhamKhac">
				<a href="/BanHang/">< Mua thêm sản phẩm khác</a>
			</div>
			<div class="divGioHangCuaBan">Giỏ hàng của bạn</div>
		</div>

		<div class="divUuDaiSinhNhat">
    		<div class="divSinhNhat">
        		<p>Ưu đãi sinh nhật cho khách mua online có sinh nhật tháng 11.<br>
	            	<span style="font-size:14px">* Chỉ áp dụng giao hàng tận nơi.</span>
	            	<a href="#" >Xem chi tiết</a>
        		</p>
	        	<div class="divApDungSinhNhat">
	                <input type="text"placeholder="Nhập số CMND" maxlength="12"/>
		            <input type="text" placeholder="Ngày/Tháng/Năm sinh" maxlength="10"/>
	            	<button type="button">Áp dụng</button>
	        	</div>
    		</div>
		</div>

		<c:forEach items="${listCart}" var="listCart">
		<div class="divListSanPham">
			<ul class="divListSanPham">
				<li>
					<c:if test="${listCart.value.maDanhMuc == 1}">
					<div class="divImgSanPham">
                        <a href="#">
                            <img width="85" src="image/sanpham/dienthoai/${listCart.value.hinhAnh }">
                        </a>
                        <a class="delete" href="/BanHang/giohang/xoasession?maSanPham=${listCart.value.maSanPham }">
                        	<span>Xóa</span>
                        </a>
                    </div>
                    </c:if>
                    <c:if test="${listCart.value.maDanhMuc == 2}">
					<div class="divImgSanPham">
                        <a href="#">
                            <img width="85" src="image/sanpham/tablet/${listCart.value.hinhAnh}">
                        </a>
                        <a class="delete" href="/BanHang/giohang/xoasession?maSanPham=${listCart.value.maSanPham }">
                        	<span>Xóa</span>
                        </a>
                    </div>
                    </c:if>

                    <div class="divThongTinSanPham">
                    	<strong>
                    		<fmt:formatNumber type="number" maxFractionDigits="3" value="${listCart.value.donGia}" />đ
                    	</strong>
                    	<a href="#">${listCart.value.tenSanPham }</a>
                    	<div>
		                    <p>* Ưu đãi sinh nhật cho khách mua online có sinh nhật tháng 11.<br>
	            			<span style="font-size:17px">* Chỉ áp dụng giao hàng tận nơi.</span>
	            			<p>* Ưu đãi sinh nhật cho khách mua online có sinh nhật tháng 11.<br>
	            			<span style="font-size:15px">* Chỉ áp dụng giao hàng tận nơi.</span>
       					</div>
       					<div class="divChonMau">
                            <span>Màu: Tím</span>
                            <input type="hidden" value="Tím">
                        </div>
                        <form action="giohang/capnhat" method="post">
                        <div class="divChonSo">
                        	<c:forEach items="${listSL }" var="listSL">
                        	<c:if test="${listCart.key == listSL.key}">
                            <div class="divNumber">
                            	<input type="number" name="soLuong" value="${listSL.value}" min="1" max="10">
                            	<input type="hidden" name="maSanPham" value="${listCart.value.maSanPham}">
                            </div>
                            </c:if>
                            </c:forEach>
                            <div class="divAdd">
                            	<button>Cập nhật</button>
                            </div>
                        </div>
                        </form>
                        
                    </div>
				</li>
			</ul>
		</div>
		</c:forEach>
		
		<div class="divThanhToan">
            <span>Tổng tiền:</span>
            <strong>
            	<fmt:formatNumber type="number" maxFractionDigits="3" value="${tongThanhTien}" />đ
            </strong></br>

            <span>Phí chuyển hàng:</span>
            <strong>0₫</strong></br>

	        <span>Cần thanh toán:</span>
	        <strong>
	        	<fmt:formatNumber type="number" maxFractionDigits="3" value="${tongThanhTien}" />đ
	        </strong></br>
            <strong><a href="#">Sử dụng mã giảm giá</a></strong>
        </div>

        <!-- Mua hàng -->
        <div class="divThongTinKhachHang">
		    <div class="malefemale">
		    	<input type="radio" name="a" value="Nam">
		        <label class="anh ">&nbsp;Anh</label>
		        <input type="radio" name="a" value="Nam">
		        <label class="">&nbsp;Chị</label>
		    </div>
		    <div class="divInputThongTin">
		        <input type="text" name="" placeholder="Họ và tên" maxlength="50" value="">
		        <input type="tel" class="saveinfo" name="" placeholder="Số điện thoại" maxlength="10">
		        <input type="text" name="BillingAddress.Email" placeholder="Email (Để theo dõi quá trình chuyển hàng)" maxlength="100" >
		        <input type="text" name="" placeholder="Địa chỉ" maxlength="300">
		        <input type="text" name="" placeholder="Yêu cầu khác (không bắt buộc)" maxlength="300">
		    </div>
		</div>
        <!-- Kết thúc mua hàng -->

        <!-- Mua Hàng -->
        <a href="">
	        <div class="divMuahang">
	        	Mua Hàng
	        </div>
        </a>
        <!-- Kết thúc mua hàng -->
        <div class="divLuuY">
        	<h2>*Các sản phẩm mua tại web thegioididong.com được miễn phí vận chuyển.</h2>
        	<p>*Lưu ý: Sản phẩm chỉ thanh toán khi khách hàng nhận được sản phẩm. </p>
        	<span>Đảm bảo cho khách hàng mua sản phẩm an toàn và chất lượng.</span>
        	<h3>Chúc khách hàng một ngày vui vẻ.</h3>
        	<h4>See You Agian</h4>
        </div>
	</div>
</body>
</html>
