package detai.cnjva.DAOFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import detai.cnjva.connecDatabase.connection;
import detai.cnjva.modelFile.UserInfo;

public class UserInfoDAO {
	
	public UserInfoDAO() {}
	public ArrayList<UserInfo> getAllUserInfo() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		ArrayList <UserInfo> list = new ArrayList <UserInfo>();
		String sql = "Select * from KhachHang";
		Connection connec = connection.getMySQLConnection();
		PreparedStatement pstm = connec.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			UserInfo useif = new UserInfo();
			useif.setIdtk(rs.getInt(1));
			useif.setHoTen(rs.getString(2));
			useif.setDiaChi(rs.getString(4));
			useif.setSdThoai(rs.getString(3)); 
			useif.setEmail(rs.getString(5));
			list.add(useif);
		}
		return list;
	}
	
	/* Đăng ký tài khoản
	 * 
	 * */
	public Boolean ThemInforUser(UserInfo userInfo) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		Connection connec = connection.getMySQLConnection();
		String sql = "INSERT INTO khachhang(HoTen, SoDienThoai, DiaChi, Email) VALUE(?, ?, ?, ?)";
		PreparedStatement pstm = connec.prepareStatement(sql);
		pstm.setString(1,  userInfo.getHoTen());
		pstm.setString(2, userInfo.getSdThoai());
		pstm.setString(3, userInfo.getDiaChi());
		pstm.setString(4, userInfo.getEmail());
		int rs = pstm.executeUpdate();
		if(rs >0 ) {
			return true;
		}
		return false;
		
	}
	
	
}
