<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- THÔNG BÁO KHI ĐÃ CẬP NHẬP THÔNG TIN VÀ REFESH LẠI TRANG QUẢN LÝ TÀI KHOẢN
		CHỈ HIỆN THỊ KHI CÓ SỰ THAY ĐỔI BÊN FORM CẬP NHẬT THÔNG TIN -->
<c:if test="${not empty mess}">
	<script>
		alert("Cập nhật thông tin thành công!")
	</script>
	<%
		request.getSession().removeAttribute("mess");
	%>
</c:if>

<!-- FORM HIỂN THỊ DANH SÁCH TÀI KHOẢN -->
<div class="danhsachtaikhoan">
	<div class="title-ds-taikhoan">
		<h1>Danh sách tài khoản</h1>
		<span id="btn-them-tai-khoan">Thêm tài khoản</span>
	</div>
	
	<div class="hienthidanhsach">
		<table id="content-table" align="center">
			<thead>
				<tr>
					<!-- <th>Mã tài khoản</th> -->
					<th>Tên tài khoản</th>
					<th>Họ tên</th>
					<th>Số điện thoại</th>
					<th>Email</th>
					<th>Chức vụ</th>
					<th>Chức năng</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${hienthiUser}" var="hienthi">
					<tr>
						<%-- <td>${hienthi.getIdUser()}</td> --%>
						<td>${hienthi.getUserName()}</td>
						<td>${hienthi.getHoTen()}</td>
						<td>${hienthi.getSoDienThoai()}</td>
						<td>${hienthi.getDiaChiMail()}</td>
						<td><c:if test="${hienthi.getRole() == 1}">
								Người dùng
							</c:if> <c:if test="${hienthi.getRole() == 0}">
								Quản lý
							</c:if></td>
						<td><a class="capnhat-user"
							href="thaydoithongtin?id=${hienthi.getIdUser()}">Cập nhật</a> <a
							class="xoa-user"
							href="${pageContext.request.contextPath}/xoa?idUser=${hienthi.getIdUser()}">Xóa</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- CHỨC NĂNG PHÂN TRANG TRONG FORM HIỂN THỊ DANH SÁCH -->
		<%--<c:if test="${listUserPhanTrang.getTotal_pages() > 1}">
					<c:forEach items="${listUserPhanTrang.listPage}" var="index">
						${index}<br>
					</c:forEach>
				</c:if>
				<c:if test="${listUserPhanTrang.getTotal_pages() == listUserPhanTrang.getTotal_pages() }">
					<c:forEach items="${listUserPhanTrang.listPage}" var="index">
						!--${index}--!<br>
					</c:forEach>
				</c:if> --%>
		<%--	<c:choose>
					<c:when test="${listUserPhanTrang.getTotal_pages() == listUserPhanTrang.getTotal_pages() }">
						<c:forEach items="${listUserPhanTrang.listPage}" var="index">
							!--${index}--!<br>
						</c:forEach>
					</c:when> 
					<c:when test="${listUserPhanTrang.getTotal_pages() > 1}">
						<c:forEach items="${listUserPhanTrang.listPage}" var="index">
							--${index}--<br>
						</c:forEach>
					</c:when> 
				</c:choose>--%>
	</div>
</div>
<!-- FORM THÊM TÀI KHOẢN -->
<div class="them-tai-khoan">
	<form id="form-them-taikhoan"
		action="${pageContext.request.contextPath}/themtaikhoan" method="POST">
		<h1>Thêm tài khoản</h1>
		</td>
		<div id="form-them-taikhoan">
			<input type="text" maxlength="20" class="tb-add" name="UserName"
				placeholder="Tài khoản" />
			<p class="p-mess mess-username">(*)</p>
		</div>
		<div id="form-them-taikhoan">
			<input type="password" maxlength="20" class="tb-add" name="PassWord"
				placeholder="Mật khẩu" />
			<p class="p-mess mess-pass">(*)</p>
		</div>
		<div id="form-them-taikhoan">
			<input type="text" class="tb-add" maxlength="30" name="Email" placeholder="Email" />
		</div>

		<div id="btn-form-them-taikhoan">
			<button class="submit-add" type="submit">Thêm</button>
		</div>
		<div id="btn-form-them-taikhoan">
			<label class="submit-add" id="submit-close">Đóng</label>
		</div>
		<!-- HIỂN THỊ THÔNG BÁO KHI FORM THỰC HIỆN -->
		<c:if test="${checkuser != null && checkuser == 0}">
			<script>
				alert("Thêm tài khoản thành công!")
			</script>

		</c:if>
		<c:if test="${checkuser != null && checkuser == 1}">
			<script>
				alert("Tài khoản đã có người sử dụng!!!")
			</script>
		</c:if>
		<%
			request.getSession().removeAttribute("checkuser");
		%>
	</form>
</div>
<!-- KẾT THÚC FORM THÊM TÀI KHOẢN -->
<!-- KẾT THÚC FORM HIỂN THỊ DANH SÁCH TÀI KHOẢN -->