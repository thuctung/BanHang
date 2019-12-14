package detai.cnjva.DAOFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import detai.cnjva.connecDatabase.connection;

public class KhuyenMaiDAO {

	private Connection connec;
	private PreparedStatement pre;
	public int layTienKhuyenMAi(int idKhuyenMai) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		int tien = 0;
		String sql  ="SELECT TienKhuyenMAi FROM PTMPCN.KhuyenMai where idKhuyenMai = ?";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, idKhuyenMai);
		ResultSet res = pre.executeQuery();
		while(res.next()) {
			tien = res.getInt(1);
		}
		return tien;
	}
}
