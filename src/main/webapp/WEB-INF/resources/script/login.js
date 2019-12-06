let btnDangKi = document.querySelector(".btnDangKi");
let btnHuyDn = document.querySelector(".btnHuyDangKi");




let divDangKi = document.querySelector(".divDangki");
btnDangKi.addEventListener('click',()=>{
	divDangKi.classList.add("hienthiDangki");
});

btnHuyDn.addEventListener('click',()=>{
	divDangKi.classList.remove("hienthiDangki");
});

//Ẩn hiện form login và register
function removeLogin() {
	console.log("ok");
	document.querySelector(".form-login").classList.add("remove");
	document.querySelector(".form-register").classList.add("add");
}

function removeRegister() {
	console.log("ok");
	document.querySelector(".form-login").classList.remove("remove");
	document.querySelector(".form-register").classList.remove("add");
}