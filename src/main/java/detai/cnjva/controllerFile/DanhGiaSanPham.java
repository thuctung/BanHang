package detai.cnjva.controllerFile;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import detai.cnjva.DAOFile.DanhGiaSanPhamDAO;

@Controller
public class DanhGiaSanPham {
	
	@RequestMapping(value="/xoadanhgia", method = RequestMethod.GET)
	public String XoaDanhGia(Model model , HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		HttpSession session = request.getSession();
		int masp = Integer.parseInt(request.getParameter("masp"));
		double sosao = Double.parseDouble(request.getParameter("sosao"));
		int makh = (int) session.getAttribute("idKhachHang");
		DanhGiaSanPhamDAO dgspDAO = new DanhGiaSanPhamDAO();
		boolean kqXoa = dgspDAO.XoaDanhGia(makh, masp);
		boolean kqCapNhat = dgspDAO.CapNhatSoDiemDanhGia(masp, (sosao* -1));
		if(kqXoa && kqCapNhat) {
			session.setAttribute("delete",true);
		}
		model.addAttribute("Masp", masp);
		return "redirect:/chitietsanpham";
	}
	
	@RequestMapping(value="/chitietsanpham", method = RequestMethod.POST)
	public String ThemDanhGia(Model model , HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		DanhGiaSanPhamDAO dgspDAO = new DanhGiaSanPhamDAO();
		boolean ktra = false ;
		HttpSession session = request.getSession();
		int masp = Integer.parseInt(request.getParameter("masp"));
		int makh = (int) session.getAttribute("idKhachHang");
		double sosao  = Double.parseDouble(request.getParameter("sao"));
		String noidung = request.getParameter("noidungdanhgia");
		ktra = dgspDAO.KiemTraDanhGiaKhachHang(makh, masp);
		if(!ktra) {
			dgspDAO.ThemDanhGiaSanPham(makh,masp,(int) sosao, noidung);
			dgspDAO.CapNhatSoDiemDanhGia(masp, sosao);
			session.setAttribute("insert",ktra);
		}
		else {
			dgspDAO.CapNhatDanhGiaSanPham(makh, masp,(int) sosao, noidung);
			int sosaotruocdo = Integer.parseInt(request.getParameter("saodanhgiatruocupdate"));
			int saocapnhat = (int) Math.abs(sosaotruocdo - sosao);
			if(sosaotruocdo < sosao) {
				dgspDAO.CapNhatSoDiemDanhGia(masp, saocapnhat);
			}
			if(sosaotruocdo > sosao){
				dgspDAO.CapNhatSoDiemDanhGia(masp, saocapnhat * -1);
			}
			
			session.setAttribute("update",ktra);
		}
		model.addAttribute("Masp", masp); // ridetect se gan modelAttribute len thanh dia chi
		return "redirect:/chitietsanpham";
	}
}
