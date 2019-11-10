package detai.cnjva.controllerFile;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SanPhamController {

	@RequestMapping("/chitietsanpham")
	public String ChiTietSanPham() {
		return "index";
	}
	@RequestMapping(value="/chitietsanpham", method = RequestMethod.GET)
	public String XemThongTinSanPham(HttpServletRequest request) {
		if(request.getParameter("Masp") != null) {
			return "thongtinsanpham";
			
		}
		else {
			return "index";
		}
		
	}
}
