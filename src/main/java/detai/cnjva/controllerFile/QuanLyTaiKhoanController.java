package detai.cnjva.controllerFile;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import detai.cnjva.DAOFile.UserDAO;
import detai.cnjva.modelFile.User;

@Controller
public class QuanLyTaiKhoanController {
	private UserDAO userDao = new UserDAO();
	private User user = new User();
	
	@RequestMapping(value= "/quanlytaikhoan")
	public String QuanLyTaiKhoan(Model model, HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		HttpSession session = request.getSession();
		int quanlichucnang = 2;
		model.addAttribute("hienthiUser", userDao.HienThiUser());
		model.addAttribute("chucnang", quanlichucnang);
		return "quanly";
	}
	
	@RequestMapping(value="/xoa")
	public String XoaTaiKhoan(HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		int iduser = Integer.parseInt(request.getParameter("idUser"));
		userDao.XoaUser(iduser);
		return "redirect:/quanlytaikhoan";
	}
	
	@RequestMapping(value="/themtaikhoan")
	public String ThemTaiKhoan(Model model, HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		user.setUserName(request.getParameter("UserName"));
		user.setPassWord(request.getParameter("PassWord"));
		user.setDiaChiMail(request.getParameter("Email"));
		int check = 1;
		boolean kt = userDao.KiemTraUser(request.getParameter("UserName"));
		if(!kt) {
			userDao.ThemUser(user);
			check = 0;
		}
		HttpSession session = request.getSession();
		session.setAttribute("checkuser", check);
		return "redirect:/quanlytaikhoan";
	}
	
	@RequestMapping(value="/thaydoithongtin")
	public String ThayDoiThongTin(Model model, HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		int id =Integer.parseInt(request.getParameter("id")); 
		user = userDao.HienThiUserById(id);
		model.addAttribute("hienthiUser", user);
		ArrayList<User> list = userDao.HienThiUser();
		model.addAttribute("getRole", list);
		int quanlichucnang = 3;
		model.addAttribute("chucnang", quanlichucnang);
		return "quanly";
	}
	
	@RequestMapping(value="/capnhatUser")
	public String CapNhatthongtin(Model model, HttpServletRequest request) throws NumberFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String password = request.getParameter("PassWord");
		String sodienthoai = request.getParameter("Phone");
		String email = request.getParameter("Email");
		int role = Integer.parseInt(request.getParameter("chucvu"));
		int id = Integer.parseInt(request.getParameter("idtk"));	
		userDao.CapNhatUser(password, sodienthoai, email, role, id);
		return "redirect:/quanlytaikhoan";
	}
	
}
