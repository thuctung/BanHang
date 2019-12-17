<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<LINK REL="SHORTCUT ICON" HREF="image/sanpham/logoTittle.png">
<link href="stylesheet/header.css" rel="stylesheet">
<link href="stylesheet/footer.css" rel="stylesheet">
<link href="stylesheet/chitietsanpham.css" rel="stylesheet">
<title>Thế giới di đông </title>
</head>
<body>
<!-- REQUIRE TEMPLATE HEADER -->
	<%@ include file="template/header.jsp" %> 
<!-- Done Header -->	

<!-- HTML CONTAINER -->
	<div class="container">
        <h1 class ="tenchitietsanpham">${sanpham.getTenSanPham()}</h1>
        <aside class="picture">
        	<c:set var = "hinhanh" value = "dienthoai"/>
        	<c:if test = "${sanpham.getMaDanhMuc() == 2}">
        		<c:set var = "hinhanh" value = "tablet"/>
        	</c:if>
	        <img src="image/sanpham/${hinhanh}/${sanpham.getHinhAnh()} " class="anhsanpham"/>
	        <div class="danhgiasanpham">
	        	<c:if test ="${diemdanhgia > 0}">
	        	<c:forEach var ="i" begin="1" end = "${diemdanhgia}" step="1">
	        		<img src ="image/star.jpg" class="saodanhgia"/>
	        	</c:forEach>
	        		<c:if test ="${diemle != 0}">
	        			<img src ="image/motnuasao.jpg" class="saodanhgia"/>
	        		</c:if>
	        		<a class="xemdanhgia">Xem đánh giá</a>
	        	</c:if>
	        	<c:if test ="${diemdanhgia <= 0}">
	        		<h4>Chưa có đánh giá</h4>
	        		<a class="xemdanhgia">Đánh giá ngay</a>
	        	</c:if>
	        </div>
        </aside>
        <aside class="price-sale">
            <div class="area-price">
                <label class="installment">Trả góp 0%</label>
                <c:set var = "dongia" value = "${sanpham.getDonGia() - sanpham.getKhuyenMai() }" />
	            <strong>
	            	<fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dongia}"/>đ
	            </strong>
            </div>
            <div class="area-promotion">
                <strong class="khuyenmaitieude">Khuyến mãi</strong>
                <span class="pro521609">
                    <label><span>Giảm thêm 5% </span>cho khách mua online có là học sinh</label> 
                    <a href="" target="_blank">Xem chi tiết*</a>
                </span><br>
                <span class="khuyenmaichitiet">
                    ${sanpham.getMoTa()}
                </span>
                <span class="khuyenmaiphukien">Tặng mã giảm giá 100.000đ để mua phụ kiện online (áp dụng đơn hàng phụ kiện trên 200.000đ)</span>
                <span class="notkhuyenmai">*Không áp dụng khi mua trả góp</span>
            </div>
            <a href="themgiohang?Masp=${sanpham.getMaSanPham()}">
               	<button class="muangay">MUA NGAY<p>Giao tận nơi hoặc nhận tại siêu thị</p></button>
            </a>            
            <div class="muatragop btnmua">
                <strong>MUA TRẢ GÓP</strong><span>Thủ tục đơn giản</span>
            </div>
            <div class="tragopquathe btnmua">
                <strong>TRẢ GÓP QUA THẺ</strong><span>Visa, Master, JCB</span>
            </div>
            <p class="goidatmua">Gọi đặt mua:<span> 1800.1060</span> (miễn phí - 7:30~22:00)</p>
        </aside>
        <div class="thongsokithuat">
            <h2>Thông số kỹ thuật</h2>
            <ul class="ulkithuat">
                <li>
                    <span>Màn hình:</span>
                    <div>${ctsp.getManHinh()}</div>
                </li>
                <li>
                    <span>CPU:</span>
                    <div class="mauxanhchitiet">${ctsp.getCpu()}</div>
                </li>
                <li>
                    <span>Hệ điều hành:</span>
                    <div class="mauxanhchitiet">${ctsp.getHeDieuHanh()}</div>
                </li>
                <li>
                    <span>Camera sau:</span>
                    <div>${ctsp.getCameraSau()}</div>
                </li>
                <li>
                    <span>Camera trước:</span>
                    <div>${ctsp.getCammeraTruoc()}</div>
                </li>
                <li>
                    <span>Bộ nhớ RAM:</span>
                    <div>${ctsp.getRam()}</div>
                </li>
                <li>
                    <span>Bộ nhớ trong:</span>
                    <div>${ctsp.getBoNhoTrong()}</div>
                </li>
                <li>
                    <span>Thẻ nhớ:</span>
                    <div class="mauxanhchitiet">${ctsp.getTheNho()}</div>
                </li>
                <li>
                    <span>Kết nối:</span>
                    <div class="mauxanhchitiet">${ctsp.getSim()}</div>
                </li>
                <li>
                    <span>Dung lượng PIN:</span>
                    <div>${ctsp.getDungLuongPin()}</div>
                </li>
            </ul>
            <div class ="xemcauhinhchitiet">Xem cấu hình chi tiết</div>
        </div>
		<div class="clearn"></div>
		<!-- ĐÁNH GIÁ SẢN PHẨM -->
		<div class="formDanhGia">
			<form action="chitietsanpham" name="formDanhGia" method="POST" onsubmit="return checkGuiDanhGia()">
				<h4>Chọn đánh giá của bạn</h4>
				<c:forEach var ="i" begin="1" end = "5" step="1">
					<div class="group1">
						<label for="ip${i}">${i} <img src ="image/star.jpg" width="19px" height="20px"/></label>
						<input id="ip${i}" type="radio" name="sao" value="${i}"/>
					</div>
				</c:forEach>
				<input  type="hidden" name="masp" value="${sanpham.getMaSanPham()}"></input>
				<textarea id="noidungdanhgia" name="noidungdanhgia" placeholder="Nhập nội dung đánh giá (Không quá 100 kí tự)"></textarea>
				<c:choose>
   					<c:when test="${sessionScope.idKhachHang != null && checkdanhgia == false}">
   						<input class="submit" type="submit" value="Gửi"></input>
   					</c:when>
   					<c:when test="${checkdanhgia == true}">
   						<a class="dangnhapdedanhgia">Bạn đã đánh giá sản phẩm này </a>
   					</c:when>
   					<c:otherwise>
   						<a class="dangnhapdedanhgia" href="./login">Đăng nhập để đánh giá </a>
   					</c:otherwise>
   				</c:choose>
			</form>
			
			<c:if test="${sessionScope.insert != null}">
				<script>alert("Đánh giá thành công !")</script>
				<% request.getSession().removeAttribute("insert");%>
			</c:if>
			<c:if test="${sessionScope.update != null}">
				<script>alert("Cập nhật thành công thành công !")</script>
				<% request.getSession().removeAttribute("update");%>
			</c:if>
			<c:if test="${sessionScope.delete != null}">
				<script>alert("Xóa thành công !")</script>
				<% request.getSession().removeAttribute("delete");%>
			</c:if>
		</div>
		<!-- XONG DANH GIA SAN PHAM -->         
        
        <!-- HIEN THI NHUNG DANH GIA CUA SAN PHAM -->
        <c:if test="${listDanhGia.size() > 0}">
        	<div class="hienthidanhgia">
        		<c:forEach items="${listDanhGia}" var ="danhgia">
        			<c:choose>
   						<c:when test="${sessionScope.idKhachHang == danhgia.getIdKhachHang()}">
   							<div class="motdanhgia">
   								<h4>${ danhgia.getHoTenKhachHang()}</h4>
   								<form action="chitietsanpham" name="formUpdate" method="POST" onsubmit="return checkGuiUpdate()">
		    						<div class="saoUpdate">
	    								<div class="group1">
											<label for="up1">1<img src ="image/star.jpg" width="19px" height="20px"/></label>
											<input id="up1" type="radio" name="sao" value="1"/>
										</div>
										<div class="group1">
											<label for="up2">2<img src ="image/star.jpg" width="19px" height="20px"/></label>
											<input id="up2" type="radio" name="sao" value="2"/>
										</div>
										<div class="group1">
											<label for="up3">3<img src ="image/star.jpg" width="19px" height="20px"/></label>
											<input id="up3" type="radio" name="sao" value="3"/>
										</div>
										<div class="group1">
											<label for="up4">4<img src ="image/star.jpg" width="19px" height="20px"/></label>
											<input id="up4" type="radio" name="sao" value="4"/>
										</div>
										<div class="group1">
											<label for="up5">5<img src ="image/star.jpg" width="19px" height="20px"/></label>
											<input id="up5" type="radio" name="sao" value="5"/>
										</div>	
		    						</div>
		    						<div class="sosaodanhgia saoupdate">
		    							<input type="hidden" name="masp" value="${danhgia.getMaSanPham()}"/>
		    							<input type="hidden" name="saodanhgiatruocupdate" value="${danhgia.getDiemDanhGia()}">
		    							<c:forEach var ="i" begin="1" end = "${danhgia.getDiemDanhGia()}" step="1">
		     								<img src ="image/star.jpg" class="saodanhgia1"/>
		     							</c:forEach>
		    						</div>
		    						<input value="${danhgia.getNgayDanhGia()}" class="inputngaydanhgia" readonly/>
		    						<input name="noidungdanhgia" value="${danhgia.getNoiDungDanhGia()}" autofocus class="formcomment" readonly/>
		    						<input value="Cập nhật" type="submit" class="btnUpdate" />
    							</form>
    							<a href="xoadanhgia?masp=${danhgia.getMaSanPham()}&&sosao=${danhgia.getDiemDanhGia()}" class="Xoacmt">Xóa đánh giá</a>
    							<a class="Xoacmt" id ="suadanhgia">Sửa đánh giá </a>
   							</div>   							
   						</c:when>
   						<c:otherwise>
   							<div class="motdanhgia">
		    					<h4>${ danhgia.getHoTenKhachHang()}</h4>
		    					<div class="sosaodanhgia">
		    					<c:forEach var ="i" begin="1" end = "${danhgia.getDiemDanhGia()}" step="1">
		     						<img src ="image/star.jpg" class="saodanhgia1"/>
		     					</c:forEach>
		    					</div>
		    					<p class="ngaydanhgia">${danhgia.getNgayDanhGia()}</p>
		    					<p class="noidungdanhgia">${danhgia.getNoiDungDanhGia()}</p>
   							</div>
   						</c:otherwise>
   					</c:choose>					
        		</c:forEach>
        	</div>
        </c:if>
        <!-- XONG HIEN THI NHUNG DANH GIA CUA SAN PHAM -->
</div>
	
<!-- XONG HTML CONTAINER -->	
	
	
<!-- HTML FOOTER -->
	<%@ include file="template/footer.jsp" %>  	
<!-- XONG HML FOOTER -->	
    <script src="script/chitiet.js"></script>
</body>
</html>