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

	
	/* 
	 * 6-12
	 * Kiểm tra trước khi vào trang login
	 * Tạo biến session để lưu request
	 * Tạo 1 biến link để lưu chuỗi url trước đó trong biến Referer
	 * Kiểm tra nếu link là chuỗi url 'dangki' thì sẽ không lưu mà chỉ lưu chuỗi url trước đó nữa
	 * */
	private HttpSession session;
	private String referer;
	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest request) {
		session = request.getSession();
		String link = request.getHeader("Referer").toString();
		if(link.indexOf("dangki") < 0) {
			session.setAttribute("linktruocdo", link);
		}
		return "login";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String Posstlogin(Model model, HttpServletRequest request) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		UserDAO userDao = new UserDAO();
		session = request.getSession();
		String userName = request.getParameter("UserName");
		String password = request.getParameter("PassWord");
		User user = new User();
		user.setUserName(userName);
		user.setPassWord(password);		
		if(userDao.checkLogin(user)) {
			User userRs = new User();
			userRs = userDao.LayThongTinUser(userName);
			session.setAttribute("idKhachHang", userRs.getIdUser());
			session.setAttribute("TenKhachHang", userName);
			session.setAttribute("Role", userRs.getRole());
			//tài khoản vs role == 0 || 2 thì sẽ chuyển vào trang quản lý
			if(userRs.getRole() == 0 || userRs.getRole() == 2) {
				return "redirect:/quanly";
			}else {
				String link = session.getAttribute("linktruocdo").toString();
				session.removeAttribute("linktruocdo");
				return "redirect:"+ link;
			}
		}else 
		{
			request.setAttribute("mess","Mật khẩu hoặc tài khoản không đúng!");
			return "login";
		}
	}
	
	@RequestMapping("/logout")
	public String LogOut(HttpServletRequest request) {
		session = request.getSession();
		session.removeAttribute("idKhachHang");
		session.removeAttribute("TenKhachHang");
		referer= request.getHeader("Referer");
		return "redirect:"+ referer;
	}
	
	@RequestMapping("/logoutadmin")
	public String LogOutAdmin(HttpServletRequest request) {
		session = request.getSession();
		session.removeAttribute("idKhachHang");
		session.removeAttribute("TenKhachHang");
		session.removeAttribute("Role");
		referer= request.getHeader("Referer");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/dangki", method=RequestMethod.POST)
	public String AddUser(Model model,  HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		UserDAO userDao = new UserDAO();
		User user = new User();
		int check = 1;
		user.setUserName(request.getParameter("UserName"));
		user.setPassWord(request.getParameter("PassWord"));
		user.setHoTen(request.getParameter("Name"));
		user.setSoDienThoai(request.getParameter("Phone"));
		user.setDiaChiMail(request.getParameter("Email"));
		user.setDiaChi(request.getParameter("Adress"));
		boolean kt = userDao.KiemTraUser(request.getParameter("UserName"));
		if(!kt) {
			userDao.ThemUser(user);
			check = 0;
		}
		request.setAttribute("checkuser", check);
		return "login";
	}
}
