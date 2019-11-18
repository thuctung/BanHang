package detai.cnjva.controllerFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuanLyController {
	@RequestMapping("/quanly")
	public String QuanLy(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("admin") == null) {
			return "quanly";
		}
		return "redirect:/";
	}
}
