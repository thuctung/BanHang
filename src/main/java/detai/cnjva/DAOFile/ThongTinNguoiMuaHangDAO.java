package detai.cnjva.DAOFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import detai.cnjva.connecDatabase.connection;
import detai.cnjva.modelFile.ThongTinNguoiMuaHang;

public class ThongTinNguoiMuaHangDAO {
	public Connection connec;
	public PreparedStatement pre;
	
	public boolean ThemThongTinNguoiMuaHang(ThongTinNguoiMuaHang nguoimua) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String sql = "INSERT INTO ThongTinNguoiMuaHang VALUES (?, ?, ?, ?, ?, ?, ?)";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setString(1, nguoimua.getSoDienThoai());
		pre.setString(2, nguoimua.getHoTen());
		pre.setString(3, nguoimua.getTinh());
		pre.setString(4, nguoimua.getHuyen());
		pre.setString(5,nguoimua.getPhuong() );
		pre.setString(6, nguoimua.getSoNha());
		pre.setInt(7, nguoimua.getIdDonHang());
		int check = pre.executeUpdate();
		if(check > 0) {
			return true;
		}
		return false;
	}
	public boolean XoaThongTinNguoiMuaHang(String sodienthoai) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String sql = "DELETE FROM ThongTinNguoiMuaHang WHERE sodienthoai = ?";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setString(1, sodienthoai);
		int check = pre.executeUpdate();
		if(check > 0) {
			return true;
		}
		return false;
	}
}
