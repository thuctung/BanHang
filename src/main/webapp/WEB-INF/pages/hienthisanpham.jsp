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
<link href="stylesheet/header.css" rel="stylesheet">
<link href="stylesheet/footer.css" rel="stylesheet">
<link href="stylesheet/hienthisanpham.css" rel="stylesheet">

</head>
<body>
	<!-- REQUIRE TEMPLATE HEADER -->
	<%@ include file="template/header.jsp" %>
	<!-- Done Header -->
<!-- HTML CONTAINER -->
	<!-- Hãng sản xuất -->
    <div class="menuhangSanXuat">
        <a href="./hienthisanpham?Madm=${danhmuc}&&hang=1">
            <img src="image/sanpham/anhnhasanxuat/apple.jpg">
        </a>
        <a href="./hienthisanpham?Madm=${danhmuc}&&hang=4">
            <img src="image/sanpham/anhnhasanxuat/samsung.jpg">
        </a>
        <a href="./hienthisanpham?Madm=${danhmuc}&&hang=3">
            <img src="image/sanpham/anhnhasanxuat/oppo.jpg">
        </a>
        <a>
            <img src="image/sanpham/anhnhasanxuat/xiaomi.jpg">
        </a>
        <a>
            <img src="image/sanpham/anhnhasanxuat/vivo.jpg">
        </a>
        <a href="./hienthisanpham?Madm=${danhmuc}&&hang=2">
            <img src="image/sanpham/anhnhasanxuat/huawei.jpg"> 
        </a>
        <a >
            <img src="image/sanpham/anhnhasanxuat/realmi.jpg">
        </a>
        <a>
            <img src="image/sanpham/anhnhasanxuat/vinsmart.jpg">
        </a>
        <a>
            <img src="image/sanpham/anhnhasanxuat/nokia.jpg">
        </a>
        <a>
            <img src="image/sanpham/anhnhasanxuat/mobell.jpg">
        </a>
        <a>
            <img src="image/sanpham/anhnhasanxuat/itel.jpg">
        </a>
        <a>
            <img src="image/sanpham/anhnhasanxuat/coolpad.jpg">
        </a>
        <a>
            <img src="image/sanpham/anhnhasanxuat/BlackBerry.jpg">
        </a>
    </div>
    <div class="container-dienthoai">
   		 <c:set var = "hienthidanhmuc" value = "Điện thoại"/>
   		 <c:set var = "hienthihangsx" value = ""/>
    		<c:if test = "${danhmuc == 2}">
    			<c:set var = "hienthidanhmuc" value = "Tablet"/>
    		</c:if>
    		<c:if test = "${hang == 1}">
    			<c:set var = "hienthihangsx" value = "Apple"/>
    		</c:if>
    		<c:if test = "${hang == 2}">
    			<c:set var = "hienthihangsx" value = "Huawei"/>
    		</c:if>
    		<c:if test = "${hang == 3}">
    			<c:set var = "hienthihangsx" value = "Oppo"/>
    		</c:if>
    		<c:if test = "${hang == 4}">
    			<c:set var = "hienthihangsx" value = "Samsung"/>
    		</c:if>
        <div class="thongtindanhsach">
        	<h3>Danh Sách ${hienthidanhmuc}</h3>
        	<p class="thongtinhangsx">${hienthihangsx}</p>
        	<p class="soluong">Tổng số sản phẩm: <strong>${tongsanpham}</strong></p>
        	<div class="sapxep">
        		<strong>Sắp xếp</strong>
        		<c:if test ="${sapxep == true}">
        		<select class="dropdown">
            		<option value="0">Giá thấp - cao</option>
            		<option value="1">Giá cao - thấp</option>
            	</select>
            	</c:if>
            	<c:if test ="${sapxep == false}">
        		<select class="dropdown">
            		<option value="1">Giá cao - thấp</option>
            		<option value="0">Giá thấp - cao</option>
            	</select>
            	</c:if>
        	</div>        	
        </div>
        <div class="listDienThoai">
        <c:if test="${ listSP != null }"> 
        	<c:forEach items = "${listSP}" var="page">
        	<a href="./chitietsanpham?Masp=${page.getMaSanPham() }">
        		<c:set var = "hinhanh" value = "dienthoai"/>
        		<c:if test = "${page.getMaDanhMuc() == 2}">
        			<c:set var = "hinhanh" value = "tablet"/>
        		</c:if>
	            <img src="image/sanpham/${hinhanh}/${page.getHinhAnh()} " width="180px" height="180px" />
	            <p class="tenSanPham">${page.getTenSanPham() }</p>
	            <c:set var = "dongia" value = "${page.getDonGia() }" />
	            <c:set var = "classTheP" value = "donGiaSP" />
	            <c:if test="${page.getKhuyenMai() > 0}">
	            	<c:set var = "classTheP" value = "gachngang" />
	            </c:if>
	            <p class="${classTheP}">
	            	<fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dongia}"/>đ
	            </p>
	            <c:if test="${page.getDiemDanhGia() > 0}">
	            	<img src="image/star.jpg" class="anhdanhgia">
	            </c:if>
	            <c:if test="${page.getKhuyenMai() > 0}">
	            	<strong class="tiengiamgia">
						<fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dongia - 1000000}"/>đ
			     	</strong>
	            	<label class="labelGiamgia">Giảm 1.000.000đ</label>
	            </c:if>
           	</a>
        	</c:forEach>
        </c:if>
        </div>
    </div>
    <div class="divchuyentrang">
    	<c:set var = "sx" value = "1"/>
    	<c:if test = "${sapxep == true}">
    		<c:set var = "sx" value = "0"/>
    	</c:if>
    	<c:if test = "${tranghientai > 1}">
    		<a href="./hienthisanpham?Madm=${danhmuc}&&sapxep=${sx}&&page=1&&hang=${hang}" ><button class="viewmore vedauvecuoi"><<</button></a>
    		<a href="./hienthisanpham?Madm=${danhmuc}&&sapxep=${sx}&&page=${tranghientai - 1}&&hang=${hang}" ><button class="viewmore">Pre</button></a>
    	</c:if>
    	
    	<c:set var = "trangke" value = "${tranghientai+2}"/>
    		<c:if test = "${tranghientai >=  page - 2}">
    			<c:set var = "trangke" value = "${page}"/>
    		</c:if>
    		
    	<c:forEach var ="i" begin="${tranghientai}" end = "${trangke}" step="1">
    		<c:set var = "tenlop" value = "viewmore"/>
    		<c:if test = "${i == tranghientai}">
    			<c:set var = "tenlop" value = "viewmore noneClick"/>
    		</c:if>
    		<a href="./hienthisanpham?Madm=${danhmuc}&&sapxep=${sx}&&page=${i}&&hang=${hang}" ><button class="${tenlop}">${i}</button></a>
    	</c:forEach>
    		
    	<c:if test = "${tranghientai < page}">
    		<a href="./hienthisanpham?Madm=${danhmuc}&&sapxep=${sx}&&page=${tranghientai+1}&&hang=${hang}" ><button class="viewmore">Nex</button></a>
    		<a href="./hienthisanpham?Madm=${danhmuc}&&sapxep=${sx}&&page=${page}&&hang=${hang}" ><button class="${tenlop} vedauvecuoi">>></button></a>
    	</c:if>
    </div>
<!-- XONG HTML CONTAINER -->
<!-- HTML FOOTER -->
	<%@ include file="template/footer.jsp" %>	
<!-- XONG HML FOOTER -->	
    <script src="script/hienthisanpham.js"></script>
</body>
</html>