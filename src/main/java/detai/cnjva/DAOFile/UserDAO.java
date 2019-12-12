package detai.cnjva.DAOFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import detai.cnjva.connecDatabase.connection;
import detai.cnjva.modelFile.User;

public class UserDAO {
	public Connection connec;
	public Boolean checkLogin(User user) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		
		connec = connection.getMySQLConnection();
		String sql = "SELECT * FROM PTMPCN.Account where Account.UserName = ? and Account.Password = ?";
	      PreparedStatement pstm = connec.prepareStatement(sql);
	      pstm.setString(1, user.getUserName());
	      pstm.setString(2, user.getPassWord());
	      ResultSet rs = pstm.executeQuery(); // excute
	      if(rs.next()) {
	    	  return true;
	      }
		return false;
	}
	public User LayThongTinUser(String userName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		User user = new User();
		String sql = "SELECT * FROM PTMPCN.Account where Account.UserName = ?";
		connec = connection.getMySQLConnection();
		PreparedStatement pstm = connec.prepareStatement(sql);
	      pstm.setString(1, userName);
	      ResultSet rs = pstm.executeQuery(); // excute
	      if(rs.next()) {
	    	  user.setIdUser(rs.getInt(1));
	    	  user.setUserName(rs.getString(2));
	    	  user.setRole(rs.getInt(4));
	      }
		return user;
	}
	
	//Thêm tài khoản
	public PreparedStatement pstm;
	public String sql;
	public Boolean ThemUser(User user) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		connec = connection.getMySQLConnection();
		sql = "INSERT INTO PTMPCN.Account(UserName, PassWord, HoTen, SoDienThoai, DiaChi, Email) VALUES(?, ?, ?, ?, ?, ?)";
		pstm = connec.prepareStatement(sql);
		pstm.setString(1, user.getUserName());
		pstm.setString(2, user.getPassWord());
		pstm.setString(3, user.getHoTen());
		pstm.setString(4, user.getSoDienThoai());
		pstm.setString(5, user.getDiaChi());
		pstm.setString(6, user.getDiaChiMail());
		int rs = pstm.executeUpdate();
		if(rs > 0) {
			return true;
		}
		return false;
	}
	
	//Kiểm tra xem UserName đã tồn tại chưa?
	public Boolean KiemTraUser(String UserName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		connec = connection.getMySQLConnection();
		sql = "SELECT COUNT(*) as DEM FROM PTMPCN.Account WHERE UserName = ?";
		pstm = connec.prepareStatement(sql);
		pstm.setString(1, UserName);
		int dem = 0;
		ResultSet rs = pstm.executeQuery();
		if(rs.next()) {
			dem = rs.getInt("DEM");
		}
		//kiểm tra nếu dem > 0 thì có nghĩa là đã tồn tài UserName
		if(dem>0) return true;
		return false;
	}
	
	//
} 
