package detai.cnjva.controllerFile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SanPhamController {

	@RequestMapping("/chitietsanpham")
	public String ChiTietSanPham() {
		return "thongtinsanpham";
	}

}
