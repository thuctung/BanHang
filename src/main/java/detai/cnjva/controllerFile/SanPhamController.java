package detai.cnjva.controllerFile;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import detai.cnjva.DAOFile.ChiTietSanPhamDAO;
import detai.cnjva.DAOFile.SanPhamDAO;
import detai.cnjva.modelFile.ChiTietSanPham;
import detai.cnjva.modelFile.SanPham;

@Controller
public class SanPhamController {
	
	@RequestMapping(value="/chitietsanpham", method = RequestMethod.GET)
	public String XemThongTinSanPham(Model model,HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		if( request.getParameter("Masp") != null) {
			int masp = Integer.parseInt(request.getParameter("Masp"));
			ChiTietSanPhamDAO  ctspDAO = new ChiTietSanPhamDAO();
			SanPhamDAO  spDAO = new SanPhamDAO();
			SanPham sanpham = spDAO.LaySanPhamTheoMa(masp);
			ChiTietSanPham ctsp = ctspDAO.LayThongTinSanPham(masp);
		    model.addAttribute("sanpham", sanpham);
		    model.addAttribute("ctsp", ctsp);
			return "thongtinsanpham";
		}
		else {
			return "redirect:/"; 
		}
		
	}
	
	@RequestMapping(value = "/hienthisanpham", method= RequestMethod.GET)
	public String HienThiSanPham(Model model , HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		int trangHienTai =  request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		int soSanPham1Trang = 10;
		
		if(request.getParameter("Madm") != null) {
			ArrayList<SanPham> list = new ArrayList<SanPham>();
			SanPhamDAO spDAO = new SanPhamDAO();
			int madm = Integer.parseInt( request.getParameter("Madm"));
			int tongSoSanPham = spDAO.TongSoSanPham(madm);
			int tongSoTrang = 1;
			if( Math.ceil(tongSoSanPham / soSanPham1Trang) > 1) {
				tongSoTrang = (int)(tongSoSanPham / soSanPham1Trang) + 1;
			}
			if(trangHienTai > tongSoTrang) {
				trangHienTai = tongSoTrang;
			}
			int trangBatDau  = (trangHienTai - 1)*soSanPham1Trang;
			list = spDAO.HienThiDanhSachSanPham(madm, soSanPham1Trang, trangBatDau);
			model.addAttribute("listSP", list);
			model.addAttribute("page",tongSoTrang);
			model.addAttribute("danhmuc",madm);
			model.addAttribute("tranghientai",trangHienTai);
			return "hienthisanpham";
		}
		else {
			return "redirect:/"; 
		}
	}
}
