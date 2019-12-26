package detai.cnjva.ServiceFlie;


import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import detai.cnjva.modelFile.SanPham;
import junit.framework.Assert;

class GioHangServiceTest {

	ArrayList<SanPham> listsanpham = new ArrayList<SanPham>();
	GioHangService ghService = new GioHangService();
	

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
		Assert.assertEquals(ghService.TinhTongTienGioHang(listsanpham) ,8000000);	
	}

	@Test
	void testDemSoLuongGioHang() {
		SanPham sp1 = new SanPham();
		sp1.setMaSanPham(1);
		sp1.setSoLuong(2);
		SanPham sp2 = new SanPham();
		sp2.setMaSanPham(2);
		sp2.setSoLuong(3);
		listsanpham.add(sp2);
		listsanpham.add(sp1);
		Assert.assertEquals(ghService.DemSoLuongGioHang(listsanpham) ,5);
	}

	@Test
	void testCapNhatSoLuongSanPhamGioHang() {
		SanPham sp1 = new SanPham();
		sp1.setMaSanPham(1);
		sp1.setSoLuong(2);
		listsanpham.add(sp1);
		ghService.CapNhatSoLuongSanPhamGioHang(listsanpham, sp1, 4);
		Assert.assertEquals(sp1.getSoLuong(), 4);
	}

}
