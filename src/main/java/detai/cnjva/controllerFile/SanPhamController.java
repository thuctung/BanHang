package detai.cnjva.controllerFile;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import detai.cnjva.DAOFile.ChiTietSanPhamDAO;
import detai.cnjva.DAOFile.DanhGiaSanPhamDAO;
import detai.cnjva.DAOFile.SanPhamDAO;
import detai.cnjva.modelFile.ChiTietSanPham;
import detai.cnjva.modelFile.DanhGiaSanPham;
import detai.cnjva.modelFile.SanPham;

@Controller
public class SanPhamController {
	
	public SanPhamDAO  spDAO = new SanPhamDAO();
	public SanPham sanpham;
	public ChiTietSanPham ctsp;
	public ChiTietSanPhamDAO  ctspDAO;
	public DanhGiaSanPhamDAO danhgiaDAO = new DanhGiaSanPhamDAO();
	public ArrayList<SanPham> list, listTimKiemDT, listTimKiemTablet;
	public ArrayList<DanhGiaSanPham> listDanhGiaSP;
	@RequestMapping(value="/chitietsanpham", method = RequestMethod.GET)
	public String XemThongTinSanPham(Model model,HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		if( request.getParameter("Masp") != null) {
			int masp = Integer.parseInt(request.getParameter("Masp"));
			ctspDAO = new ChiTietSanPhamDAO();
			spDAO = new SanPhamDAO();
			sanpham = spDAO.LaySanPhamTheoMa(masp);
			ctsp = ctspDAO.LayThongTinSanPham(masp);
			listDanhGiaSP = danhgiaDAO.LayDanhSachDanhGiaTheoMaSanPham(masp);
			double diemdanhgia = spDAO.SoDanhGiaTrungBinhSanPham(masp);
			double diemle = diemdanhgia - (int)diemdanhgia;
			model.addAttribute("listDanhGia", listDanhGiaSP);
			model.addAttribute("diemdanhgia", diemdanhgia);
			model.addAttribute("diemle", diemle);
		    model.addAttribute("sanpham", sanpham);
		    model.addAttribute("ctsp", ctsp);
			return "thongtinsanpham";
		}
		else {
			return "redirect:/"; 
		}
		
	}
	
	@RequestMapping(value = "/timkiem", method = RequestMethod.POST)
	public String TimKiemSanPham(Model model, HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		if(request.getParameter("key") != null) {
			String tenCanTim = request.getParameter("key");
			listTimKiemDT = spDAO.TimKiemSanPham(tenCanTim ,1);
			listTimKiemTablet = spDAO.TimKiemSanPham(tenCanTim ,2);
			model.addAttribute("listDT", listTimKiemDT);
			model.addAttribute("listTL", listTimKiemTablet);
			return "timkiem";
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/hienthisanpham", method= RequestMethod.GET)
	public String HienThiSanPham(Model model , HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		// kiem tra trang hien tai co ton tai khong, khong co co thi mac dinh = 1
		int trangHienTai =  request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		float soSanPham1Trang = 20;
		int hangSanXuat = 0;
		// kiem tra nguoi dung co xem san pham theo hang san xuat hay khong, vi co 4 hang san xuat nen mac dinh hang <= 4
		if(request.getParameter("hang") != null) {
			hangSanXuat = Integer.parseInt(request.getParameter("hang")) > 4 ? 4 : Integer.parseInt(request.getParameter("hang"));
		}
		// kiem tra nguoi dung co check sap xep san pham theo don gia hay khong
		boolean sapxep = true;
		if(request.getParameter("sapxep") != null) {
			 if(Integer.parseInt(request.getParameter("sapxep")) == 1){
				 sapxep = false;
			 }
		}
		if(request.getParameter("Madm") != null) {
			list = new ArrayList<SanPham>();
			spDAO = new SanPhamDAO();
			int madm = Integer.parseInt( request.getParameter("Madm"));
			// lay tong so san pham theo ma, neu hangSanXuat > 0 thi truy van them dieu kien hang san xuat
			float tongSoSanPham = spDAO.TongSoSanPham(madm, hangSanXuat); 
			int tongSoTrang = (int)Math.ceil(tongSoSanPham / soSanPham1Trang);
			if(trangHienTai > tongSoTrang) {
				trangHienTai = tongSoTrang;
			}
			int trangBatDau  = (trangHienTai - 1)*(int)soSanPham1Trang;
			
			if(tongSoSanPham <= 0) {
				list = list;
			}else {
				list = spDAO.HienThiDanhSachSanPham(madm, hangSanXuat,(int)soSanPham1Trang, trangBatDau, sapxep);
			}
			model.addAttribute("listSP", list);
			model.addAttribute("sapxep", sapxep);
			model.addAttribute("page",tongSoTrang);
			model.addAttribute("danhmuc",madm);
			model.addAttribute("tranghientai",trangHienTai);
			model.addAttribute("hang", hangSanXuat);
			model.addAttribute("tongsanpham", (int)tongSoSanPham);
			return "hienthisanpham";
		}
		else {
			return "redirect:/"; 
		}
	}
}
