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
	
	/*Các phương thức trả về view quanly để tiếp tục điều hướng 
	 * bằng các biến chucnang để trả về view cần thực hiện*/
	@RequestMapping(value= "/quanlytaikhoan")
	public String QuanLyTaiKhoan(Model model, HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		HttpSession session = request.getSession();
		int quanlichucnang = 2;
		model.addAttribute("hienthiUser", userDao.HienThiUser());
		model.addAttribute("chucnang", quanlichucnang);
		return "quanly";
	}
	
	/*Chức năng xóa user theo Id*/
	@RequestMapping(value="/xoa")
	public String XoaTaiKhoan(HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		int iduser = Integer.parseInt(request.getParameter("idUser"));
		userDao.XoaUser(iduser);
		return "redirect:/quanlytaikhoan";
	}
	
	/*Chức năng thêm tài khoản của vai trò quản lý
	Chỉ cần thêm UserName + PassWord + Email (+Role mặc định là người dùng).*/
	@RequestMapping(value="/themtaikhoan")
	public String ThemTaiKhoan(Model model, HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		user.setUserName(request.getParameter("UserName"));
		user.setPassWord(request.getParameter("PassWord"));
		user.setDiaChiMail(request.getParameter("Email"));
		int check = 1;
		boolean kt = userDao.KiemTraUser(request.getParameter("UserName"));
		if(!kt) {
			userDao.AddUser(user);
			check = 0;
		}
		HttpSession session = request.getSession();
		session.setAttribute("checkuser", check);
		return "redirect:/quanlytaikhoan";
	}
	
	/*Lấy dữ liệu theo Id để hiện thị lên view thaydoithongtin*/
	@RequestMapping(value="/thaydoithongtin")
	public String ThayDoiThongTin(Model model, HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		int id =Integer.parseInt(request.getParameter("id")); 
		user = userDao.HienThiUserById(id);
		model.addAttribute("hienthiUser", user);
		int quanlichucnang = 3;
		model.addAttribute("chucnang", quanlichucnang);
		/*trả về view quanly vì trang quanly điều hướng sang view cập nhật thông tin*/
		return "quanly";
	}
	
	/*Chức năng cập nhật thông tin theo Id*/
	@RequestMapping(value="/capnhatUser")
	public String CapNhatthongtin(Model model, HttpServletRequest request) throws NumberFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String password = request.getParameter("PassWord");
		String hoten = request.getParameter("Name");
		String sodienthoai = request.getParameter("Phone");
		String email = request.getParameter("Email");
		int role = Integer.parseInt(request.getParameter("chucvu"));
		int id = Integer.parseInt(request.getParameter("idtk"));
		userDao.CapNhatUser(password, hoten, sodienthoai, email, role, id);
		request.getSession().setAttribute("mess", "Cập nhập thành công!");
		return "redirect:/quanlytaikhoan";
	}
	
}
