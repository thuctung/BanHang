package detai.cnjva.DAO.Implement;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import detai.cnjva.DAO.Interface.giohangInterface;
import detai.cnjva.modelFile.SanPham;

public class giohangImplement implements giohangInterface {
	public JdbcTemplate jdbcTemplate;
	public giohangImplement(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public SanPham getSanPham(Integer maSanPham) {
		String sql = "SELECT * FROM sanpham WHERE masanpham = "+ maSanPham;
		ResultSetExtractor<SanPham> extractor = new ResultSetExtractor<SanPham>() {
			
			@Override
			public SanPham extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next())
				{
					Integer maSanPham = rs.getInt("masanpham");
					String tenSanPham = rs.getString("tensanpham");
					Integer donGia = rs.getInt("dongia");
					String hinhAnh = rs.getString("hinhanh");
					String moTa = rs.getString("mota");
					Integer maDanhMuc = rs.getInt("madanhmuc");
					return new SanPham(maSanPham,donGia,maDanhMuc,tenSanPham,hinhAnh,moTa);
				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, extractor);
	}
	@Override
	public int save(String masanpham, String tensanpham, int soluong, int thanhtien, int idkhachhang) {
		String sql = "INSERT INTO KHACHHANG(idKhachHang, HoTen, SoDienThoai, DiaChi, Email) VALUES(?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, masanpham,tensanpham,soluong,thanhtien,idkhachhang);
	}
}
