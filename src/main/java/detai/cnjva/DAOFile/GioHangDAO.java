package detai.cnjva.DAOFile;

import java.sql.SQLException;
import java.util.ArrayList;

import detai.cnjva.modelFile.GioHang;
import detai.cnjva.modelFile.SanPham;

public class GioHangDAO {

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
		for(SanPham sp : listSp) {
			tongtien += sp.getDonGia()*sp.getSoLuong();
		}
		return tongtien;
	}
	
	public int DemSoLuongGioHang(ArrayList <GioHang> listGioHang) {
		int soluong =0;
		for(GioHang gh : listGioHang) {
			soluong += gh.getSoLuong();
		}
		return soluong;
	
	}
	public void XoaSanPhamTrongGioHang(ArrayList <GioHang> listGioHang,int idSpGh) {
		for(GioHang gh : listGioHang ) {
			if(gh.getInSanPham() == idSpGh ) {
				listGioHang.remove(gh);
				break;
			}
		}
	}
	public boolean CapNhatSoLuongSanPhamGioHang(ArrayList <GioHang> listGioHang, GioHang gioHang, int soLuong) {
		boolean check = false;
		for(GioHang gh : listGioHang ) {
			if(gh.getInSanPham() == gioHang.getInSanPham() ) {
				if(soLuong == 0) {
					gh.setSoLuong(gh.getSoLuong() + 1);
				}
				else {
					gh.setSoLuong(soLuong);
				}
				check = true;
				break;
			}
		}
		return check;
	}
	
	public ArrayList <SanPham> LayThongTinSanPhamTrongGioHang(ArrayList<GioHang> listgiohang) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		SanPhamDAO  spDAO = new SanPhamDAO();
		ArrayList <SanPham> listsp = new ArrayList <SanPham>();
		for(GioHang gh : listgiohang) {
			SanPham sp = spDAO.LaySanPhamTheoMa(gh.getInSanPham());
			sp.setSoLuong(gh.getSoLuong());// Why
			listsp.add(sp);
		}
		return listsp;
	}
}
