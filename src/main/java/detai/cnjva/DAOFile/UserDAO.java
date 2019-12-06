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
		 // Tạo một đối tượng PreparedStatement.
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
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		Connection connec = connection.getMySQLConnection();
		String sql = "SELECT * FROM PTMPCN.Account where Account.UserName = ? and Account.Password = ?";
		 // Tạo một đối tượng PreparedStatement.
	      PreparedStatement pstm = connec.prepareStatement(sql);
	      pstm.setString(1, "admin");
	      pstm.setString(2, "admin");
	      ResultSet rs = pstm.executeQuery(); 
	      if(rs.next()) {
	    	  System.out.print(rs.getString(2));
	      }	
	}
} 
