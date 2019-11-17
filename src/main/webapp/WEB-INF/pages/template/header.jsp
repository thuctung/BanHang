<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header>
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
                <c:choose>
   					<c:when test="${sessionScope.idKhachHang != null}">
   						<a class="items" href="./logout">
                    		<img class="imgLogin" src="image/user.png"/>
                    		<p class="plogin">Logout</p>
                		</a>
   					</c:when>
   					<c:otherwise>
   						<a class="items" href="./login">
                    		<img class="imgLogin" src="image/logout.png"/>
                    		<p class="plogin">Login</p>
                		</a>
   					</c:otherwise>
   				</c:choose>
            </div>
        </div>
    </div>
        <div class="vedau">
        <a class="scroll" title="Về đầu"></a>
    </div>  
 </header>