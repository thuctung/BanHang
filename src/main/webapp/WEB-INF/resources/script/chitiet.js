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




