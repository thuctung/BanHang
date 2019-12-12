package detai.cnjva.DAOFile;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import detai.cnjva.modelFile.GioHang;
import detai.cnjva.modelFile.SanPham;
import junit.framework.Assert;

class GioHangDAOTest {
	
	ArrayList<GioHang> listGioHang = new ArrayList<GioHang>();
	ArrayList<SanPham> listsanpham = new ArrayList<SanPham>();;
	GioHangDAO ghDAO = new GioHangDAO();
	
	@Test
	void testTinhTongTienGioHang() {
		SanPham sp1 = new SanPham();
		sp1.setMaSanPham(1);
		sp1.setSoLuong(2);
		sp1.setDonGia(1000000);
		SanPham sp2 = new SanPham();
		sp2.setMaSanPham(2);
		sp2.setSoLuong(3);
		sp2.setDonGia(2000000);
		listsanpham.add(sp2);
		listsanpham.add(sp1);
		Assert.assertEquals(ghDAO.TinhTongTienGioHang(listsanpham) ,8000000);
	}

	@Test
	void testDemSoLuongGioHang(){
		GioHang gh1 = new GioHang(1, 1);
		GioHang gh2 = new GioHang(2, 2);
		listGioHang.add(gh1);
		listGioHang.add(gh2);
		Assert.assertEquals(ghDAO.DemSoLuongGioHang(listGioHang) ,3);
	}

	@Test
	void testCapNhatSoLuongSanPhamGioHang() {
		GioHang gh1 = new GioHang(5, 2);
		listGioHang.add(gh1);
		ghDAO.CapNhatSoLuongSanPhamGioHang(listGioHang, gh1, 4);
		Assert.assertEquals(gh1.getSoLuong(), 4);
	}

}
