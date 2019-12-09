package detai.cnjva.DAOFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import detai.cnjva.connecDatabase.connection;
import detai.cnjva.modelFile.DanhGiaSanPham;

public class DanhGiaSanPhamDAO {
	
	public DanhGiaSanPhamDAO () {};
	public Connection connec;
	public PreparedStatement pre;
	public ArrayList<DanhGiaSanPham> LayDanhSachDanhGiaTheoMaSanPham(int masp) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		ArrayList<DanhGiaSanPham> list = new ArrayList<DanhGiaSanPham>();
		String sql = "SELECT * from DanhGiaSanPham Where masanpham = ?";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, masp);
		ResultSet res = pre.executeQuery();
		while(res.next()) {
			DanhGiaSanPham dg = new DanhGiaSanPham();
			dg.setIdKhachHang(res.getInt(1));
			dg.setHoTenKhachHang(LayTenKhachHangTheoMa(res.getInt(1)));
			dg.setNgayDanhGia(res.getString(2));
			dg.setNoiDungDanhGia(res.getString(3));
			dg.setMaSanPham(res.getInt(4));
			dg.setDiemDanhGia(res.getInt(5));
			list.add(dg);
		}
		pre.close();
		return list;
	}
	
	public String LayTenKhachHangTheoMa(int makh) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		String sql = "SELECT HoTen from KhachHang Where idKhachHang = ?";
		String ten = "";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, makh);
		ResultSet res = pre.executeQuery();
		while(res.next()) {
			ten = res.getString(1);
		}
		pre.close();
		return ten;
	}
	
	public boolean XoaDanhGia(int makh, int masp) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String sql = "DELETE from DanhGiaSanPham Where idkhachhang = ? AND masanpham = ?";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, makh);
		pre.setInt(2, masp);
		int res = pre.executeUpdate();
		pre.close();
		if(res > 0) {
			return true;
		}
		return false;
	}
	
	public boolean KiemTraDanhGiaKhachHang(int mkh, int masp) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String sql = "Select count(*) as Tong from DanhGiaSanPham Where idkhachhang = ? AND masanpham = ?";
		int soluong = 0;
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, mkh);
		pre.setInt(2, masp);
		ResultSet res = pre.executeQuery();
		if(res.next()) {
			soluong = res.getInt("Tong");
		}
		pre.close();
		if(soluong > 0 ) return true;
		return false;
	}
	
	public boolean ThemDanhGiaSanPham(int maKH, int masp, int diem, String noidung) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Date d = new Date();
		SimpleDateFormat dateFomat = new SimpleDateFormat ("dd/MM/yyyy");
		String sql ="INSERT INTO DanhGiaSanPham (`idkhachhang`, `ngaydanhgia`, `noidung`, `masanpham`, `diem`) VALUES (?, ?, ?, ?, ?)";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, maKH);
		pre.setString(2, dateFomat.format(d).toString());
		pre.setString(3, noidung);
		pre.setInt(4, masp);
		pre.setInt(5, diem);
		int res = pre.executeUpdate();
		pre.close();
		if(res > 0) return true;
		return false;
	}
	
	public boolean  CapNhatDanhGiaSanPham(int makh, int masp, int sosao, String noidung) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		Date d = new Date();
		SimpleDateFormat dateFomat = new SimpleDateFormat ("dd/MM/yyyy");
		String sql ="UPDATE DanhGiaSanPham SET diem = ?, noidung = ?, ngaydanhgia = ? WHERE idkhachhang = ? AND masanpham = ?";
		
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, sosao);
		pre.setString(2, noidung);
		pre.setString(3, dateFomat.format(d).toString());
		pre.setInt(4, makh);
		pre.setInt(5, masp);
		int res = pre.executeUpdate();
		pre.close();
		if(res > 0) return true;
		return false;
	}
	// cap nhat tong diem danh gia cua san pham o bang SanPham
	public boolean CapNhatSoDiemDanhGia(int masp, double sosao) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		double diem = 0;
		String sql ="Select diemdanhgia from SanPham where masanpham = ?";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, masp);
		ResultSet res = pre.executeQuery();
		while(res.next()) {
			diem =res.getDouble(1);
		}
		diem += sosao;
		diem = diem < 0 ? 0 : diem;
		String sql1 ="Update SanPham set diemdanhgia = ? where masanpham = ?";
		connec = connection.getMySQLConnection();
		 pre = connec.prepareStatement(sql1);
		 pre.setDouble(1, diem);
		 pre.setInt(2, masp);
		int kt = pre.executeUpdate();
		pre.close();
		if(kt > 0) {
			return true;
		}
		return false;
	}
	
}
