package detai.cnjva.modelFile;

public class DanhGiaSanPham {
	private String ngayDanhGia, noiDungDanhGia, hoTenKhachHang;
	public String getHoTenKhachHang() {
		return hoTenKhachHang;
	}
	public void setHoTenKhachHang(String hoTenKhachHang) {
		this.hoTenKhachHang = hoTenKhachHang;
	}

	private int idKhachHang, maSanPham, diemDanhGia;
	public int getIdKhachHang() {
		return idKhachHang;
	}
	public void setIdKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
	}
	public int getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}
	public int getDiemDanhGia() {
		return diemDanhGia;
	}
	public void setDiemDanhGia(int diemDanhGia) {
		this.diemDanhGia = diemDanhGia;
	}
	public String getNgayDanhGia() {
		return ngayDanhGia;
	}
	public void setNgayDanhGia(String ngayDanhGia) {
		this.ngayDanhGia = ngayDanhGia;
	}
	public String getNoiDungDanhGia() {
		return noiDungDanhGia;
	}
	public void setNoiDungDanhGia(String noiDungDanhGia) {
		this.noiDungDanhGia = noiDungDanhGia;
	}
	
	public DanhGiaSanPham() {};
}
