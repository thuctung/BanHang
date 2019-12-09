package detai.cnjva.controllerFile;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import detai.cnjva.DAOFile.SanPhamDAO;
import detai.cnjva.modelFile.GioHang;
import detai.cnjva.modelFile.SanPham;
@Controller
public class GioHangController {
	public SanPhamDAO  spDAO = new SanPhamDAO();
	public ArrayList <SanPham>  listSanPham;
	ArrayList <GioHang> listGioHang = new ArrayList<GioHang>();
	int tien= 0;
	
	@RequestMapping("giohang")
	public String GioHang(Model model, HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		HttpSession session = request.getSession();
		if(session.getAttribute("listGioHang") != null) {
			ArrayList<GioHang> SessionGioHang = (ArrayList<GioHang>) session.getAttribute("listGioHang");
			listSanPham = new ArrayList <SanPham>();
			for(GioHang gh : SessionGioHang) {
				SanPham sp = spDAO.LaySanPhamTheoMa(gh.getInSanPham());
				sp.setSoLuong(gh.getSoLuong());// Why
				listSanPham.add(sp);
			}
			model.addAttribute("listGioHang",listSanPham);
		}else {
			model.addAttribute("thongtingiohang","tong");
		}		
		return "giohang";
	}
	@RequestMapping(value ="themgiohang", method=RequestMethod.GET)
	public String ThemGioHang(Model model, HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		HttpSession session = request.getSession();
		session.setAttribute("listGioHang", listGioHang); // khoi tao mang doi tuong session da ton tai
		session.setAttribute("thanhtien",tien);
		int idSanPham = Integer.parseInt(request.getParameter("Masp")); // lay id san pham gui len
		GioHang gh = new GioHang();
		gh.setInSanPham(idSanPham);
		gh.setSoLuong(1); 
		ArrayList<GioHang> SessionGioHang = (ArrayList<GioHang>) session.getAttribute("listGioHang");
		boolean check = false;
		for(GioHang ghl : SessionGioHang) {
			if(ghl.getInSanPham() == gh.getInSanPham()) { // kiem tra doi tuong da co trong danh sach chua
				if( request.getParameter("soluong")!= null) { // kiem tra co gui kem so luong hay khong
					int guilen = Integer.parseInt(request.getParameter("soluong"));
					ghl.setSoLuong(guilen); // set so luong da co bang so luong gui len
				}else {
					int soluong = ghl.getSoLuong();
					ghl.setSoLuong(++soluong); // neu khong co so luong thi so luong cu + 1
				}
				check = true; // neu doi tuong da co thi thay doi bien check
				break;
			}
		}
		if(check == false) SessionGioHang.add(gh); // chi them doi tuong khi check bang false
		int tongsanpham = 0;
		for(GioHang ghl : SessionGioHang) { // duyet danh sach de lay so luong san pham dang co va tong tien
			tongsanpham += ghl.getSoLuong();
		}
		session.setAttribute("listGioHang",SessionGioHang);
		session.setAttribute("soluongGioHang",tongsanpham);
		return "redirect:/giohang";
	} 
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value ="xoagiohang", method=RequestMethod.GET)
	public String XoaGioHang(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<GioHang> SessionGioHang = (ArrayList<GioHang>) session.getAttribute("listGioHang");
		int masp = Integer.parseInt(request.getParameter("Masp"));
		for(GioHang gh : SessionGioHang ) {
			if(gh.getInSanPham() == masp ) {
				SessionGioHang.remove(gh);
				break;
			}
		}
		int tongsanpham = 0;
		for(GioHang ghl : SessionGioHang) { // duyet danh sach de lay so luong san pham dang co va tong tien
			tongsanpham += ghl.getSoLuong();
		}
		session.setAttribute("soluongGioHang",tongsanpham);
		session.setAttribute("listGioHang",SessionGioHang);
		return "redirect:/giohang";
	}
}
