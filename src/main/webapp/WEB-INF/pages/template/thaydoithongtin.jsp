<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="form-change-infor">
	<div class="title-form-change">
		<h1 id="h1">Cập nhập thông tin</h1>
	</div>
	<div class="body-form-change">
	<form id="form-action-change" action="capnhatUser/?idtk=${hienthiUser.getIdUser()}" method="POST">
		<div class="row-form">
			<p class="lb-form">Tài khoản:</p>
			<input type="text" class="tb-change" name="UserName" readonly placeholder="${hienthiUser.getUserName()}">
		</div>
		<div class="row-form">
			<p class="lb-form">Mật khẩu: </p>
			<input type="text" class="tb-change" maxlength="20" name="PassWord" value="${hienthiUser.getPassWord()}">
		</div>
		<div class="row-form">
			<p class="lb-form">Họ tên: </p>
			<input type="text" class="tb-change" maxlength="35" name="Name" value="${hienthiUser.getHoTen()}">
		</div>
		<div class="row-form">
			<p class="lb-form">Số điện thoại: </p>
			<input type="text" class="tb-change" maxlength="10" name="Phone" value="${hienthiUser.getSoDienThoai()}">
		</div>
		<div class="row-form">
			<p class="lb-form">Email: </p>
			<input type="text" class="tb-change" maxlength="40" name="Email" value="${hienthiUser.getDiaChiMail()}">
		</div>
		<div class="row-form">
			<p class="lb-form">Chức vụ: </p>
			<select id="select" class="tb-change" name="chucvu">
		        <option value="${hienthiUser.getRole()}">	---		</option>
		        <option value="1">Người dùng</option>
		        <option value="0">Quản lý</option>
		   	</select>
		</div>
		<div class="row-form">
			<a href="quanlytaikhoan" class="submit-update">Quay lại</a>
			<button type="submit" class="submit-update">Cập nhật</button>
		</div>
		</table>
	</form>
	</div>
</div>