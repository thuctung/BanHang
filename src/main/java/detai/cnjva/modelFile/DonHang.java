package detai.cnjva.modelFile;

public class DonHang {
	private int idDonHang, trangThai, loaiDonHang, giamGia, tongTien, thanhTien;
	private String ngayTao ,soDienThoai;
	
	public DonHang(int iddonhang, String ngaytao, String sdt, int loaidonhang,int giamgia, int tongtien, int thanhtien, String yeucau) {
		this.idDonHang = iddonhang;
		this.ngayTao = ngaytao;
		this.trangThai = 0;
		this.soDienThoai = sdt;
		this.loaiDonHang = loaidonhang;
		this.giamGia = giamgia;
		this.tongTien = tongtien;
		this.thanhTien = thanhtien;
		this.yeuCau = yeucau;
		
	}
	public int getIdDonHang() {
		return idDonHang;
	}

	public void setIdDonHang(int idDonHang) {
		this.idDonHang = idDonHang;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public int getLoaiDonHang() {
		return loaiDonHang;
	}

	public void setLoaiDonHang(int loaiDonHang) {
		this.loaiDonHang = loaiDonHang;
	}

	public int getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(int giamGia) {
		this.giamGia = giamGia;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public int getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}

	public String getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(String ngayTao) {
		this.ngayTao = ngayTao;
	}
	private String yeuCau;
	public String getYeuCau() {
		return yeuCau;
	}
	public void setYeuCau(String yeuCau) {
		this.yeuCau = yeuCau;
	}
	public DonHang() {}
}
