function checkGioHang(){
    let hoten = document.forms["formGioHang"]["hoTenKH"].value;
    let sdt = document.forms["formGioHang"]["sodienthoai"].value;
    let giaohang = document.forms["formGioHang"]["loaimua"].value;
    let tinh = document.forms["formGioHang"]["tinhthanhpho"].value;
    let quan = document.forms["formGioHang"]["quanhuyen"].value;
    let xa = document.forms["formGioHang"]["phuongxa"].value;
    let sonha = document.forms["formGioHang"]["sonha"].value;
    let check = /((0)+([0-9]{9})\b)/g;
    if(check.test(sdt)){
    	if(hoten === "" || giaohang === "" || tinh === "" || quan === "" || xa === "" ||sonha === ""){
    		alert("Vui lòng nhập đủ thông tin");
    		return false;
    	}
    }
    else{
    	alert("Số điện thoại không phù hợp");
    	 return false;
    }
   
}









function TruSoLuong(masp){
	let divSoluong = document.querySelector("#soluongSanpham"+masp);
	let soluong = divSoluong.innerHTML;
	if(soluong > 1){
		--soluong;
		divSoluong.innerHTML = soluong;
		window.location.href="/BanHang/themgiohang?Masp="+masp+"&&soluong="+soluong;
	}
	else{
		alert("Số lượng phải lớn hơn 0");
	}
	
}

function CongSoLuong(masp){
	let divSoluong = document.querySelector("#soluongSanpham"+masp);
	let soluong = divSoluong.innerHTML;
	if(soluong < 5 ){
		++soluong;
		divSoluong.innerHTML = soluong;
		window.location.href="/BanHang/themgiohang?Masp="+masp+"&&soluong="+soluong;
	}
	else{
		alert("Số lượng phải nhỏ hơn 5");
	}
}
