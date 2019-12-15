package detai.cnjva.controllerFile;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import detai.cnjva.DAOFile.ChiTietDonHangDAO;
import detai.cnjva.DAOFile.DonHangDAO;
import detai.cnjva.modelFile.ChiTietDonHang;
import detai.cnjva.modelFile.DonHang;
import detai.cnjva.modelFile.DonHangQuanLi;

@Controller
public class QuanLyController {
	private DonHangDAO donhangDAO = new DonHangDAO();
	private ChiTietDonHangDAO ctdhDAO = new ChiTietDonHangDAO();
	ArrayList<DonHangQuanLi> list = new  ArrayList<DonHangQuanLi>();
	ArrayList<ChiTietDonHang> listChiTietDH = new  ArrayList<ChiTietDonHang>();
	private HttpSession session;
	
	
	@RequestMapping(value = "/quanly")
	public String QuanLyChung(Model model,HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		session = request.getSession();
		if(session.getAttribute("Role") != null && Integer.parseInt(session.getAttribute("Role").toString()) == 0 ) {
			int sodonHangChoXacNhan = donhangDAO.demsoDonHangChuaXacNhan(); 
			model.addAttribute("sodonhangchoxacnhan", sodonHangChoXacNhan);
			return "quanly";
		}else {
			return "login";
		}
	}
	@RequestMapping(value = "/quanlydonhang", method = RequestMethod.GET)
	public String QuanLy(Model model,HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		HttpSession session = request.getSession();
		int tinhtrang = 0; 
		int chucNangQuanLi = 1;
		if(session.getAttribute("admin") == null) {
			if(request.getParameter("tinhtrang") != null) {
				tinhtrang = Integer.parseInt(request.getParameter("tinhtrang")) > 3 ? 3 : Integer.parseInt(request.getParameter("tinhtrang"));
				list = donhangDAO.LayDonHangQuanLi(true, tinhtrang);
			}
			else {
				list = donhangDAO.LayDonHangQuanLi(false, 0);
			}
			model.addAttribute("listdonhang", list);
			model.addAttribute("chucnang", chucNangQuanLi);
			return "quanly";
		}
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/capnhattrangthai", method = RequestMethod.GET)
	public String capNhatTinhTrangDonHang(Model model,HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		HttpSession session = request.getSession();
		int chucNangQuanLi = 1;
		if(session.getAttribute("admin") == null) {
			if(request.getParameter("madh") != null && request.getParameter("trangthai") != null) {
				int iddonhang = Integer.parseInt(request.getParameter("madh"));
				int trangthai = Integer.parseInt(request.getParameter("trangthai"));
				if(donhangDAO.CapNhatTrangThaiDonHang(trangthai, iddonhang)) {
					model.addAttribute("resultUpdate", "ok");
				}
			}
			model.addAttribute("chucnang", chucNangQuanLi);
			return "quanly";
		}
		return "redirect:/";
	}
}
