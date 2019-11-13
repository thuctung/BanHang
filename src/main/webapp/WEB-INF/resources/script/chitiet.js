function checkValue(){
    let value = document.forms["formTimkiem"]["key"].value;
    console.log(value);
    if(value === ""){
        alert("Vui lòng nhập tên cần tìm");
        return false;
    }
}