function checkValue(){
    let value = document.forms["formTimkiem"]["Timkiem"].value;
    console.log(value);
    if(value === ""){
        alert("Vui lòng nhập tên cần tìm");
        return false;
    }
}
// scroll top top
var btnScroll = document.querySelector(".vedau");
	
window.addEventListener("scroll", ()=>{
    if(window.scrollY < 50){
        btnScroll.classList.add("anScroll");
    }
    else{
        btnScroll.classList.remove("anScroll");
    }
})

function scrollToTop(){
    function scroll(){
        if(window.scrollY > 0){
            setTimeout(() => {
                window.scrollTo(0, window.scrollY - 10)
                scroll()
            }, 6);
        }
    }
    scroll();
}

btnScroll.addEventListener("click",scrollToTop);

// CHUYEN DONG SILE
//chuyen dong slide
var slides = document.querySelectorAll(".slide ul li");
var infoslides = document.querySelectorAll(".infosile ul li a");

function chuyenDong(){
    setInterval(()=>{
        autoSlide();
    },4000)
}
var chisohientai = 0;
const soluongSlide = slides.length;
function autoSlide(){
    var infosileHienTai = infoslides[chisohientai];
    var phantuhientai = slides[chisohientai];
    chisohientai = (chisohientai < soluongSlide -1) ? (chisohientai + 1) :(chisohientai = 0);
    var phantuTieptheo = slides[chisohientai];
    var infosildTiepTheo = infoslides[chisohientai];

    var xylyHienTaiHetThuc = function(){
        this.classList.remove("vewing");
        this.classList.remove("slideBienMat");
    }
    var xulytiepTheoKthuc = function(){
        this.classList.add("vewing");
        this.classList.remove("slideHienThi");
    }
    phantuhientai.addEventListener("webkitAnimationEnd",xylyHienTaiHetThuc);
    phantuTieptheo.addEventListener("webkitAnimationEnd",xulytiepTheoKthuc);
    
    phantuhientai.classList.add("slideBienMat");
    phantuTieptheo.classList.add("slideHienThi");

    infosileHienTai.classList.remove("Stronging");
    infosildTiepTheo.classList.add("Stronging");
}

chuyenDong();


// chuyen dong listKhuyenMai
let btnPhai = document.querySelector("#toright");
let btnTrai = document.querySelector("#toleft");
let listKhuyenMai = document.querySelectorAll(".listkhuyenmai1");


var SoHienTai = 0;

	const soDiv = listKhuyenMai.length;
	
	var status = "dangdung"; // tránh tình trạng kích nhiều lần 

	
	var chuyenSlideChoNutPhai = function(){
        xacDinh2SlideVaoChuyenDong("NutPhai");
	};
	// sự kiện cho nút previous
	var chuyenSlidePrevious = function () {
		xacDinh2SlideVaoChuyenDong("Nuttrai");784.
	}
	
	function xacDinh2SlideVaoChuyenDong(nutNhan){
		// dừng lại nếu kích chuyển slide nhiều lần
		if(status == "dangchuyendong"){
			return false;
        }
		status ="dangchuyendong";// trạng thái của chuyển động
		// kiểm tra chuyển động đã xong chưa, xong thì tăng lên 1
		var check = 0;

		// xac ding 2 phan tu
		var HienTai = listKhuyenMai[SoHienTai];
		SoHienTai = (nutNhan == "Nuttrai") ? ((SoHienTai > 0) ? (SoHienTai-1) : (soDiv - 1 ) ):((SoHienTai < soDiv - 1) ? (SoHienTai + 1) : (SoHienTai = 0));
		
        var TiepTheo = listKhuyenMai[SoHienTai];
		// endAnimation
        var KetThucChuyenDongHT = function(){
            this.classList.remove("danghienthi");
            this.classList.remove((nutNhan == "Nuttrai")?("list1bienmatLeft"):("list1bienmatRight"));
            check ++;
            status = (check == 2) ? ("dangdung") : status;
        }
        var KetThucChuyenDongTTheo = function (){
            this.classList.add("danghienthi");
            this.classList.remove((nutNhan == "Nuttrai")?("list1hienthiLeft"):("list1hienthiRight"));
            check ++;
			status = (check == 2) ? ("dangdung") : status;
        }
        // khi Animation đã được thực hiện xong thì thực hiện tác vụ này
        HienTai.addEventListener("webkitAnimationEnd",KetThucChuyenDongHT);
        TiepTheo.addEventListener("webkitAnimationEnd",KetThucChuyenDongTTheo);

        // xy ly chuyen dong
        HienTai.classList.add("angiatri");
		HienTai.classList.add((nutNhan == "Nuttrai")?("list1bienmatLeft") : ("list1bienmatRight"));
        TiepTheo.classList.remove("angiatri");
        TiepTheo.classList.add((nutNhan == "Nuttrai")?("list1hienthiLeft") : ("list1hienthiRight"));
     
	}
	btnPhai.addEventListener('click',chuyenSlideChoNutPhai);
    btnTrai.addEventListener('click',chuyenSlidePrevious);








