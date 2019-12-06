package detai.cnjva.modelFile;

import java.util.ArrayList;

public class DonHangQuanLi {
	private int idDonHang, trangThai, loaiDonHang,tongTien, giamGia, thanhTien;
	private String yeuCau, soDienThoai, ngayTao, hoTen, diaChi;
	private ArrayList<ChiTietDonHang> chiTietDonHang;
	public ArrayList<ChiTietDonHang> getChiTietDonHang() {
		return chiTietDonHang;
	}
	public void setChiTietDonHang(ArrayList<ChiTietDonHang> chiTietDonHang) {
		this.chiTietDonHang = chiTietDonHang;
	}
	
	public DonHangQuanLi() {}

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

	public int getLoaiDonHang() {
		return loaiDonHang;
	}

	public void setLoaiDonHang(int loaiDonHang) {
		this.loaiDonHang = loaiDonHang;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public int getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(int giamGia) {
		this.giamGia = giamGia;
	}

	public int getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}

	public String getYeuCau() {
		return yeuCau;
	}

	public void setYeuCau(String yeuCau) {
		this.yeuCau = yeuCau;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(String ngayTao) {
		this.ngayTao = ngayTao;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diachi) {
		this.diaChi = diachi;
	}

}
