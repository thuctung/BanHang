package detai.cnjva.connecDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {


	public static Connection getMySQLConnection()
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		String hostName = "localhost";

		String dbName = "PTMPCN";
		String userName = "root";
		String password = "thuctung";
 
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}
}


