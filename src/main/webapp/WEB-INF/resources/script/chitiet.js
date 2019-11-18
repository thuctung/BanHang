function checkValue(){
    let value = document.forms["formTimkiem"]["key"].value;
    console.log(value);
    if(value === ""){
        alert("Vui lòng nhập tên cần tìm");
        return false;
    }
}



function checkGuiDanhGia(){
    let value1 = document.forms["formDanhGia"]["sao"].value;
    let value2 = document.forms["formDanhGia"]["noidungdanhgia"].value;
    if(value1 === "" || value2 === "" ){
        alert("Vui lòng nhập đủ nội dung");
        return false;
    }else{
    	btnUpdate.classList.remove("hienthi");
    	btnSuadanhgia.classList.remove("andi");
    	saoUpdate.classList.remove("hienthi");
    	saodanhgia.classList.remove("andi");
    	formcomment.classList.remove("Hienthiform");
    	formcomment.readOnly = true;
    }
}

function checkGuiUpdate(){
    let value1 = document.forms["formUpdate"]["sao"].value;
    let value2 = document.forms["formUpdate"]["noidungdanhgia"].value;
    if(value1 === "" || value2 === "" ){
        alert("Vui lòng nhập đủ nội dung");
        return false;
    }
}

let xemdanhgia = document.querySelector(".xemdanhgia");
let btndanhgia = document.querySelector("#danhgiasanpham");



function danhgia(){
	window.scrollTo(0, 749);
}
if(btndanhgia != null){
	btndanhgia.addEventListener("click", danhgia);
}
xemdanhgia.addEventListener("click", danhgia);



// gioi han so ki tu danh gia san pham
let textDanhGia = document.querySelector("#noidungdanhgia");
textDanhGia.addEventListener("keyup", ()=>{
	if(textDanhGia.value.length > 100){
		textDanhGia.value = textDanhGia.value.substring(0, 100);
	}
})

var btnSuadanhgia = document.querySelector("#suadanhgia");
var btnUpdate = document.querySelector(".btnUpdate");
var saoUpdate = document.querySelector(".saoUpdate");
var saodanhgia = document.querySelector(".saoupdate");
var formcomment = document.querySelector(".formcomment");
btnSuadanhgia.addEventListener("click", ()=>{
	btnUpdate.classList.add("hienthi");
	btnSuadanhgia.classList.add("andi");
	saoUpdate.classList.add("hienthi");
	saodanhgia.classList.add("andi");
	formcomment.readOnly = false;
	formcomment.autofocus = true;
	formcomment.classList.add("Hienthiform");
})
formcomment.addEventListener("keyup", ()=>{
	if(formcomment.value.length > 100){
		formcomment.value = formcomment.value.substring(0, 100);
	}
})

