package detai.cnjva.modelFile;

public class UserInfo {
	private int idtk;
	public int getIdtk() {
		return idtk;
	}



	public void setIdtk(int idtk) {
		this.idtk = idtk;
	}



	public String getHoTen() {
		return hoTen;
	}



	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}



	public String getDiaChi() {
		return diaChi;
	}



	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}



	public String getSdThoai() {
		return sdThoai;
	}



	public void setSdThoai(String sdThoai) {
		this.sdThoai = sdThoai;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	private String  hoTen, diaChi, sdThoai, email;
	
	

	public UserInfo() {}; 
		
}
