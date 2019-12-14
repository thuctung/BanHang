package detai.cnjva.DAOFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import detai.cnjva.connecDatabase.connection;
import detai.cnjva.modelFile.PhanTrang;
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
	
	//Hiển thị danh sách các tài khoản
	public PhanTrang<User> HienThiUser(int page, int limit) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		connec = connection.getMySQLConnection();
		ArrayList<User> list = new ArrayList<User>();
		
		sql = "SELECT * FROM PTMPCN.Account WHERE Role = 1";
		pstm = connec.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			User user = new User();
			user.setUserName(rs.getString(2));
			user.setPassWord(rs.getString(3));
			user.setHoTen(rs.getString(5));
			user.setSoDienThoai(rs.getString(6));
			user.setDiaChi(rs.getString(7));
			user.setDiaChiMail(rs.getString(8));
			list.add(user);
		}
		return new PhanTrang<User>(list, page, limit);
	}
	
	//Hiển thị danh sách các tài khoản
	//Hiển thị tất cả user(trừ user Role=1 ) vào list 
	public ArrayList<User> HienThiUser() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		connec = connection.getMySQLConnection();
		ArrayList<User> list = new ArrayList<User>();
		sql = "SELECT * FROM PTMPCN.account WHERE Role = 1 OR Role = 2";
		pstm = connec.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			User user = new User();
			user.setIdUser(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setPassWord(rs.getString(3));
			user.setRole(rs.getInt(4));
			user.setHoTen(rs.getString(5));
			user.setSoDienThoai(rs.getString(6));
			user.setDiaChi(rs.getString(7));
			user.setDiaChiMail(rs.getString(8));
			list.add(user);
		}
		return list;
	}
	
	//Xóa user trong trang quản lý tài khoản
	//Xóa user theo id
	public Boolean XoaUser(int idAccount) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		connec = connection.getMySQLConnection();
		sql = "DELETE FROM PTMPCN.account WHERE idAccount = ?";
		pstm = connec.prepareStatement(sql);
		pstm.setInt(1, idAccount);
		int dem = pstm.executeUpdate();
		if(dem >0) {
			return true;
		}
		return false;
	}
	
	public User HienThiUserById(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		connec = connection.getMySQLConnection();
		User user = new User();
		sql = "SELECT * FROM PTMPCN.account WHERE idAccount = ?";
		pstm = connec.prepareStatement(sql);
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			user.setIdUser(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setPassWord(rs.getString(3));
			user.setHoTen(rs.getString(5));
			user.setSoDienThoai(rs.getString(6));
			user.setDiaChi(rs.getString(7));
			user.setDiaChiMail(rs.getString(8));
		}
		return user;
	}
	
	//Cập nhật thông tin
	public Boolean CapNhatUser(String password, String sodienthoai, String email,int role, int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		connec = connection.getMySQLConnection();
		String sql = "UPDATE PTMPCN.account SET PassWord = ?, SoDienThoai = ?, Email = ?, Role = ?  WHERE (idAccount = ?)";
		pstm = connec.prepareStatement(sql);
		pstm.setString(1, password);
		pstm.setString(2, sodienthoai);
		pstm.setString(3, email);
		pstm.setInt(4, role);
		pstm.setInt(5, id);
		int rs = 0;
		rs = pstm.executeUpdate();
		if(rs > 0) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
			Connection connec = connection.getMySQLConnection();
			ArrayList<User> list = new ArrayList<User>();
			User user = new User();
			String sql = "SELECT * FROM PTMPCN.Account";
			PreparedStatement pstm = connec.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				user.setUserName(rs.getString(1));
				user.setPassWord(rs.getString(2));
				user.setHoTen(rs.getString(4));
				user.setSoDienThoai(rs.getString(5));
				user.setDiaChi(rs.getString(6));
				user.setDiaChiMail(rs.getString(7));
				list.add(user);
			}
			System.out.println(list.get(0).getDiaChi());
			
	}
}