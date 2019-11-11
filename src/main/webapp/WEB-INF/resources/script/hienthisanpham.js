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