package detai.cnjva.modelFile;

public class User {
	private int idUser, role;
	private String userName, passWord;
	public User() {
		
	}
	public User(int idUser, int role, String userName, String passWord) {
		super();
		this.idUser = idUser;
		this.role = role;
		this.userName = userName;
		this.passWord = passWord;
	}
	public int getIdUser() {
		return idUser;
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
