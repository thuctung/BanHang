package detai.cnjva.controllerFile;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import detai.cnjva.DAOFile.SanPhamDAO;
import detai.cnjva.modelFile.SanPham;

@Controller
public class helloController {
	//@Autowired

	@RequestMapping("/")
	public String hello(Model model) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		ArrayList<SanPham> listSP = new ArrayList<SanPham>();
		ArrayList<SanPham> listTablet = new ArrayList<SanPham>();
		ArrayList<SanPham> listSPHot = new ArrayList<SanPham>();
		ArrayList<SanPham> listTabletHot = new ArrayList<SanPham>();
		SanPhamDAO sqpdao = new SanPhamDAO();
		listSP = sqpdao.SanPhamKhuyenMaiHot(1,5); // lay dien thoai khuyen mai hot
		listTablet = sqpdao.SanPhamKhuyenMaiHot(2,5); // lay tablet khuyen mai hot
		listSPHot = sqpdao.SanPhamNoiBat(1,6); // lat dien thoai hot CO DANH GIA CAO NHAT
		listTabletHot = sqpdao.SanPhamNoiBat(2,6); //lay ablet  co danh gia cao nhat
		model.addAttribute("dienthoai", listSP);
		model.addAttribute("tablet", listTablet);
		model.addAttribute("dienthoaiHot", listSPHot);
		model.addAttribute("tabletHot", listTabletHot);
		return "index";
	}
}



