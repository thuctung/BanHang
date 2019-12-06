package detai.cnjva.controllerFile;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import detai.cnjva.DAOFile.UserDAO;
import detai.cnjva.modelFile.User;

@Controller
public class loginController {
	private HttpSession session;
	private UserDAO userDao = new UserDAO();
	private String referer;
	@RequestMapping("/login")
	public String login(Model model,HttpServletRequest request) {
		session = request.getSession();
		String link = request.getHeader("Referer").toString();
		session.setAttribute("linktruocdo", link);
		return "login";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String Posstlogin(Model model, HttpServletRequest request) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		session = request.getSession();
		String userName = request.getParameter("username");
		String password = request.getParameter("matkhau");
		User user = new User();
		user.setUserName(userName);
		user.setPassWord(password);		
		// goi DAO
		referer= session.getAttribute("linktruocdo").toString();
		session.removeAttribute("linktruocdo");
		if(userDao.checkLogin(user)) {
			User userRs = new User();
			userRs = userDao.LayThongTinUser(userName);
			session.setAttribute("idKhachHang", userRs.getIdUser());
			session.setAttribute("TenKhachHang", userRs.getUserName());
		}else {
			request.setAttribute("mess","Mật khẩu hoặc tài khoản không đúng!");
			return "login";
		}
		return "redirect:"+ referer;
	}
	
	@RequestMapping("/logout")
	public String LogOut(HttpServletRequest request) {
		session = request.getSession();
		session.removeAttribute("idKhachHang");
		session.removeAttribute("TenKhachHang");
		referer= request.getHeader("Referer");
		return "redirect:"+ referer;
	}
}
