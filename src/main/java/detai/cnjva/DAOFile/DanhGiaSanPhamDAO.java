package detai.cnjva.DAOFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import detai.cnjva.connecDatabase.connection;
import detai.cnjva.modelFile.DanhGiaSanPham;

public class DanhGiaSanPhamDAO {
	
	public DanhGiaSanPhamDAO () {};
	
	public ArrayList<DanhGiaSanPham> LayDanhSachDanhGiaTheoMaSanPham(int masp) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		ArrayList<DanhGiaSanPham> list = new ArrayList<DanhGiaSanPham>();
		String sql = "SELECT * from DanhGiaSanPham Where masanpham = ?";
		Connection connec = connection.getMySQLConnection();
		PreparedStatement pre = connec.prepareStatement(sql);
		pre.setInt(1, masp);
		ResultSet res = pre.executeQuery();
		while(res.next()) {
			DanhGiaSanPham dg = new DanhGiaSanPham();
			dg.setIdKhachHang(res.getInt(1));
			dg.setHoTenKhachHang(LayTenKhachHangTheoMa(res.getInt(2)));
			dg.setDiemDanhGia(res.getInt(6));
			dg.setNgayDanhGia(res.getString(3));
			dg.setNoiDungDanhGia(res.getString(4));
			list.add(dg);
		}
		return list;
	}
	
	public String LayTenKhachHangTheoMa(int makh) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		String sql = "SELECT HoTen from KhachHang Where idKhachHang = ?";
		String ten = "";
		Connection connec = connection.getMySQLConnection();
		PreparedStatement pre = connec.prepareStatement(sql);
		pre.setInt(1, makh);
		ResultSet res = pre.executeQuery();
		while(res.next()) {
			ten = res.getString(1);
		}
		return ten;
	}
}
