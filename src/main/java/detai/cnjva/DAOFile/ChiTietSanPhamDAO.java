package detai.cnjva.DAOFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import detai.cnjva.connecDatabase.connection;
import detai.cnjva.modelFile.ChiTietSanPham;

public class ChiTietSanPhamDAO {
	public ChiTietSanPhamDAO() {}
	
	public ChiTietSanPham LayThongTinSanPham(int masp) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		ChiTietSanPham ctspham = new ChiTietSanPham();
		Connection connec = connection.getMySQLConnection();
		String sql = "SELECT * FROM ThongTinSanPham Where masanpham = ?";
		PreparedStatement pre = connec.prepareStatement(sql);
		pre.setInt(1, masp);
		ResultSet res = pre.executeQuery();
		while(res.next()) {
			ctspham.setMaSanPham(res.getInt(1));
			ctspham.setManHinh(res.getString(2));
			ctspham.setHeDieuHanh(res.getString(3));
			ctspham.setCameraSau(res.getString(4));
			ctspham.setCammeraTruoc(res.getString(5));
			ctspham.setCpu(res.getString(6));
			ctspham.setRam(res.getString(7));
			ctspham.setBoNhoTrong(res.getString(8));
			ctspham.setTheNho(res.getString(9));
			ctspham.setSim(res.getString(10));
			ctspham.setDungLuongPin(res.getString(11));
		}
		return ctspham;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		ArrayList<ChiTietSanPham> list = new ArrayList<ChiTietSanPham>();
		Connection connec = connection.getMySQLConnection();
		String sql = "SELECT * FROM ThongTinSanPham Where masanpham = ?";
		PreparedStatement pre = connec.prepareStatement(sql);
		pre.setInt(1, 2);
		ResultSet res = pre.executeQuery();
		while(res.next()) {
			ChiTietSanPham ctspham = new ChiTietSanPham();
			ctspham.setMaSanPham(res.getInt(1));
			ctspham.setManHinh(res.getString(2));
			ctspham.setHeDieuHanh(res.getString(3));
			ctspham.setCameraSau(res.getString(4));
			ctspham.setCammeraTruoc(res.getString(5));
			ctspham.setCpu(res.getString(6));
			ctspham.setRam(res.getString(7));
			ctspham.setBoNhoTrong(res.getString(8));
			ctspham.setTheNho(res.getString(9));
			ctspham.setSim(res.getString(10));
			ctspham.setDungLuongPin(res.getString(11));
			list.add(ctspham);
		}
		System.out.print(list.get(0).getDungLuongPin());
	}
}
