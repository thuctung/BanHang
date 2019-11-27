package detai.cnjva.modelFile;

public class ChiTietDonHang {
	private int idDonHang, idSanPham, soLuong;
	public ChiTietDonHang() {};
	public ChiTietDonHang(int iddonhang, int idsanpham, int soluong) {
		this.idDonHang = iddonhang;
		this.idSanPham = idsanpham;
		this.soLuong = soluong;
	};
	public int getIdDonHang() {
		return idDonHang;
	}
	public void setIdDonHang(int idDonHang) {
		this.idDonHang = idDonHang;
	}
	public int getIdSanPham() {
		return idSanPham;
	}
	public void setIdSanPham(int idSanPham) {
		this.idSanPham = idSanPham;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
}
