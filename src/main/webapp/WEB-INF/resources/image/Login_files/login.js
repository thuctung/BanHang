let btnDangKi = document.querySelector(".btnDangKi");
let btnHuyDn = document.querySelector(".btnHuyDangKi");




let divDangKi = document.querySelector(".divDangki");
btnDangKi.addEventListener('click',()=>{
	divDangKi.classList.add("hienthiDangki");
});

btnHuyDn.addEventListener('click',()=>{
	divDangKi.classList.remove("hienthiDangki");
});