package detai.cnjva.connecDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {


	public static Connection getMySQLConnection()
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
// Khai báo class Driver cho DB MySQL
// Việc này cần thiết với Java 5
// Java6 tự động tìm kiếm Driver thích hợp.
// Nếu bạn dùng Java6, thì ko cần dòng này cũng được.
		String hostName = "localhost";

		String dbName = "ptmpcn";
		String userName = "root";
		String password = "votandong";
 
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}
}

