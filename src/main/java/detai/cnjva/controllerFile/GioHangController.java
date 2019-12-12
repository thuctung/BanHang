package detai.cnjva.controllerFile;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import detai.cnjva.DAOFile.GioHangDAO;
import detai.cnjva.DAOFile.SanPhamDAO;
import detai.cnjva.modelFile.GioHang;
import detai.cnjva.modelFile.SanPham;
@Controller
public class GioHangController {
	public SanPhamDAO  spDAO = new SanPhamDAO();
	public ArrayList <SanPham>  listSanPham;
	ArrayList <GioHang> listGioHang = new ArrayList<GioHang>();
	GioHangDAO ghDAO = new GioHangDAO();
	int tien= 0;
	
	@RequestMapping("giohang")
	public String GioHang(Model model, HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		HttpSession session = request.getSession();
		int [] arrayTien;
		if(session.getAttribute("listGioHang") != null) {
			ArrayList<GioHang> SessionGioHang = (ArrayList<GioHang>) session.getAttribute("listGioHang");
			listSanPham = ghDAO.LayThongTinSanPhamTrongGioHang(SessionGioHang);
			arrayTien = ghDAO.TongTienVaTienGiamGioHang(listSanPham);
			session.setAttribute("tongtien",arrayTien[0]);
			session.setAttribute("giamgia", arrayTien[1]);
			session.setAttribute("thanhtoan", (arrayTien[0] - arrayTien[1]));
			model.addAttribute("listGioHang",listSanPham);
		}	
		return "giohang";
	}
	@RequestMapping(value ="themgiohang", method=RequestMethod.GET)
	public String ThemGioHang(Model model, HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		HttpSession session = request.getSession();
		if(session.getAttribute("listGioHang") == null) {
			session.setAttribute("listGioHang", listGioHang); // khoi tao mang doi tuong session da ton tai
			session.setAttribute("thanhtien",tien);
		}
		int idSanPham = Integer.parseInt(request.getParameter("Masp")); // lay id san pham gui len
		GioHang gh = new GioHang();
		gh.setInSanPham(idSanPham);
		gh.setSoLuong(1); 
		ArrayList<GioHang> SessionGioHang = (ArrayList<GioHang>) session.getAttribute("listGioHang");
		boolean check;
		int soLuong = 0;
		if( request.getParameter("soluong")!= null) {
			soLuong = Integer.parseInt(request.getParameter("soluong"));
		}
		check = ghDAO.CapNhatSoLuongSanPhamGioHang(SessionGioHang, gh, soLuong);
		if(check == false) SessionGioHang.add(gh); // chi them doi tuong khi check bang false
		session.setAttribute("listGioHang",SessionGioHang);
		session.setAttribute("soluongGioHang",ghDAO.DemSoLuongGioHang(SessionGioHang));
		return "redirect:/giohang";
	} 
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value ="xoagiohang", method=RequestMethod.GET)
	public String XoaGioHang(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<GioHang> SessionGioHang = (ArrayList<GioHang>) session.getAttribute("listGioHang");
		int masp = Integer.parseInt(request.getParameter("Masp"));
		ghDAO.XoaSanPhamTrongGioHang(SessionGioHang, masp);
		session.setAttribute("soluongGioHang",ghDAO.DemSoLuongGioHang(SessionGioHang));
		session.setAttribute("listGioHang",SessionGioHang);
		return "redirect:/giohang";
	}
}
