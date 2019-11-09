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
	private JdbcTemplate jdbcTemplate;
	public UserDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public Boolean checkLogin(User user) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		
		Connection connec = connection.getMySQLConnection();
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
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		Connection connec = connection.getMySQLConnection();
		String sql2 = "SELECT * FROM PTMPCN.SanPham where madanhmuc = 1  ORDER BY masanpham desc limit 5";
		 // Tạo một đối tượng PreparedStatement.
	      PreparedStatement pstm = connec.prepareStatement(sql2);
	      ResultSet rs = pstm.executeQuery(); // excute
	      while(rs.next()) {
	    	  System.out.print("sdfg");
	    	  
	      }
	}
} 
