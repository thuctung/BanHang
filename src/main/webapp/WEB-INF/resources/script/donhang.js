let denbaophu = document.querySelector(".denbaophu");


let idChitiet;
function hienChiTietDonHang(id){
	let chitietdonhang = document.querySelector(`#chitietdonhang${id}`);
	chitietdonhang.classList.add("hienchitietdonhang");
	denbaophu.classList.add("hiendenbaophu");
	idChitiet = id;
}

function dongChiTietDonHang(id2){
	let chitietdonhang = document.querySelector(`#chitietdonhang${id2}`);
	chitietdonhang.classList.remove("hienchitietdonhang");
	denbaophu.classList.remove("hiendenbaophu");
}

denbaophu.addEventListener("click",()=>{
	let chitietdonhang = document.querySelector(".hienchitietdonhang");
	chitietdonhang.classList.remove("hienchitietdonhang");
	denbaophu.classList.remove("hiendenbaophu");
});