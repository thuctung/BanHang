package detai.cnjva.controllerFile;

import java.util.Map;
import java.util.TreeMap;

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
@RequestMapping(value="/giohang")
public class giohangController {
	@Autowired
	private giohangInterface GiohangInterface;
	
	@SuppressWarnings({ "unchecked"})
	@RequestMapping(value="")
	public ModelAndView gioHang(HttpServletRequest request, ModelAndView modelAndView, HttpSession session)
	{
		if(request.getParameter("maSanPham") == null )
		{
			if(session.getAttribute("listCart") !=null )
			{
				Map<Integer,Integer> listTT = (Map<Integer,Integer>) session.getAttribute("listTT");
				float tongThanhTien = 0;
				for (int value: listTT.values()) {
					tongThanhTien += value;
				}
				session.setAttribute("tongThanhTien",tongThanhTien);
			}
			modelAndView.setViewName("giohangView");
			return modelAndView;
		}
		modelAndView.setViewName("giohangView");
		Integer maSanPham = Integer.parseInt(request.getParameter("maSanPham"));
		SanPham sanPham = GiohangInterface.getSanPham(maSanPham);
		Map<Integer,SanPham> listCart = session.getAttribute("listCart") != null ? (Map<Integer,SanPham>) session.getAttribute("listCart"): new TreeMap<>();
		Map<Integer,Integer> listSL = session.getAttribute("listSL") != null ? (Map<Integer,Integer>) session.getAttribute("listSL"): new TreeMap<>();
		Map<Integer,Integer> listTT = session.getAttribute("listTT") != null ? (Map<Integer,Integer>) session.getAttribute("listTT"): new TreeMap<>();
		for (int i = 0; i < listCart.size(); i++) {
			if(listCart.get(maSanPham) != null)
			{
				int soLuong = listSL.get(maSanPham);
				int donGia = sanPham.getDonGia();
				listSL.put(maSanPham, soLuong + 1);
				listTT.put(maSanPham,(soLuong + 1)* donGia);
				
				session.setAttribute("listCart", listCart);
				session.setAttribute("listSL",listSL);
				session.setAttribute("listTT",listTT);
				float tongThanhTien = 0;
				for (int value: listTT.values()) {
					tongThanhTien += value;
				}
				session.setAttribute("tongThanhTien",tongThanhTien);
				return modelAndView;
			}
			
		}
		listCart.put(maSanPham,sanPham);
		listSL.put(maSanPham,1);
		listTT.put(maSanPham,sanPham.getDonGia());
		session.setAttribute("listCart", listCart);
		session.setAttribute("listSL",listSL);
		session.setAttribute("listTT", listTT);
		float tongThanhTien = 0;
		for (int value: listTT.values()) {
			tongThanhTien += value;
		}
		session.setAttribute("tongThanhTien",tongThanhTien);
		return modelAndView;
	}
	@RequestMapping(value="/xoasession", method = RequestMethod.GET)
	public ModelAndView xoaSession(ModelAndView modelAndView, HttpSession session, HttpServletRequest request)
	{
		 Integer maSanPham = Integer.parseInt(request.getParameter("maSanPham"));
		 Map<Integer,SanPham> listCart =(Map<Integer,SanPham>)session.getAttribute("listCart"); 
		 Map<Integer,Integer> listTT =(Map<Integer,Integer>)session.getAttribute("listTT");
		 listCart.remove(maSanPham);
		 listTT.remove(maSanPham);
		 session.setAttribute("listTT", listTT);
		return new ModelAndView("redirect:/giohang");
	}
	
	@RequestMapping(value="/capnhat", method=RequestMethod.POST)
	public ModelAndView thanhTien(ModelAndView modelAndView, HttpServletRequest request, HttpSession session)
	{
		Integer soLuong = Integer.parseInt(request.getParameter("soLuong"));
		Integer maSanPham = Integer.parseInt(request.getParameter("maSanPham"));
		SanPham sanPham = GiohangInterface.getSanPham(maSanPham);
		Map<Integer,SanPham> listCart = (Map<Integer,SanPham>) session.getAttribute("listCart");
		Map<Integer,Integer> listSL = (Map<Integer,Integer>) session.getAttribute("listSL");
		Map<Integer,Integer> listTT = (Map<Integer,Integer>) session.getAttribute("listTT");
		for (Integer key : listCart.keySet()) {
			if(key == maSanPham)
			{
				int donGia = sanPham.getDonGia();
				listSL.put(maSanPham, soLuong);
				listTT.put(maSanPham,(soLuong)* donGia);
				float tongThanhTien = 0;
				session.setAttribute("listCart", listCart);
				session.setAttribute("listSL",listSL);
				session.setAttribute("listTT", listTT);
				for (Integer value: listTT.values()) {
					tongThanhTien += value;
				}
				session.setAttribute("tongThanhTien",tongThanhTien);
				break;
			}	
		}
		session.setAttribute("listCart", listCart);
		session.setAttribute("listSL",listSL);
		session.setAttribute("listTT", listTT);
		float tongThanhTien = 0;
		for (Integer value: listTT.values()) {
			tongThanhTien += value;
		}
		session.setAttribute("tongThanhTien",tongThanhTien);
		return new ModelAndView("redirect:/giohang");
	}
	@RequestMapping(value="/save")
	public ModelAndView MuaHang(ModelAndView modelAndView, HttpSession session)
	{
		Map<Integer,SanPham> listCart = (Map<Integer,SanPham>) session.getAttribute("listCart");
		Map<Integer,Integer> listSL = (Map<Integer,Integer>) session.getAttribute("listSL");
		Map<Integer,Integer> listTT = (Map<Integer,Integer>) session.getAttribute("listTT");
		
		return new ModelAndView("redirect:/giohang");
	}
	
}
