package detai.cnjva.DAOFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import detai.cnjva.connecDatabase.connection;
import detai.cnjva.modelFile.DonHang;
import detai.cnjva.modelFile.DonHangQuanLi;


public class DonHangDAO {
	public Connection connec;
	public PreparedStatement pre;
	
	public boolean ThemDonHang(DonHang donhang) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String sql = "INSERT INTO DonHang VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, donhang.getIdDonHang());
		pre.setString(2, donhang.getNgayTao());
		pre.setInt(3, donhang.getTrangThai());
		pre.setString(4, donhang.getSoDienThoai());
		pre.setInt(5, donhang.getLoaiDonHang());
		pre.setInt(6, donhang.getGiamGia());
		pre.setInt(7, donhang.getTongTien());
		pre.setInt(8, donhang.getThanhTien());
		pre.setString(9, donhang.getYeuCau());
		int check = pre.executeUpdate();
		pre.close();
		if(check > 0) {
			return true;
		}
		return false;
	}
	public int layMaDonHangCaoNhat() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		int madonhang = 0;
		String sql = "SELECT idDonHang FROM DonHang ORDER BY idDonHang DESC";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		ResultSet res = pre.executeQuery();
		if(res.next()) {
			madonhang = res.getInt(1);
		}
		pre.close();
		return madonhang;
	}
	public boolean XoaDonHang(int madonhang) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String sql = "DELETE FROM  from DonHang idDonHang = ?";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, madonhang);
		int check = pre.executeUpdate();
		if(check > 0) {
			return true;
		}
		return false;
	}
	
	public int demsoDonHangChuaXacNhan() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		int soluong = 0;
		String sql = "SELECT COUNT(*) AS soluong FROM DonHang WHERE TrangThai = 0";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		ResultSet res = pre.executeQuery();
		if(res.next()) {
			soluong = res.getInt("soluong");
		}
		return soluong;
	}

	public ArrayList<DonHangQuanLi> LayDonHangQuanLi(boolean dieukien, int tinhtrang) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		ArrayList<DonHangQuanLi> list = new  ArrayList<DonHangQuanLi>();
		ChiTietDonHangDAO ctdhDAO = new ChiTietDonHangDAO();
		String sql = "";
		connec = connection.getMySQLConnection();
		if(dieukien) {
			 sql = "SELECT * FROM DonHang, ThongTinNguoiMuaHang where ThongTinNguoiMuaHang.idDonHang = DonHang.idDonHang AND TrangThai = ?";
			 pre = connec.prepareStatement(sql);
			 pre.setInt(1, tinhtrang);
		}
		else {
			 sql = "SELECT * FROM DonHang, ThongTinNguoiMuaHang where ThongTinNguoiMuaHang.idDonHang = DonHang.idDonHang";
			 pre = connec.prepareStatement(sql);
		}
		ResultSet res = pre.executeQuery();
		while(res.next()) {
			DonHangQuanLi dhql = new DonHangQuanLi();
			String diachi ="";
			dhql.setIdDonHang(res.getInt(1));
			dhql.setNgayTao(res.getString(2));
			dhql.setTrangThai(res.getInt(3));
			dhql.setSoDienThoai(res.getString(4));
			dhql.setLoaiDonHang(res.getInt(5));
			dhql.setGiamGia(res.getInt(6));
			dhql.setTongTien(res.getInt(7));
			dhql.setThanhTien(res.getInt(8));
			dhql.setYeuCau(res.getString(9));
			dhql.setHoTen(res.getString(11));
			diachi = res.getString(15)+", "+res.getString(14)+", "+res.getString(13)+", "+res.getString(12);
			dhql.setDiaChi(diachi);
			dhql.setChiTietDonHang(ctdhDAO.LayDanhSachDonHangTheoMa(dhql.getIdDonHang()));
			list.add(dhql);
		}
		return list;
	}
	
	public boolean CapNhatTrangThaiDonHang(int trangthai, int madonhang) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		int soluong = 0;
		String sql = "UPDATE DonHang SET trangthai = ? WHERE idDonHang = ? ";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, trangthai);
		pre.setInt(2, madonhang);
		soluong = pre.executeUpdate();
		if(soluong > 0) {
			return true;
		}
		return false;
	}
}
