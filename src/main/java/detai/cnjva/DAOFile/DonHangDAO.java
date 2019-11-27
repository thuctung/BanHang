package detai.cnjva.DAOFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import detai.cnjva.connecDatabase.connection;
import detai.cnjva.modelFile.DonHang;


public class DonHangDAO {
	public Connection connec;
	public PreparedStatement pre;
	
	public boolean ThemDonHang(DonHang donhang) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String sql = "INSERT INTO DonHang VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, donhang.getIdDonHang());
		pre.setString(2, donhang.getNgayTao());
		pre.setInt(3, donhang.getTrangThai());
		pre.setString(4, donhang.getSoDienThoai());
		pre.setInt(5, donhang.getLoaiDonHang());
		pre.setInt(6, donhang.getGiamGia());
		pre.setInt(7, donhang.getTongTien());
		pre.setInt(8, donhang.getThanhTien());
		pre.setString(9, donhang.getYeuCau());
		int check = pre.executeUpdate();
		pre.close();
		if(check > 0) {
			return true;
		}
		return false;
	}
	public int layMaDonHangCaoNhat() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		int madonhang = 0;
		String sql = "SELECT idDonHang FROM DonHang ORDER BY idDonHang DESC";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		ResultSet res = pre.executeQuery();
		if(res.next()) {
			madonhang = res.getInt(1);
		}
		pre.close();
		return madonhang;
	}
	public boolean XoaDonHang(int madonhang) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String sql = "DELETE FROM  from DonHang idDonHang = ?";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, madonhang);
		int check = pre.executeUpdate();
		if(check > 0) {
			return true;
		}
		return false;
	}
	
	public int demsoDonHangChuaXacNhan() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		int soluong = 0;
		String sql = "SELECT COUNT(*) AS soluong FROM DonHang WHERE TrangThai = 0";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		ResultSet res = pre.executeQuery();
		if(res.next()) {
			soluong = res.getInt("soluong");
		}
		return soluong;
	}
	public boolean CapNhatTrangThaiDonHang(int trangthai) {
		return false;
	}
}
