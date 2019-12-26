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
import detai.cnjva.ServiceFlie.GioHangService;
import detai.cnjva.modelFile.SanPham;
@Controller
public class GioHangController {
	SanPhamDAO  spDAO = new SanPhamDAO();
	ArrayList <SanPham>  listSanPham;
	ArrayList <SanPham> listGioHang = new ArrayList<SanPham>();
	GioHangDAO ghDAO = new GioHangDAO();
	GioHangService ghService = new GioHangService();
	int tien= 0;
	
	@RequestMapping("giohang")
	public String GioHang(Model model, HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		HttpSession session = request.getSession();
		int [] arrayTien;
		if(session.getAttribute("listGioHang") != null) {
			ArrayList<SanPham> SessionGioHang = (ArrayList<SanPham>) session.getAttribute("listGioHang");
			listSanPham = ghDAO.LayThongTinSanPhamTrongGioHang(SessionGioHang);
			arrayTien = ghService.TongTienVaTienGiamGioHang(listSanPham);
			session.setAttribute("tongtien",arrayTien[0]);
			session.setAttribute("giamgia", arrayTien[1]);
			session.setAttribute("thanhtoan", (arrayTien[0] - arrayTien[1]));//thanh toan bằng tổng tiền trừ giảm giá 
			model.addAttribute("listGioHang",listSanPham);
		}	
		return "giohang";
	}
	@RequestMapping(value ="themgiohang", method=RequestMethod.GET)
	public String ThemGioHang(Model model, HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		HttpSession session = request.getSession();
		if(session.getAttribute("listGioHang") == null) {
			session.setAttribute("listGioHang", listGioHang); // khoi tao mang doi tuong session neu chua ton tai
			session.setAttribute("thanhtien",tien);
		}
		int idSanPham = Integer.parseInt(request.getParameter("Masp")); // lay id san pham gui len
		// tao doi tuong san pham tu id gui len
		SanPham sanphamGioHang = new SanPham();
		sanphamGioHang.setMaSanPham(idSanPham);
		sanphamGioHang.setSoLuong(1); 
		// lay gioHang tu session
		ArrayList<SanPham> SessionGioHang = (ArrayList<SanPham>) session.getAttribute("listGioHang");
		boolean check;
		int soLuong = 0; 
		if( request.getParameter("soluong")!= null) {
			soLuong = Integer.parseInt(request.getParameter("soluong"));
		}
		check = ghService.CapNhatSoLuongSanPhamGioHang(SessionGioHang, sanphamGioHang, soLuong);
		if(check == false) SessionGioHang.add(sanphamGioHang); // chi them doi tuong khi check bang false
		session.setAttribute("listGioHang",SessionGioHang);
		session.setAttribute("soluongGioHang",ghService.DemSoLuongGioHang(SessionGioHang));
		return "redirect:/giohang";
	} 
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value ="xoagiohang", method=RequestMethod.GET)
	public String XoaGioHang(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<SanPham> SessionGioHang = (ArrayList<SanPham>) session.getAttribute("listGioHang");
		int masp = Integer.parseInt(request.getParameter("Masp"));
		ghService.XoaSanPhamTrongGioHang(SessionGioHang, masp);
		session.setAttribute("soluongGioHang",ghService.DemSoLuongGioHang(SessionGioHang));
		session.setAttribute("listGioHang",SessionGioHang);
		return "redirect:/giohang";
	}
}
