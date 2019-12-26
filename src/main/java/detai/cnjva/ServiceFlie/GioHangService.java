package detai.cnjva.ServiceFlie;

import java.util.ArrayList;

import detai.cnjva.modelFile.SanPham;

public class GioHangService {

	public int[] TongTienVaTienGiamGioHang(ArrayList <SanPham>  listSanPham) {
		int [] arrayTien = new int[2];
		int tongtien = 0;
		int giamgia = 0;
		for(SanPham sp : listSanPham) {
			tongtien += sp.getDonGia()*sp.getSoLuong();
			giamgia += sp.getSoLuong()*sp.getKhuyenMai();
		}
		arrayTien[0] = tongtien;
		arrayTien[1]  = giamgia;
		return arrayTien;
	}
	// phuong thuc tao them de test
	public int TinhTongTienGioHang(ArrayList <SanPham> listSp) {
		int tongtien= 0;
		for(SanPham sanphamGH : listSp) {
			tongtien += sanphamGH.getDonGia()*sanphamGH.getSoLuong();
		}
		return tongtien;
	}
	
	public int DemSoLuongGioHang(ArrayList <SanPham> listGioHang) {
		int soluong =0;
		for(SanPham sanphamGH : listGioHang) {
			soluong += sanphamGH.getSoLuong();
		}
		return soluong;
	
	}
	public void XoaSanPhamTrongGioHang(ArrayList <SanPham> listGioHang,int idSpGh) {
		for(SanPham sanphamGH : listGioHang ) {
			if(sanphamGH.getMaSanPham() == idSpGh ) {
				listGioHang.remove(sanphamGH);
				break;
			}
		}
	}
	public boolean CapNhatSoLuongSanPhamGioHang(ArrayList <SanPham> listGioHang, SanPham sanPhamGioHang, int soLuong) {
		boolean check = false;
		for(SanPham sanphamGH : listGioHang ) {
			if(sanphamGH.getMaSanPham() == sanPhamGioHang.getMaSanPham()) { // nếu 
				if(soLuong == 0) {
					sanphamGH.setSoLuong(sanphamGH.getSoLuong() + 1);
				}
				else {
					sanphamGH.setSoLuong(soLuong);
				}
				check = true;
				break;
			}
		}
		return check;
	}
}
