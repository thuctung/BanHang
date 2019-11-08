package detai.cnjva.DAOFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import detai.cnjva.connecDatabase.connection;
import detai.cnjva.modelFile.UserInfo;

public class UserInfoDAO {
	
	private JdbcTemplate jdbcTemplate;
	public UserInfoDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
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
	public static void main(String [] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String sql = "Select * from TAIKHOAN";
		Connection connec = connection.getMySQLConnection();
		PreparedStatement pstm = connec.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print(rs.getString(2));
			System.out.print(rs.getString(3));
			System.out.print(rs.getInt(4));
			System.out.print(rs.getString(5));
			System.out.print(rs.getString(6));
			System.out.print(rs.getString(7));
			System.out.print(rs.getString(8));
		}
	}
}
