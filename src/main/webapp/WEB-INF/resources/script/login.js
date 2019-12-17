// Show - hide form them tai khoan 
var div_them_tai_khoan = document.querySelector(".them-tai-khoan");
var btn_them_tai_khoan = document.querySelector("#btn-them-tai-khoan");
var btn_dong = document.querySelector("#submit-close");
btn_them_tai_khoan.onclick = function() {
	if(!div_them_tai_khoan.classList.contains("them-tai-khoan-show"))
		{
			if(div_them_tai_khoan.classList.contains("them-tai-khoan-hide"))
				{
					div_them_tai_khoan.classList.remove("them-tai-khoan-hide");
				}
				
			div_them_tai_khoan.classList.add("them-tai-khoan-show");
		}
	else
		{
			div_them_tai_khoan.classList.remove("them-tai-khoan-show");
			div_them_tai_khoan.classList.add("them-tai-khoan-hide");
		}
};
btn_dong.onclick = () =>{
	if(!div_them_tai_khoan.classList.contains("them-tai-khoan-show"))
	{
		if(div_them_tai_khoan.classList.contains("them-tai-khoan-hide"))
			{
				div_them_tai_khoan.classList.remove("them-tai-khoan-hide");
			}
			
		div_them_tai_khoan.classList.add("them-tai-khoan-show");
	}
else
	{
		div_them_tai_khoan.classList.remove("them-tai-khoan-show");
		div_them_tai_khoan.classList.add("them-tai-khoan-hide");
	}
};

function removeLogin() {
	document.querySelector(".form-login").classList.add("remove");
	document.querySelector(".form-register").classList.add("add");
}

function removeRegister() {
	document.querySelector(".form-login").classList.remove("remove");
	document.querySelector(".form-register").classList.remove("add");
}
 
/*PHƯƠNG THỨC ẨN HIỆN FORM THÊM TÀI KHOẢN
	TRONG TRANG QUẢN LÝ TÀI KHOẢN
	KHI NHẤN NÚT THÊM TÀI KHOẢN SẼ XUẤT HIỆN
	MẶC ĐỊNH SẼ BỊ ẨN	*/
function remove() {
	document.querySelector("#form-them-taikhoan").classList.remove("add");
	console.log("removeUser");
}

function addAdd() {
	document.querySelector("#form-them-taikhoan").classList.add("add");
	console.log("addAddUser");
}



/*PHƯƠNG THỨC KIỂM TRA ĐĂNG NHẬP
	KHI ĐỂ TRỐNG DỮ LIỆU VÀ NHẤN LOGIN	*/

function checklogin() {
	var userlogin = document.getElementById('UserName-Login').value;
	//var passlogin = document.getElementById('PassWord-Login').value;
	if(userlogin == '' && passlogin == '')
	{
		alert("Tài khoản không được để trống");
	}
	else
		return true;
	return false;

}
	
/*Kiểm tra validate các input trong form register*/
function checkRegister()
{
	let elementRegister = document.querySelectorAll('.form-register input[type=text]');
	let mess_username = document.querySelector(".form-register .mess-username");
	if(elementRegister[0].value.length >= 5){
		if(mess_username.classList.contains("p-mess-fail"))
			{
				mess_username.classList.remove("p-mess-fail");
				mess_username.classList.add("p-mess");		
			}
				mess_username.innerHTML = "Thông tin hợp lệ!";
				return true;
	}
	else
		{
			
				mess_username.classList.remove("p-mess");
				mess_username.classList.add("p-mess-fail");
				mess_username.innerHTML = "Thông tin >= 5 ký tự!";
				return false;

		}
}
document.querySelector(".form-register input[name=UserName]").onchange = function(){
	return checkRegister();
}

/* kiểm tra password và confirmpass */
function checkpass() {
	//dùng querySelectorAll không tối ưu vì sẽ trả về mảng bị thừa
	let elementRegister = document.querySelector('.form-register input[name=PassWord]');
	let mess_pass = document.querySelector('.form-register .mess-pass');
	if(elementRegister.value.length >= 5){
			mess_pass.classList.remove("p-mess-fail");
			mess_pass.classList.add("p-mess");
			mess_pass.innerHTML = "Mật khẩu hợp lệ";
			return true;
	}
	else{
		console.log(elementRegister.value);
		mess_pass.classList.remove("p-mess");
		mess_pass.classList.add("p-mess-fail");
		mess_pass.innerHTML = "Mật khẩu >= 5 ký tự!";
		return false;
	}
}

document.querySelector(".form-register input[name=PassWord]").onchange = function(){
	return checkpass();
}

//kiểm tra ConfirmPass và PassWord
function checkConfim(){
	let elementRegister = document.querySelectorAll('.form-register input[type=password]');
	let mess_pass = document.querySelector('.form-register .mess-confirm');
	if(elementRegister[0].value === elementRegister[1].value)
	{
		mess_pass.classList.remove("p-mess-fail");
		mess_pass.classList.add("p-mess");
		mess_pass.innerHTML = "Xác nhận mật khẩu hợp lệ";
		return true;
	}
	else{
			mess_pass.classList.remove("p-mess");
			mess_pass.classList.add("p-mess-fail");
			mess_pass.innerHTML = "Mật khẩu không khớp";
			return false;
		}
}
document.querySelector(".form-register input[name=ConfirmPass]").onchange = function(){
	return checkConfim();
}

//kiểm tra ký nhập đặc biệt khi nhập họ tên
function checkName(){
	let name = document.querySelector('.form-register input[type=text]');
	console.log(name.value);
	let mess_name = document.querySelector('.form-register .mess-name');
	let check = /^[^abc][^0-9]/;
	
	if(name.value == ''){
		mess_pass.classList.remove("p-mess-fail");
		mess_pass.classList.add("p-mess");
		mess_name.innerHTML = "Không được để trống!";
		return false;
	}
	else
	{
		/*if(check.test(name)){
			mess_name.innerHTML = "Họ tên hợp lệ"
			return true;
		}
		else{
			mess_name.innerHTML = "Họ tên được có ký tự đặc biệt!";
			return false;
		}*/
		return true;
	}
}
document.querySelector(".form-register input[name=Name]").onchange = function(){
	return chekcName();
}
console.log(name[1].value);

//kiểm tra các input trước khi cho nhấn submit
function register(){
	if(checkRegister() === false || checkpass() === false || checkConfim() === false || checkName() === false)
		return false;

	return true;
}

