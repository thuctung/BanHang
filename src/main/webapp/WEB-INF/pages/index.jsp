<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<LINK REL="SHORTCUT ICON" HREF="image/sanpham/logoTittle.png">
<title>Thế giới di đông </title>
<link href="stylesheet/index.css" rel="stylesheet">
</head>
<body>
	<header>
		<!-- Create Header -->
    <div class="header">
        <div class="contentHeader">
            <form action="timkiem" method="POST" name="formTimkiem" onsubmit="return checkValue()">
                <div class="logo">
                    <a href="./" class="avartar"></a>
                    <a href="./" class="title"></a>
                    <input id="searchBox" type="text" placeholder="Bạn tìm gì ..." name ="key" class="search" >
                    <input type="submit" class="iconsearch" value="">
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
    </header>
<!-- Done Header -->
	
	<div class="container">
		<!-- QUANG CAO -->
		<div class="advant">
            <div class="slide-advant">
                <div class="slidegraper">
                    <div class="slide">
                        <ul>
                            <li class="vewing"><img src="image/sanpham/slide1.png" alt=""></li>
                            <li class=""><img src="image/sanpham/slide2.png" alt=""></</li>
                            <li class=""><img src="image/sanpham/slide3.png" alt=""></</li>
                            <li class=""><img src="image/sanpham/slide4.png" alt=""></</li>
                            <li class=""><img src="image/sanpham/slide5.png" alt=""></</li>
                        </ul>
                    </div>                        
                </div>
                <div class="menuslide">
                    <div class="infosile">
                        <ul>
                            <li><a class="Stronging" >Sắm Oppo Trả Góp 0% <br> Giảm Đến 1 Triệu</a></li>
                            <li ><a >Đặt Trước Galaxy A50<br> Tặng Ngay Galaxy Fit e</a></li>
                            <li><a >Mừng Khai Trương <br> Điện Thoại Siêu Rẻ</a></li>
                            <li ><a >Phụ Kiện Online<br> Giảm Sốc 49%</a></li>
                            <li ><a  >Thử tài Mi Fan <br>Nhận ngay ưu đãi</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="news">
                <div class="news-technolog">
                    <div class="head-news-technolog">
                        <div class="news-p">
                            <p>Tin công nghệ </p>
                        </div>
                        <span id="notifi">
                            <span class="ping"></span>
                        </span>
                        <span class="khuyenmai"><strong>Tin nóng: </strong>Khuyến mái Giáng Sinh</span>
                    </div>
                    <div class="content-news-technolog">
                        <img src="image/sanpham/anhnew.jpg" alt="">
                        <a href="" class="infoimage">Cổng chuyển công nghệ cao, nâng cao tốc độ truyền tải dữ liệu</a>
                        <span class="time">12 phút trước</span>
                    </div>
                </div>
                <a href="" class="news-two">
                    <img src="image/sanpham/news2.png" alt="">
                </a>
                <a href="" class="news-three">
                    <img src="image/sanpham/news3.png" alt="">
                </a>
            </div>	
        </div>
        <div class="lableAnvant">
            <img src="image/sanpham/lable.png" alt="">
        </div>	
		<!-- XONG QUANG CAO -->	
		
		<!-- KHUYEN MAI HOT NHAT -->
		 <div class="khuyenmaihot">
            <div class="tieudekhuyenmai">
                <h2>KHUYẾN MÃI HOT NHẤT</h2>
            </div>
            <div class="listkhuyenmai">
                <div class="listkhuyenmai1 danghienthi">
               	 <c:forEach items = "${dienthoai}" var="dt">

               	 	<div class="hot-item">	
							<a href="./chitietsanpham?Masp=${dt.getMaSanPham()}">
								<img src="image/sanpham/dienthoai/${dt.getHinhAnh()}" alt="" width="180px" height="180px">
								<h3>${dt.getTenSanPham()}</h3>
								<div class="giasanpham"> 
									<c:set var = "dongia" value = "${dt.getDonGia() }" />
	           						 <strong>
	            						<fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dongia}"/>đ
	            					</strong>
									<span><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dongia+1000000}"/>đ</span>
							</div>
							<div class ="quatang">
								<p> ${dt.getMoTa().substring(0, 73)}...</p>
							</div>
							<div class="giamgia">
								<label>Giảm 1.000.000đ</label>
							</div>
							</a>
						</div>
               	 </c:forEach>
               </div>
                <div class="listkhuyenmai1 angiatri">
                	<c:forEach items = "${tablet}" var="tl">
						<div class="hot-item">	
							<a href="./chitietsanpham?Masp=${tl.getMaSanPham() }">
								<img src="image/sanpham/tablet/${tl.getHinhAnh()}" alt="" width="180px" height="180px">
								<h3>${tl.getTenSanPham()}</h3>
								<div class="giasanpham">
								<c:set var = "dongia" value = "${tl.getDonGia() }" />
	           						 <strong>
	            						<fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dongia}"/>đ
	            					</strong>
									<span><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dongia+1000000}"/>đ</span>
							</div>
							<div class ="quatang">
								<p>${tl.getMoTa()}...</p>
							</div>
							<div class="giamgia">
								<label>Giảm 1.000.000đ</label>
							</div>
							</a>
						</div>
					</c:forEach>
			  	</div>
		</div>
		<!-- XONG KHUYEN MAI HOT NHAT -->	
            <div class="chuyensanpham" id="toright">›</div>
            <div class="chuyensanpham" id="toleft">‹</div>
        </div>
        <! DIEN THOAI NOI BAT -->
        <div class="dienthoainoibat">
            <div class="tieudenoibat">
                <h2>ĐIỆN THOẠI NỔI BẬT NHẤT</h2>
                <ul>
                    <li><a href="">Giảm sốc Online</a></li>
                    <li><a href="">Iphone</a></li>
                    <li><a href="">Iphone 11</a></li>
                    <li><a href="">Iphone 11 Pro</a></li>
                    <li><a href="">Iphone 11 Pro Max</a></li>
                    <li class="all"><a href="./hienthisanpham?Madm=1">Xem<strong> tất cả</strong> điện thoại</a></li>
                </ul>
            </div>
             <div class="sanpham anhnho1">
                <a href="./chitietsanpham?Masp=42">
                    <img src="image/sanpham/dienthoainoibat1.jpg" alt="">
                    <h3>Samsung Galaxy Note 10+</h3>
                    <div class="giasanpham">
                        <strong>24.900.000đ</strong>
                    </div>
                    <label class="tragop">Trả góp 0%</label>
                </a>
            </div>
            <div class="sanpham anhnho2">
                <a href="./chitietsanpham?Masp=33">
                    <img src="image/sanpham/dienthoainoibat2.jpg" alt="">
                    <h3>Oppo Reno 10X</h3>
                    <div class="giasanpham">
                        <strong>14.990.000đ</strong>
                    </div>
                    <label class="giamgia">Giảm 1.000.000đ</label>
                </a>
            </div>
            <div class="listdienthoai">
                  <div class="hot-phone">
					<c:forEach items = "${dienthoaiHot}" var="dthot">
					<div class="hot-item">
					    <a href="./chitietsanpham?Masp=${dthot.getMaSanPham()}">
					      <img src="image/sanpham/dienthoai/${dthot.getHinhAnh()}" alt="" width="180px" height="180px">
					      <h3>${ dthot.getTenSanPham()}</h3>
					           <div class="giasanpham">
					              <c:set var = "dongia" value = "${dthot.getDonGia() }" />
	           					  <strong>
	            					<fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dongia}"/>đ
	            				  </strong>
					            </div>
					            <div class ="quatang">
					                <p><?php echo "Mua loa kẹo kéo giảm 15%"?></p>
					             </div>
					             <div class="giamgia">
					                <label class ="tragop">Trả góp 0% </label>
					            </div>
					      </a>
					  </div>
			    	</c:forEach>
				</div>
            </div>
        </div>
        <!-- XONG DIEN THOAI NOI BAT -->
        
        
        <!-- TABLET NOI -->
          <div class="tabletnoibat">
	       		<div class="tieudetablet">
	                <h2>TABLTE - LAPTOP NỔI BẬT NHẤT</h2>
	                <ul id ="ultablet">
	                    <li><a href="">Giảm sốc Online</a></li>
	                    <li><a href="">Máy tính bảng Ipad</a></li>
	                    <li><a href="">Ipad Mini 2019</a></li>
	                    <li><a href="">Samsung Tab S6</a></li>
	                    <li><a href="./hienthisanpham?Madm=2">Xem<strong> tất cả</strong> Tablet</a></li>
	                    <li class="all"><a href="">Xem<strong> tất cả</strong> Laptop</a></li>
	                </ul>
	            </div>
	             <div class="sanphamtablet">
	             	<div>
		                <a href="./chitietsanpham?Masp=52">
		                    <img src="image/sanpham/tablet/tabs6.jpg" alt="">
		                    <h3>SamSung Galaxy Tab S6</h3>
		                    <div class="giasanpham">
		                        <strong>18.490.000đ</strong>
		                    </div>
		                    <label class="tragoptablet">Trả góp 0%</label>
		                </a>
	                </div>
	                <div>
		                <a href="./chitietsanpham?Masp=53">
		                    <img src="image/sanpham/tablet/ipad10.2inchwifi20191.jpg" alt="">
		                    <h3>Ipad 10.2 inch Wifi (2019) 32G</h3>
		                    <div class="giasanpham">
		                        <strong>9.990.000đ</strong>
		                    </div>
		                    <label class="tragoptablet">Trả góp 0%</label>
		                </a>
		             </div>
	            </div>
	            <div class="listtablet">
	            	<div class="hot-phone tablethot">
	            		<c:forEach items = "${tabletHot}" var="tlhot">
	                    <div class="tablethotnhat">
				            <a href="./chitietsanpham?Masp=${tlhot.getMaSanPham()}">
				                <img src="image/sanpham/tablet/${tlhot.getHinhAnh()}" alt="" width="180px" height="180px">
				                <h3>${tlhot.getTenSanPham()}</h3>
				                <div class="giasanpham">
				                     <c:set var = "dongia" value = "${tlhot.getDonGia() }" />
	           					  	<strong>
	            						<fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dongia}"/>đ
	            				  	</strong>				                
	            				  	</div>
				                <div class ="quatang">
				                    <p>Mua loa kẹo kéo giảm 15%</p>
				                </div>
				                <div class="giamgia">
				                    <label class ="tragoptablet">Trả góp 0% </label>
				                </div>
				            </a>
				        </div>
				    </c:forEach>
				    </div>
	            </div>
	        </div>
	    </div>
        <!-- XONG TABLET NOI BAT -->
	</div>
	
	
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