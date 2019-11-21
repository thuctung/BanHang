package detai.cnjva.DAO.Interface;

import detai.cnjva.modelFile.SanPham;

public interface giohangInterface {
	public SanPham getSanPham(Integer maSanPham);
	public int save(String masanpham, String tensanpham, int soluong, int thanhtien, int idkhachhang);
	
}
