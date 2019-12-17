/*
GÁN SỰ KIỆN ONCLICK CHO TẤT CẢ NÚT XÓA
THỰC HIỆN PHƯƠNG THỨC XÓA CHO ĐỐI TƯỢNG NÀO NHẤN ONCLICK*/
var btn_xoa = document.querySelectorAll(".xoa-user");
btn_xoa.forEach(function(item)
{
	console.log(item);
	item.setAttribute("onclick", "xoa(this)");
} );

/*PHƯƠNG THỨC XÓA
LẤY CẢ ĐƯỜNG DẪN BỎ VÀO BIẾN URL_XOA VÌ
ĐƯỜNG DẪN CONTEXTBATH CHỈ SỬ DỤNG ĐC CHO FILE JSP*/
function xoa(e){
	
	var url_xoa = e.getAttribute("id");
	if(confirm("Bạn có chắc chắn muốn xóa?"))
	{
		location.href= url_xoa;
	}
	else{}
}

/*KIỂM TRA ĐĂNG KÍ USERNAME TRONG TRANG QUẢN LÝ*/
function checkregister()
{
	let elementRegister = document.querySelectorAll('#form-them-taikhoan input[type=text]');
	let mess_username = document.querySelector("#form-them-taikhoan .mess-UserName");
	if(elementRegister[0].value.length >= 5){
		if(mess_username.classList.contains("p-messfail"))
			{
				mess_username.classList.remove("p-messfail");
				mess_username.classList.add("mess");		
			}
				mess_username.innerHTML = "Thông tin hợp lệ!";
				return true;
	}
	else
		{
			
				mess_username.classList.remove("mess");
				mess_username.classList.add("p-messfail");
				mess_username.innerHTML = "Thông tin >= 5 ký tự!";
				return false;

		}
}

/*HÀM NÀY SỬ DỤNG KHÁ BẤT CẬP KHI THỰC HIỆN TRÊN NHIỀU FORM VÌ NÓ BỊ LỖI THÌ SẼ K THỰC HIỆN ĐƯỢC PT Ở DƯỚI*/
document.querySelector("#form-them-taikhoan input[name=UserName]").onchange = function(){
	return checkregister();
}

/*KIỂM TRA PASSWORD TRONG TRANG QUẢN LÝ*/
function checkpass1() {
	//dùng querySelectorAll không tối ưu vì sẽ trả về mảng bị thừa
	let elementRegister = document.querySelector('#form-them-taikhoan input[name=PassWord]');
	let mess_pass = document.querySelector('#form-them-taikhoan .mess-Pass');
	if(elementRegister.value.length >= 5){
			mess_pass.classList.remove("p-messfail");
			mess_pass.classList.add("mess");
			mess_pass.innerHTML = "Mật khẩu hợp lệ";
			return true;
	}
	else{
		console.log(elementRegister.value);
		mess_pass.classList.remove("mess");
		mess_pass.classList.add("p-messfail");
		mess_pass.innerHTML = "Mật khẩu >= 5 ký tự!";
		return false;
	}
}

document.querySelector("#form-them-taikhoan input[name=PassWord]").onchange = function(){
	return checkpass1();
}

function register1(){
	if(checkregister() === false || checkpass1() === false)
		return false;

	return true;
}


