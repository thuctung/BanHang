package detai.cnjva.DAOFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import detai.cnjva.connecDatabase.connection;
import detai.cnjva.modelFile.ChiTietDonHang;
import detai.cnjva.modelFile.SanPham;

public class ChiTietDonHangDAO {
	public Connection connec;
	public PreparedStatement pre;
	
	public boolean ThemChiTietDonHang(ChiTietDonHang ctdonhang) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String sql = "INSERT INTO ChiTietDonHang VALUES (?, ?, ?)";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, ctdonhang.getIdDonHang());
		pre.setInt(2, ctdonhang.getIdSanPham());
		pre.setInt(3, ctdonhang.getSoLuong());
		int check = pre.executeUpdate();
		if(check > 0) {
			return true;
		}
		return false;
	}
	
	public boolean XoaChiTietDonHang(int madonhang) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String sql = "DELETE FROM ChiTietDonHang WHERE idDonHang = ?";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, madonhang);
		int check = pre.executeUpdate();
		if(check > 0) {
			return true;
		}
		return false;
	}
	
	public ArrayList<ChiTietDonHang> LayDanhSachDonHangTheoMa(int madonhang) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		ArrayList<ChiTietDonHang> list = new ArrayList<ChiTietDonHang>();
		String sql = "SELECT * from ChiTietDonHang WHERE idDonHang = ?";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, madonhang);
		ResultSet res = pre.executeQuery();
		while(res.next()) {
			ChiTietDonHang ctdh = new ChiTietDonHang();
			ctdh.setIdDonHang(res.getInt(1));
			ctdh.setIdSanPham(res.getInt(2));
			ctdh.setSoLuong(res.getInt(3));
			list.add(ctdh);
		} // da co duoc thong tin don hang, tiep truc truy van lay ten, hinh anh, don gia, madanhmuc cua san pham trong tung don hang
		
		for(ChiTietDonHang ctdh : list) {
			SanPham sp = layThongTinSanPhamChiTietDonHang(ctdh.getIdSanPham()); // lay thong tin san pham theo moi chi tiet don hang
			ctdh.setTenSanPham(sp.getTenSanPham());
			ctdh.setDonGia(sp.getDonGia());
			ctdh.setHinhAnh(sp.getHinhAnh());
			ctdh.setMaDanhMuc(sp.getMaDanhMuc());
		}
		return list;
	}
	
	public SanPham layThongTinSanPhamChiTietDonHang(int masanpham) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		SanPham sp = new SanPham();
		String sql = "SELECT tensanpham, dongia, hinhanh, madanhmuc FROM SanPham WHERE masanpham = ?";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, masanpham);
		ResultSet res = pre.executeQuery();
		while(res.next()) {
			sp.setTenSanPham(res.getString(1));
			sp.setDonGia(res.getInt(2));
			sp.setHinhAnh(res.getString(3));
			sp.setMaDanhMuc(res.getInt(4));
		}
		return sp;
	}
}
