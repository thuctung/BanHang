package detai.cnjva.modelFile;

public class SanPham {
	private int maSanPham, donGia, maDanhMuc, hangSanXuat;
	private String tenSanPham, hinhAnh, moTa;
	public int getMaSanPham() {
		return maSanPham;
	}
	
	public SanPham() {}

	public SanPham(int maSanPham, int donGia, int maDanhMuc, String tenSanPham, String hinhAnh, String moTa) {
		super();
		this.maSanPham = maSanPham;
		this.donGia = donGia;
		this.maDanhMuc = maDanhMuc;
		this.tenSanPham = tenSanPham;
		this.hinhAnh = hinhAnh;
		this.moTa = moTa;
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

	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}

	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", donGia=" + donGia + ", maDanhMuc=" + maDanhMuc + ", tenSanPham="
				+ tenSanPham + ", hinhAnh=" + hinhAnh + ", moTa=" + moTa + "]";
	}
}
		
