<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<LINK REL="SHORTCUT ICON" HREF="image/sanpham/logoTittle.png">
<title>Thế giới di động </title>
<link href="stylesheet/index.css" rel="stylesheet">
<link href="stylesheet/hienthisanpham.css" rel="stylesheet">

</head>
<body>
	<header>
		<!-- Create Header -->
    <div class="header">
        <div class="contentHeader"> 
            <form action="timkiem" name="formTimkiem" method="POST" onsubmit="return checkValue()">
                <div class="logo">
                    <a href="./" class="avartar"></a>
                    <a href="./" class="title"></a>
                    <input id="searchBox" type="text" placeholder="Bạn tìm gì ..." name ="key" class="search" >
                    <input type="submit" class="iconsearch" value="" name="XnTim">
                </div>
            </form>
            <div class="navabar">
            	<a href="./hienthisanpham?Madm=1" class="items">
                    <div class="product phone"></div>
                    <p class="aphone">Điện thoại</p>
                </a>
                <a href="./hienthisanpham?Madm=2" class="items">
                    <div class="product tablet"></div>
                    <p class="atablet">Tablet</p>
                </a>
                <a class="items">
                    <div class="Laptop product"></div>
                    <p id="alaptop" href="">Laptop</p>
                </a>
                <a class="items">
                    <div class="product phukien"></div>
                    <p class="aphukien">Phụ kiện</p>
                </a>
                <a class="items">
                    <div class="product watch"></div>
                    <p class="awatch" >Đồng hồ</p>
                </a>
                <a class="items">
                    <div class="product older"></div>
                    <p class="aolder" href="">Cũ giá rẻ</p>
                </a>
                <a class="items">
                    <div class="product technology"></div>
                    <p class="atechnology" >Công nghệ</p>
                </a>
                <a class="items">
                    <div class="product sim"></div>
                    <p class="asim" href="">Sim đẹp</p>
                </a>
                <a class="items" href="./login">
                    <p id="login">Login</p>
                </a>
                <div class="buycall">
                    GỌI MUA HÀNG:
                    <a href="">1800.1068</a>
                    <span>(7:30 - 22:00)</span>
                </div>
            </div>
        </div>
    </div>
        <div class="vedau">
        <a class="scroll" title="Về đầu"></a>
    </div>  
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
    			<c:set var = "hienthihangsx" value = "> Huawei"/>
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
	            <p class="donGiaSP">
	            	<fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dongia}"/>đ
	            </p>
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
	<div class="footer">
        <div class="rowfood1">
            <ul class = "ul1">
                <li><a href="">Tìm hiểu về bảo hành</a></li>
                <li><a href="">Chính sách đổi trả</a></li>
                <li><a href="">Cách thức thanh toán</a></li>
                <li><a href="">Hướng dẫn mua online</a></li>
                <li><a href="">Thông tin cửa hàng</a></li>
            </ul>
            <ul class="ul2">
                <li><a href="">Giới thiệu công ty</a></li>
                <li><a href="">Tuyển dụng</a></li>
                <li><a href="">Gửi thư góp ý</a></li>
                <li><a href="">Tìm cửa hàng</a></li>
            </ul>
            <ul class="ul3">
                <li><a href="">Gọi mua hàng <strong>1800.1574</strong></a></li>
                <li><a href="">Gọi khiếu nại <strong> 1800.1062</strong></a></li>
                <li><a href="">Gọi bảo hành <strong> 1800.1068</strong></a></li>
                <li><a href="">Kỹ thuật <strong> 1800.7425</strong></a></li>
                <li class="congnhan"><a href=""></a></li>
            </ul>
            <ul class="ul4">
                <li>
                    <a href="" class="facebook"><i class="icon-fb"></i>3.5tr</a>
                    <a href="" class="youtube"><i class="icon-ytb"></i>162k</a>
                    <div class="group">
                        <label>Sản phẩm cùng tập đoàn</label>
                        <a href=""><i class="logo-dmx"></i></a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <!-- XONG HML FOOTER -->	
    <script src="script/hienthisanpham.js"></script>
</body>
</html>