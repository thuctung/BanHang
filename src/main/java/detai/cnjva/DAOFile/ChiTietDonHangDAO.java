package detai.cnjva.DAOFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import detai.cnjva.connecDatabase.connection;
import detai.cnjva.modelFile.ChiTietDonHang;

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
}
