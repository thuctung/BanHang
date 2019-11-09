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
	
	
}
