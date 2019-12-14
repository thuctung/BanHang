<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<!-- FORM THÊM TÀI KHOẢN -->
		<form class="themtaikhoan" action="${pageContext.request.contextPath}/themtaikhoan" method="POST">
			<h1>Thêm tài khoản</h1>
			<input type="text" class="tb-register1" name="UserName" placeholder="Tài khoản"/>
				<p class="p-mess mess-username">(*)</p>
			<input type="password" class="tb-register1" name="PassWord" placeholder="Mật khẩu"/>
				<p class="p-mess mess-pass">(*)</p>
			<input type="text" class="tb-register" name="Email" placeholder="Email"/>
			<button type="submit" class="submit-login">Thêm</button>
			<label class="submit-login" onclick="remove()" >Đóng</label>
			<!-- HIỂN THỊ THÔNG BÁO KHI FORM THỰC HIỆN -->
			<c:if test = "${checkuser != null && checkuser == 0}">
				<script>alert("Thêm tài khoản thành công!")</script>
			</c:if>
			<c:if test = "${checkuser != null && checkuser == 1}">
				<script>alert("Tài khoản đã có người sử dụng!!!")</script>
			</c:if>
		</form>
		
	<div class="danhsachtaikhoan">
		<form>
		<Label onclick="">Thêm tài khoản</Label>
		
			<div class="hienthidanhsach">
				<c:forEach items="${hienthiUser}" var="hienthi">
						<p>UserName: ${hienthi.getUserName()}</p>
						<p>Họ Tên: ${hienthi.getHoTen()}</p>
						<p>Số điện thoại: ${hienthi.getSoDienThoai()}</p>
						<p>Email: ${hienthi.getDiaChiMail() }</p>
						<p>Chức vụ: 
							<c:if test="${hienthi.getRole() == 1}">
								người dùng
							</c:if>
							<c:if test="${hienthi.getRole() == 2}">
								quản lý
							</c:if>
						</p>
						<!-- Button không thể dùng gữi đc request chỉ sử dụng đc trong form
							muốn sử dụng phải dùng thẻ a href -->
						<a class="capnhat-user"  href="thaydoithongtin?id=${hienthi.getIdUser()}">Cập nhật</a>
						<a class="xoa-user" href="${pageContext.request.contextPath}/xoa?idUser=${hienthi.getIdUser()}">Xóa</a>
						<br>-----------
						
				</c:forEach>
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
		</form>
</div>