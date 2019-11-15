package detai.cnjva.modelFile;

public class SanPham {
	private int maSanPham, donGia, maDanhMuc, hangSanXuat, khuyenMai;
	private double tongDiemDanhGia;
	public int getkhuyenMai() {
		return khuyenMai;
	}
	public void setKhuyenMai(int intKhuyenMai) {
		this.khuyenMai = intKhuyenMai;
	}
	public double gettongDiemDanhGia() {
		return tongDiemDanhGia;
	}
	public void setDiemDanhGia(double diemDanhGia) {
		this.tongDiemDanhGia = diemDanhGia;
	}
	private String tenSanPham, hinhAnh, moTa;
	public int getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public int getMaDanhMuc() {
		return maDanhMuc;
	}
	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
	public int getHangSanXuat() {
		return hangSanXuat;
	}
	public void setHangSanXuat(int hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
		public SanPham() {}
}
