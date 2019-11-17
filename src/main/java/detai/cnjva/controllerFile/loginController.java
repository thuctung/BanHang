package detai.cnjva.controllerFile;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import detai.cnjva.DAOFile.UserDAO;
import detai.cnjva.modelFile.GetUser;
import detai.cnjva.modelFile.User;

@Controller
public class loginController {
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String Posstlogin(Model model, HttpServletRequest request) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		UserDAO userDao = new UserDAO();
		HttpSession session = request.getSession();
		String userName = request.getParameter("username");
		String password = request.getParameter("matkhau");
		User user = new User();
		user.setUserName(userName);
		user.setPassWord(password);		
		// goi DAO
		if(userDao.checkLogin(user)) {
			User userRs = new User();
			userRs = userDao.LayThongTinUser(userName);
			session.setAttribute("idKhachHang", userRs.getIdUser());
			return "redirect:/";
		}else {
			request.setAttribute("mess","Mật khẩu hoặc tài khoản không đúng");
			return "login";
		}		
	}
	
	@RequestMapping("/logout")
	public String LogOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("idKhachHang");
		String referer = request.getHeader("Referer");
		return "redirect:"+ referer;
	}
	
	//Đăng ký tài khoản 11-17
	@RequestMapping(value = "/dangki", method=RequestMethod.POST)
	public String Signin(HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		UserDAO userDao = new UserDAO();
		GetUser getUser = new GetUser();
		getUser.setUserName(request.getParameter("taikhoan"));
		getUser.setPassWord(request.getParameter("password"));
		getUser.setName(request.getParameter("name"));
		getUser.setPhone(request.getParameter("phone"));
		getUser.setAddress(request.getParameter("address"));
		getUser.setEmail(request.getParameter("email"));
		boolean kt = false;
		kt = userDao.CheckUser(request.getParameter("taikhoan"));
		if(!kt)
		{
			userDao.ThemUser(getUser);
		}else {
			request.setAttribute("mess1", "Tài khoản đã có người sử dụng");
		}
		
		return "login";
	}
}
