function checkValue(){
    let value = document.forms["formTimkiem"]["key"].value;
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


let dropdown = document.querySelector(".dropdown");
dropdown.addEventListener("change", ()=>{
	console.log(dropdown.value);
	let url = window.location.href;
	let vitri =url.indexOf("&&sapxep=");
	let chuoicon = url.slice(vitri,vitri+10);
	url = url.replace(chuoicon,'');
	url = url+"&&sapxep="+dropdown.value;
	console.log(url);
	window.location.href=url;
})


