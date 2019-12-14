<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="danhSachDonHang">
	<div class="thanhchucnang">
		<a href="quanlydonhang" class="btn tatca">Tất cả</a>
		<a href="quanlydonhang?tinhtrang=0" class="btn chuaxacnhan">Chưa xác nhận</a>
		<a href="quanlydonhang?tinhtrang=2" class="btn dahuy">Đã hủy </a>
		<a href="quanlydonhang?tinhtrang=1" class="btn dathanhtoan">Đã xác nhận</a>
		<a href="quanlydonhang?tinhtrang=3" class="btn tatca">Đã thanh toán</a>
	</div>
	<div class="list">
		<h3>Danh Sách Đơn Hàng </h3>
		<div class="danhsach">
		<c:forEach items = "${listdonhang}" var="dhql">
			<div class="motdonhang">
				<c:choose>
				<c:when test="${dhql.getTrangThai() == 0}">
   						<c:set var = "tinhtranh" value = "Chưa xác nhận"/>
   					</c:when>
   					<c:when test="${dhql.getTrangThai() == 1}">
   						<c:set var = "tinhtranh" value = "Đã xác nhận"/>
   					</c:when>
   					<c:when test="${dhql.getTrangThai() == 2}">
   						<c:set var = "tinhtranh" value =  "Đã hủy "/>
   					</c:when>
   					<c:when test="${dhql.getTrangThai() == 3}">
   						<c:set var = "tinhtranh" value = "Đã thanh toán "/>
   					</c:when>
   				</c:choose>				
				<p class="tenkh">Tên khách hàng: <strong>${dhql.getHoTen() }</strong></p >
				<p class="diachi">Địa chỉ: <strong>${dhql.getDiaChi() }</strong> </p>
				<c:set var = "loaidonhang" value = "Giao tận nhà"/>
				<c:if test="${dhql.getLoaiDonHang() == 0}">
					<c:set var = "loaidonhang" value = "Nhận tại siêu thị"/>
				</c:if>
				<p class="loaidon">Loại đơn: <strong>${loaidonhang}</strong> </p>
				<p class="diachi">Địa chỉ: <strong>${dhql.getDiaChi() }</strong> </p>
				<p class="sodienthoai">Số điện thoại: <strong>${dhql.getSoDienThoai() }</strong></p>  
				<p class="ngaydat">Ngày đặt hàng: <strong>${dhql.getNgayTao() }</strong></p>
				<p class="pduoi tinhtrang">Tình trạng: <strong>${tinhtranh}</strong></p> 
				<p class="pduoi tongtien">Tổng tiền: <strong><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dhql.getTongTien()}"/>đ</strong></p>
				<p class="pduoi duocgiam">Được giảm: <strong><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dhql.getGiamGia()}"/>đ</strong></p>
				<p class="pduoi thanhtoan">Thanh toán: <strong><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dhql.getThanhTien()}"/>đ</strong></p>
				<a class="btnchitiet" onclick="hienChiTietDonHang(${dhql.getIdDonHang()})">Chi tiết</a>
				
				<c:choose>
					<c:when test="${dhql.getTrangThai() == 0}">
						<div class="areaXacnhan">
   							<a href="capnhattrangthai?madh=${dhql.getIdDonHang()}&&trangthai=1" class="btnxacnhan">Xác nhận </a>
							<a href="capnhattrangthai?madh=${dhql.getIdDonHang()}&&trangthai=2" class="btnhuy">Hủy</a>
						</div>
   					</c:when>
   					<c:when test="${dhql.getTrangThai() == 1}">
						<div class="areaXacnhan">
   							<a href="capnhattrangthai?madh=${dhql.getIdDonHang()}&&trangthai=3" class="btnxacnhan">Thanh toán </a>
   							<a href="capnhattrangthai?madh=${dhql.getIdDonHang()}&&trangthai=2" class="btnxacnhan">Đã hủy</a>
						</div>
   					</c:when>
   					<c:when test="${dhql.getTrangThai() == 2}">
						<div class="areaXacnhan">
   							<a href="" class="btnxacnhan">Xóa</a>
						</div>
   					</c:when>
   				</c:choose>
				<div class="chitietdonhang" id="chitietdonhang${dhql.getIdDonHang()}">
					<div class ="noidungdonhang">
						<p class="dongchitiet" onclick="dongChiTietDonHang(${dhql.getIdDonHang()})">Đóng</p>
						<div class="chitietmotdonhang">
							<p>Ghi chú : ${dhql.getYeuCau() }</p>
							<c:forEach items = "${dhql.getChiTietDonHang()}" var="ctdh">
								<div class="chitietne">
									<c:set var = "hinhanh" value = "dienthoai"/>
									<c:if test="${ctdh.getMaDanhMuc() == 2}">
										<c:set var = "hinhanh" value = "tablet"/>
									</c:if>
									<img src="image/sanpham/${hinhanh}/${ctdh.getHinhAnh()}" width="50px" height="50px"/>
									<p>Tên sản phẩm: <strong>${ctdh.getTenSanPham()}</strong> </p>
									<p>Số lượng: <strong>${ctdh.getSoLuong()}</strong> </p>
									<p>Đơn giá: <strong><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${ctdh.getDonGia()}"/>đ</strong> </p>									
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
	</div>
</div>