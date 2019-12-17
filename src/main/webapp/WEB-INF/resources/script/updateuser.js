/*KIỂM TRA PASSWORD TRONG FORM CẬP NHẬT KHI ÍT HƠN NHẬP ÍT HƠN 5*/
function checkpass_update() {
	//dùng querySelectorAll không tối ưu vì sẽ trả về mảng bị thừa
	let elementRegister = document.querySelectorAll('#form-action-change input[type=text]');
	let mess_pass = document.querySelector('#form-action-change .mess-Pass1');
	console.log(elementRegister[1].value);
	if(elementRegister[1].value.length >= 5){
			mess_pass.classList.remove("p-messfail1");
			mess_pass.classList.add("mess1");
			mess_pass.innerHTML = "Mật khẩu hợp lệ";
			return true;
	}
	else{
		console.log(elementRegister[1].value);
		mess_pass.classList.remove("mess1");
		mess_pass.classList.add("p-messfail1");
		mess_pass.innerHTML = "Mật khẩu >= 5 ký tự!";
		return false;
	}
}

document.querySelector("#form-action-change input[name=PassWord]").onchange = function(){
	return checkpass_update();
}

function register_update(){
	if(checkpass_update() === false)
		return false;

	return true;
}