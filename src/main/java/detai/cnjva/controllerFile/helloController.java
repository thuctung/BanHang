package detai.cnjva.controllerFile;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import detai.cnjva.DAOFile.SanPhamDAO;
import detai.cnjva.DAOFile.UserInfoDAO;
import detai.cnjva.modelFile.SanPham;
import detai.cnjva.modelFile.UserInfo;
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
		listSP = sqpdao.LaySanPhamTheoDanhMuc(1,5,0); // lay dien thoai noi bat
		listTablet = sqpdao.LaySanPhamTheoDanhMuc(2,5,0); // lay tablet noi bat
		listSPHot = sqpdao.LaySanPhamTheoDanhMuc(1,6,1); // lat dien thoai hot
		listTabletHot = sqpdao.LaySanPhamTheoDanhMuc(2,6,0);
		model.addAttribute("dienthoai", listSP);
		model.addAttribute("tablet", listTablet);
		model.addAttribute("dienthoaiHot", listSPHot);
		model.addAttribute("tabletHot", listTabletHot);
		return "index";
	}
}
