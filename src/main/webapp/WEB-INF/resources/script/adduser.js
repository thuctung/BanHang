function check() {
	var password = document.getElementById("password").value;
	var confirmpass = document.getElementById("confirmpass").value;
	if(password != null || confirmpass != null) {
		if(password === confirmpass)
		{
			document.getElementById("p").innerHTML = "tích xanh";
		}
		else
			document.getElementById("p").innerHTML = "tích đỏ";
	}
	else if(password === null){
		document.getElementById("p").innerHTML = "pass còn trống";
	}
	else if(confirmpass === null){
		document.getElementById("p").innerHTML = "confirm còn trống";
	}
	
}
