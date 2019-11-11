package detai.cnjva.DAOFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import detai.cnjva.connecDatabase.connection;
import detai.cnjva.modelFile.SanPham;

public class SanPhamDAO {
	public SanPhamDAO() {};
	public ArrayList<SanPham> LaySanPhamTheoDanhMuc(int madmuc, int gioiHan, int sapxep) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		String sql = "";
		if(sapxep == 0) {
			sql = "SELECT * FROM PTMPCN.SanPham where madanhmuc = ? limit "+gioiHan;
		}else {
			sql = "SELECT * FROM PTMPCN.SanPham where madanhmuc = ? ORDER BY masanpham DESC limit "+gioiHan;
		}
		Connection connec = connection.getMySQLConnection();
		PreparedStatement pre = connec.prepareStatement(sql);
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
		return list;
	}
	public ArrayList<SanPham> HienThiDanhSachSanPham(int madanhmuc, int gioihan, int batdau) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		String sql ="SELECT * FROM SanPham where madanhmuc = ? LIMIT ? , ?";
		Connection connec = connection.getMySQLConnection();
		PreparedStatement pre = connec.prepareStatement(sql);
		pre.setInt(1, madanhmuc);
		pre.setInt(2, batdau);
		pre.setInt(3, gioihan);
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
		return list;
	}
	public int TongSoSanPham(int madanhmuc) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		int soSanPham = 0;
		String sql ="SELECT count(*) AS TOTAL FROM SanPham where madanhmuc = ?";
		Connection connec = connection.getMySQLConnection();
		PreparedStatement pre = connec.prepareStatement(sql);
		pre.setInt(1, madanhmuc);		
		ResultSet res = pre.executeQuery();
		while(res.next()) 
		{
			soSanPham = res.getInt("TOTAL");
		}
		return soSanPham;
	}
	
	public SanPham LaySanPhamTheoMa(int masp) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		String sql ="SELECT * FROM SanPham where masanpham = ?";
		SanPham sp = new SanPham();
		Connection connec = connection.getMySQLConnection();
		PreparedStatement pre = connec.prepareStatement(sql);
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
		}
		return sp;
	}
	
	public static void main(String [] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		int soSanPham = 0;
		String sql ="SELECT count(*) AS TOTAL FROM SanPham where madanhmuc = ?";
		Connection connec = connection.getMySQLConnection();
		PreparedStatement pre = connec.prepareStatement(sql);
		int madanhmuc = 1;
		pre.setInt(1, madanhmuc);		
		ResultSet res = pre.executeQuery();
		while(res.next()) 
		{
			soSanPham = res.getInt("TOTAL");
		}
		System.out.print(soSanPham);
	}
}
