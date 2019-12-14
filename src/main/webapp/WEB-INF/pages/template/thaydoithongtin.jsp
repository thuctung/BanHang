<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<form class="form-change-infor" action="capnhatUser/?idtk=${hienthiUser.getIdUser() }" method="POST">
		Tài khoản<input type="text" class="tb-register1" name="UserName" ReadOnly placeholder="${hienthiUser.userName }"/>
		Mật khẩu<input type="text" class="tb-register1" name="PassWord" value="${hienthiUser.getPassWord()}"/>
		Số điện thoại<input type="text" class="tb-register1" name="Phone" value="${hienthiUser.getSoDienThoai() }"/>
		Email<input type="text" class="tb-register1" name="Email" value="${hienthiUser.getDiaChiMail() }"/>
		<%-- <c:if test="${hienthiUser.getRole() == 0 }">
			Chức vụ<input type="text" class="tb-register1" name="Role" value="Người dùng"/>
		 </c:if>
		 <c:if test="${hienthiUser.getRole() == 1 }">
			Chức vụ<input type="text" class="tb-register1" name="Role" value="Quản lý"/>
		 </c:if>  --%>
		 Chức vụ: <br>
	    <select name="chucvu">
	        	<option class="tb-register1" value="${hienthiUser.getRole() }">--</option>
	        	<option class="tb-register1" value="1">Người dùng</option>
	        	<option class="tb-register1" value="2">Quản lý</option>
	    </select>
		<button type="submit" class="submit-register">Cập nhật</button>
		<a href="quanlytaikhoan" class="submit-register">Trở về</a>
	</form>
<%-- 	<c:if test="${chucnang == 2 }">
		<%@ include file="template/thaydoithongtin.jsp" %>
	</c:if> --%>