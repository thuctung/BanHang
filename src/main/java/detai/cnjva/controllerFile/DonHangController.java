package detai.cnjva.controllerFile;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import detai.cnjva.DAOFile.ChiTietDonHangDAO;
import detai.cnjva.DAOFile.DonHangDAO;
import detai.cnjva.DAOFile.ThongTinNguoiMuaHangDAO;
import detai.cnjva.modelFile.GioHang;
import detai.cnjva.modelFile.DonHang;
import detai.cnjva.modelFile.ChiTietDonHang;
import detai.cnjva.modelFile.ThongTinNguoiMuaHang;

@Controller
public class DonHangController {
	public DonHangDAO donhangDAO = new DonHangDAO();
	public ChiTietDonHangDAO ctdonhangDAO = new ChiTietDonHangDAO();
	public ThongTinNguoiMuaHangDAO nguoimuaDAO = new ThongTinNguoiMuaHangDAO();
	
	
	@RequestMapping(value="/xacnhandathang", method = RequestMethod.POST)
	public String DonHang(Model model, HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		HttpSession session = request.getSession();
		// tao ngay hien tai khi them don  hang
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String ngaytao = formatter.format(date);
        // lay cac tham so khi nguoi dung guui len
		String hoten = request.getParameter("hoTenKH");
		String sodienthoai = request.getParameter("sodienthoai");
		String yeucau = request.getParameter("ghichu");
		int loaimua = Integer.parseInt(request.getParameter("loaimua"));
		String tinh = request.getParameter("tinhthanhpho");
		String quan = request.getParameter("quanhuyen");
		String xa = request.getParameter("phuongxa");
		String sonha = request.getParameter("sonha");
		int tiengiam = Integer.parseInt(session.getAttribute("giamgia").toString());
		int tongtien = Integer.parseInt(session.getAttribute("tongtien").toString());
		int thanhtien = Integer.parseInt(session.getAttribute("thanhtoan").toString());
		ArrayList<GioHang> SessionGioHang = (ArrayList<GioHang>) session.getAttribute("listGioHang");
		int taoMaDonHang = donhangDAO.layMaDonHangCaoNhat() + 1; 
		// tao cac doi tuong 
		DonHang donhang = new DonHang(taoMaDonHang,ngaytao,sodienthoai,loaimua,tiengiam, tongtien,thanhtien, yeucau);
		ThongTinNguoiMuaHang nguoimua = new ThongTinNguoiMuaHang(sodienthoai,hoten, tinh, quan, xa, sonha, taoMaDonHang);
		boolean check = donhangDAO.ThemDonHang(donhang);
		if(check) {
			nguoimuaDAO.ThemThongTinNguoiMuaHang(nguoimua);
			for(GioHang giohang : SessionGioHang) {
				ChiTietDonHang ctdonhang = new ChiTietDonHang(taoMaDonHang, giohang.getInSanPham(), giohang.getSoLuong());
				ctdonhangDAO.ThemChiTietDonHang(ctdonhang);
			}
			session.removeAttribute("listGioHang");
			session.removeAttribute("soluongGioHang");
			session.removeAttribute("giamgia");
			session.removeAttribute("tongtien");
			session.removeAttribute("thanhtien");
			model.addAttribute("check", true);
		}else {
			model.addAttribute("check", false);
		}
		return "giohang"; 
	}
}
