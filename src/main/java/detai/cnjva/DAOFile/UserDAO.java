package detai.cnjva.DAOFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import detai.cnjva.connecDatabase.connection;
import detai.cnjva.modelFile.GetUser;
import detai.cnjva.modelFile.User;

public class UserDAO {
	public Connection connec;
	public Boolean checkLogin(User user) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		
		connec = connection.getMySQLConnection();
		String sql = "SELECT * FROM PTMPCN.Account where Account.UserName = ? and Account.Password = ?";
		 // Táº¡o má»™t Ä‘á»‘i tÆ°á»£ng PreparedStatement.
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
	    	  user.setRole(rs.getInt(4));
	      }
		return user;
	}
	
	//thêm tài khoản
	public Boolean ThemUser(GetUser getUser) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		connec = connection.getMySQLConnection();
		String sql = "INSERT INTO account(UserName, Password, Name, Phone, Address, Email) VALUE(?, ?, ?, ?, ?, ?)";
		PreparedStatement pstm = connec.prepareStatement(sql);
		pstm.setString(1,  getUser.getUserName());
		pstm.setString(2, getUser.getPassWord());
		pstm.setString(3, getUser.getName());
		pstm.setString(4, getUser.getPhone());
		pstm.setString(5, getUser.getAddress());
		pstm.setString(6, getUser.getEmail());
		int rs = pstm.executeUpdate();
		if(rs >0 ) {
			return true;
		}
		return false;
	}
	//kiểm tra username đã tồn tại
	public Boolean CheckUser(String UserName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		connec = connection.getMySQLConnection();
		String sql = "SELECT count(*) as Tong FROM PTMPCN.account WHERE account.UserName = ?";
		PreparedStatement pstm = connec.prepareStatement(sql);
//		GetUser getUser = new GetUser();
		pstm.setString(1,  UserName);
		ResultSet rs = pstm.executeQuery();
		int soluong = 0;
		if(rs.next())
		{
			soluong = rs.getInt("Tong");
		}
		if(soluong > 0) return true;
		return false;
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		Connection connec = connection.getMySQLConnection();
		String sql = "SELECT * FROM PTMPCN.Account where Account.UserName = ? and Account.Password = ?";
		 // Táº¡o má»™t Ä‘á»‘i tÆ°á»£ng PreparedStatement.
	      PreparedStatement pstm = connec.prepareStatement(sql);
	      pstm.setString(1, "admin");
	      pstm.setString(2, "admin");
	      ResultSet rs = pstm.executeQuery(); 
	      if(rs.next()) {
	    	  System.out.print(rs.getString(2));
	      }	
	}
} 
