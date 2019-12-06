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
import detai.cnjva.modelFile.DonHangQuanLi;
import detai.cnjva.modelFile.SanPham;

public class SanPhamDAO {
	public SanPhamDAO() {};
	private ArrayList<SanPham> list;
	private Connection connec;
	private PreparedStatement pre;
	public ArrayList<SanPham> SanPhamKhuyenMaiHot(int madmuc, int gioiHan) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		String sql = "SELECT * FROM PTMPCN.SanPham where madanhmuc = ? AND KhuyenMai = ? ORDER BY masanpham limit "+gioiHan;
		list = new ArrayList<SanPham>();
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, madmuc);
		pre.setInt(2, 1);
		ResultSet res = pre.executeQuery();
		while(res.next()) {
			SanPham sp = new SanPham();
			sp.setMaSanPham(res.getInt(1));
			sp.setTenSanPham(res.getString(2));
			sp.setDonGia(res.getInt(3));
			sp.setHinhAnh(res.getString(4));
			sp.setMoTa(res.getString(5));
			sp.setMaDanhMuc(res.getInt(6));
			sp.setHangSanXuat(res.getInt(7));
			list.add(sp);
		}
		pre.close();
		return list;
	}
	
	public ArrayList<SanPham> SanPhamNoiBat(int madmuc, int gioiHan) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		String sql = "SELECT * FROM PTMPCN.SanPham where madanhmuc = ? ORDER BY diemdanhgia DESC limit "+gioiHan;
		list = new ArrayList<SanPham>();
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, madmuc);
		ResultSet res = pre.executeQuery();
		while(res.next()) {
			SanPham sp = new SanPham();
			sp.setMaSanPham(res.getInt(1));
			sp.setTenSanPham(res.getString(2));
			sp.setDonGia(res.getInt(3));
			sp.setHinhAnh(res.getString(4));
			sp.setMoTa(res.getString(5));
			sp.setMaDanhMuc(res.getInt(6));
			sp.setHangSanXuat(res.getInt(7));
			list.add(sp);
		}
		pre.close();
		return list;
	}
	
	public double SoDanhGiaTrungBinhSanPham(int masanpham) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		double sodanhgiaTrungBinh = 0.0;
		double soDanhGia = 1.0;
		String sql = "SELECT COUNT(*) as soluong from DanhGiaSanPham Where masanpham = ?";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, masanpham);
		ResultSet res = pre.executeQuery();
		while(res.next()) 
		{
			soDanhGia = res.getDouble("soluong");
		}
		soDanhGia = soDanhGia <= 0 ? soDanhGia = 1 : soDanhGia;
		sodanhgiaTrungBinh = TinhTongSoDiemDanhGia(masanpham) / soDanhGia;
		return sodanhgiaTrungBinh;
	}
	public double TinhTongSoDiemDanhGia(int masanpham) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		double sodiem = 0;
		String sql = "SELECT diemdanhgia from SanPham WHERE masanpham = ?";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, masanpham);
		ResultSet res = pre.executeQuery();
		if(res.next()) {
			sodiem = res.getDouble(1);
		}
		return sodiem;
	}
	
	public ArrayList<SanPham> HienThiDanhSachSanPham(int madanhmuc, int hangsanxuat, int gioihan, int batdau, boolean sapxep) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		list = new ArrayList<SanPham>();
		connec = connection.getMySQLConnection();
		String sql="";
		if(hangsanxuat == 0) { // thuc hien khi khong co dieu kien hang san xuat
			if(sapxep) {
				 sql="SELECT * FROM SanPham where madanhmuc = ? ORDER BY dongia LIMIT ? , ?";
			}else {
				sql ="SELECT * FROM SanPham where madanhmuc = ? ORDER BY dongia DESC LIMIT ? , ?";
			}			
			pre = connec.prepareStatement(sql);
			pre.setInt(1, madanhmuc);
			pre.setInt(2, batdau);
			pre.setInt(3, gioihan);
		}
		else {
			if(sapxep) {
				sql ="SELECT * FROM SanPham where madanhmuc = ? AND hangsanxuat = ? ORDER BY dongia LIMIT ? , ?";
			}else {
				sql ="SELECT * FROM SanPham where madanhmuc = ? AND hangsanxuat = ? ORDER BY dongia DESC LIMIT ? , ?";
			}
			
			pre = connec.prepareStatement(sql);
			pre.setInt(1, madanhmuc);
			pre.setInt(2, hangsanxuat);
			pre.setInt(3, batdau);
			pre.setInt(4, gioihan);
		}
		ResultSet res = pre.executeQuery();
		while(res.next()) {
			SanPham sp = new SanPham();
			sp.setMaSanPham(res.getInt(1));
			sp.setTenSanPham(res.getString(2));
			sp.setDonGia(res.getInt(3));
			sp.setHinhAnh(res.getString(4));
			sp.setMoTa(res.getString(5));
			sp.setMaDanhMuc(res.getInt(6));
			sp.setHangSanXuat(res.getInt(7));
			sp.setKhuyenMai(res.getInt(8));
			sp.setDiemDanhGia(res.getDouble(9));
			list.add(sp);
		}
		pre.close();
		return list;
	}
	
	public float TongSoSanPham(int madanhmuc, int hangsanxuat) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		float soSanPham = 0;
		connec = connection.getMySQLConnection();
		if(hangsanxuat > 0 ) { // thuc hien khi nguoi dung co chon xem san pham theo hang san xuat
			String sql ="SELECT count(*) AS TOTAL FROM SanPham where madanhmuc = ? and hangsanxuat = ?";
			 pre = connec.prepareStatement(sql);
			pre.setInt(1, madanhmuc);
			pre.setInt(2, hangsanxuat);
		}
		else {
			String sql ="SELECT count(*) AS TOTAL FROM SanPham where madanhmuc = ?";
			connec = connection.getMySQLConnection();
			pre = connec.prepareStatement(sql);
			pre.setInt(1, madanhmuc);	
		}
		ResultSet res = pre.executeQuery();
		while(res.next()) 
		{
			soSanPham = res.getInt("TOTAL");
		}
		pre.close();
		return soSanPham;
	}
	
	public SanPham LaySanPhamTheoMa(int masp) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		String sql ="SELECT * FROM SanPham where masanpham = ?";
		SanPham sp = new SanPham();
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, masp);
		ResultSet res = pre.executeQuery();
		while(res.next()) {
			sp.setMaSanPham(res.getInt(1));
			sp.setTenSanPham(res.getString(2));
			sp.setDonGia(res.getInt(3));
			sp.setHinhAnh(res.getString(4));
			sp.setMoTa(res.getString(5));
			sp.setMaDanhMuc(res.getInt(6));
			sp.setHangSanXuat(res.getInt(7));
			sp.setKhuyenMai(res.getInt(8));
			sp.setDiemDanhGia(res.getDouble(9));
		}
		pre.close();
		return sp;
	}
	
	public ArrayList<SanPham> TimKiemSanPham(String tenCanTim, int madanhmuc) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		String sql = "SELECT * FROM PTMPCN.SanPham where madanhmuc = ? AND tensanpham like '%"+tenCanTim+"%' ORDER BY dongia DESC";
		
		list = new ArrayList<SanPham>();
		
		connec = connection.getMySQLConnection();
		
		pre = connec.prepareStatement(sql);
		pre.setInt(1, madanhmuc);
		ResultSet res = pre.executeQuery();
		while(res.next()) {
			SanPham sp = new SanPham();
			sp.setMaSanPham(res.getInt(1));
			sp.setTenSanPham(res.getString(2));
			sp.setDonGia(res.getInt(3));
			sp.setHinhAnh(res.getString(4));
			sp.setMoTa(res.getString(5));
			sp.setMaDanhMuc(res.getInt(6));
			sp.setHangSanXuat(res.getInt(7));
			list.add(sp);
		}
		pre.close();
		return list;
	}
	
	public int LayDonGia(int masp) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		int tien = 0;
		String sql ="Select dongia from SanPham WHERE masanpham = ?";
		connec = connection.getMySQLConnection();
		pre = connec.prepareStatement(sql);
		pre.setInt(1, masp);
		ResultSet res = pre.executeQuery();
		if(res.next()) {
			tien = res.getInt(1);
		}
		return tien;
	}
	
	public static void main(String [] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		Connection connec = connection.getMySQLConnection();
		String sql = "SELECT * FROM DonHang, ThongTinNguoiMuaHang where ThongTinNguoiMuaHang.sodienthoai = DonHang.sodienthoai";
		PreparedStatement pre = connec.prepareStatement(sql);
		pre = connec.prepareStatement(sql);
		ArrayList<DonHangQuanLi> list = new ArrayList<DonHangQuanLi>();
		ResultSet res = pre.executeQuery();
		while(res.next()) {
			System.out.print(res.getString(4));
		}
	}
}
