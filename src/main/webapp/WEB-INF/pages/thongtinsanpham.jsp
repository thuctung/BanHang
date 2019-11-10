<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<LINK REL="SHORTCUT ICON" HREF="image/sanpham/logoTittle.png">
<link href="stylesheet/chitietsanpham.css" rel="stylesheet">
<title>Thế giới di đông </title>
</head>
<body>
	<header>
		<!-- Create Header -->
    <div class="header">
        <div class="contentHeader">
            <form action="" name="formTimkiem" onsubmit="return checkValue()">
                <div class="logo">
                    <a href="" class="avartar"></a>
                    <a href="" class="title"></a>
                    <input id="searchBox" type="text" placeholder="Bạn tìm gì ..." name ="Timkiem" class="search" >
                    <input type="submit" class="iconsearch" value="" name="XnTim">
                </div>
            </form>
            <div class="navabar">
            <a href="/PTMPCN/view/dienthoai.php" class="items">
                    <div class="product phone"></div>
                    <p class="aphone">Điện thoại</p>
                </a>
                <a href="/PTMPCN/view/tablet.php" class="items">
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
                <a class="items">
                    <p id="login" href="">Login</p>
                </a>
                <div class="buycall">
                    GỌI MUA HÀNG:
                    <a href="">1800.1068</a>
                    <span>(7:30 - 22:00)</span>
                </div>
            </div>
        </div>
	</header>
<!-- Done Header -->	


	
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
    <script src="script/index.js"></script>
</body>
</html>