package detai.cnjva.controllerFile;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import detai.cnjva.DAO.Interface.giohangInterface;
import detai.cnjva.modelFile.SanPham;

@Controller
public class giohangController {
	@Autowired
	private giohangInterface GiohangInterface;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/giohang")
	public ModelAndView gioHang(HttpServletRequest request, ModelAndView modelAndView, HttpSession session)
	{
		if(request.getParameter("maSanPham") == null)
		{
			modelAndView.setViewName("giohangView");
			return modelAndView;
		}
		Integer maSanPham = Integer.parseInt(request.getParameter("maSanPham"));
		SanPham sanPham = GiohangInterface.getSanPham(maSanPham);
		Map<Integer,SanPham> listCart = session.getAttribute("listCart") != null ? (Map<Integer,SanPham>) session.getAttribute("listCart"): new HashMap();
		Map<Integer,Integer> listSL = session.getAttribute("listSL") != null ? (Map<Integer,Integer>) session.getAttribute("listSL"): new HashMap();
		Map<Integer,Integer> listTT = session.getAttribute("listTT") != null ? (Map<Integer,Integer>) session.getAttribute("listTT"): new HashMap();
		for (int i = 0; i < listCart .size(); i++) {
			if(listCart .get(maSanPham) != null)
			{
				int soLuong = listSL.get(maSanPham);
				int donGia = sanPham.getDonGia();
				listSL.put(maSanPham, soLuong + 1);
				listTT.put(maSanPham,(soLuong + 1)* donGia);
				session.setAttribute("messSL", "Có sản phẩm tồn tại");
				modelAndView.setViewName("giohangView");
				return modelAndView;
			}
			
		}
		listCart.put(maSanPham,sanPham);
		listSL.put(maSanPham,1);
		listTT.put(maSanPham,sanPham.getDonGia());
		session.setAttribute("listCart", listCart);
		session.setAttribute("listSL",listSL);
		session.setAttribute("listTT", listTT);
		modelAndView.setViewName("giohangView");
		return modelAndView;
	}
	@SuppressWarnings({ "unchecked"})
	@RequestMapping(value="/xoasession", method = RequestMethod.GET)
	public ModelAndView xoaSession(ModelAndView modelAndView, HttpSession session, HttpServletRequest request)
	{
		Integer maSanPham = Integer.parseInt(request.getParameter("maSanPham"));
		Map<Integer,SanPham> listCart =  (Map<Integer,SanPham>) session.getAttribute("listCart");
		listCart.remove(maSanPham);
		return new ModelAndView("redirect:/giohang");
	}
}
