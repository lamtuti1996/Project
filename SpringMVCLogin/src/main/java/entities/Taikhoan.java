package entities;

public class Taikhoan {
  private String username;
  private String password;
  
  
  
  
  
public Taikhoan() {
	super();
	// TODO Auto-generated constructor stub
}

public Taikhoan(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
  
  
}
