package detai.cnjva.modelFile;

public class ThongTinNguoiMuaHang {
	private String soDienThoai, hoTen, tinh, huyen, phuong, soNha;
	private int idDonHang;
	
	public ThongTinNguoiMuaHang(String sdt, String ht, String tinh, String huyen, String phuong, String sonha, int idDonHang) {
		this.soDienThoai = sdt;
		this.hoTen = ht;
		this.tinh = tinh;
		this.huyen = huyen;
		this.phuong = phuong;
		this.soNha = sonha;
		this.idDonHang = idDonHang;
	}
	public int getIdDonHang() {
		return idDonHang;
	}
	public void setIdDonHang(int idDonHang) {
		this.idDonHang = idDonHang;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getTinh() {
		return tinh;
	}

	public void setTinh(String tinh) {
		this.tinh = tinh;
	}

	public String getHuyen() {
		return huyen;
	}

	public void setHuyen(String huyen) {
		this.huyen = huyen;
	}

	public String getPhuong() {
		return phuong;
	}

	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}

	public String getSoNha() {
		return soNha;
	}

	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}

	public ThongTinNguoiMuaHang() {};
}
