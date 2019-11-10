<%@page import="java.util.*"%>
<%@page import="detai.cnjva.DAOFile.*"%>
<%@page import="detai.cnjva.modelFile.*"%>
<%@page import="java.text.NumberFormat" %>
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
                    <a href="./" class="avartar"></a>
                    <a href="./" class="title"></a>
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

<!-- HTML CONTAINER -->
	<%	int masp = Integer.parseInt(request.getParameter("Masp"));
		ChiTietSanPhamDAO  ctspDAO = new ChiTietSanPhamDAO();
		SanPhamDAO  spDAO = new SanPhamDAO();
		SanPham sanpham = spDAO.LaySanPhamTheoMa(masp);
		ChiTietSanPham ctsp = ctspDAO.LayThongTinSanPham(masp);
		Locale localeVN = new Locale("vi", "VN");
	    NumberFormat vn = NumberFormat.getInstance(localeVN);
	%>
	<div class="container">
        <h1 class ="tenchitietsanpham"><%=sanpham.getTenSanPham() %></h1>
        <aside class="picture">
        <% String thumuc = sanpham.getMaDanhMuc() == 1 ? "dienthoai": "tablet"; %>
            <?php $path = $row['madanhmuc'] == 2 ? "tablet" : "dienthoai"; ?>
            <img src="image/sanpham/<%= thumuc+'/'+sanpham.getHinhAnh()%>" alt="" >
        </aside>
        <aside class="price-sale">
            <div class="area-price">
                <label class="installment">Trả góp 0%</label>
                <strong><%=vn.format(sanpham.getDonGia()) %>đ</strong>
            </div>
            <div class="area-promotion">
                <strong class="khuyenmaitieude">Khuyến mãi</strong>
                <span class="pro521609">
                    <label><span>Giảm thêm 5% </span>cho khách mua online có là học sinh</label> 
                    <a href="" target="_blank">Xem chi tiết*</a>
                </span><br>
                <span class="khuyenmaichitiet">
                    <%= sanpham.getMoTa() %>
                </span>
                <span class="khuyenmaiphukien">Tặng mã giảm giá 100.000đ để mua phụ kiện online (áp dụng đơn hàng phụ kiện trên 200.000đ)</span>
                <span class="notkhuyenmai">*Không áp dụng khi mua trả góp</span>
            </div>
            <button class="muangay">MUA NGAY<p>Giao tận nơi hoặc nhận tại siêu thị</p></button>
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
                    <div><%= ctsp.getManHinh() %></div>
                </li>
                <li>
                    <span>CPU:</span>
                    <div class="mauxanhchitiet"><%= ctsp.getCpu() %></div>
                </li>
                <li>
                    <span>Hệ điều hành:</span>
                    <div class="mauxanhchitiet"><%= ctsp.getHeDieuHanh() %></div>
                </li>
                <li>
                    <span>Camera sau:</span>
                    <div><%= ctsp.getCameraSau() %></div>
                </li>
                <li>
                    <span>Camera trước:</span>
                    <div><%= ctsp.getCammeraTruoc() %></div>
                </li>
                <li>
                    <span>Bộ nhớ RAM:</span>
                    <div><%= ctsp.getRam() %></div>
                </li>
                <li>
                    <span>Bộ nhớ trong:</span>
                    <div><%= ctsp.getBoNhoTrong() %></div>
                </li>
                <li>
                    <span>Thẻ nhớ:</span>
                    <div class="mauxanhchitiet"><%= ctsp.getTheNho() %></div>
                </li>
                <li>
                    <span>Kết nối:</span>
                    <div class="mauxanhchitiet"><%= ctsp.getSim() %></div>
                </li>
                <li>
                    <span>Dung lượng PIN:</span>
                    <div><%= ctsp.getDungLuongPin() %></div>
                </li>
            </ul>
            <div class ="xemcauhinhchitiet">Xem cấu hình chi tiết</div>
        </div>
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
    <script src="script/chitiet.js"></script>
</body>
</html>