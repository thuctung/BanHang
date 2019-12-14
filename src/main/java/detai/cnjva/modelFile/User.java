package detai.cnjva.modelFile;

public class User {
	private int idUser, role;
	private String userName, passWord, hoTen, soDienThoai, diaChiMail, diaChi;
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public User() {
		
	}
	public int getIdUser() {
		return idUser;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChiMail() {
		return diaChiMail;
	}
	public void setDiaChiMail(String diaChiMail) {
		this.diaChiMail = diaChiMail;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	} 
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
