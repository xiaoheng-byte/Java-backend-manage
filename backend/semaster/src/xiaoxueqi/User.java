package xiaoxueqi;

public class User {
	private String user_id;
	private String password;
	private String identity;
	private String lName;
	private String fName;
	private String sex;
	private String DoB;
	private String telephone;
	public User() {}
	public User(String id, String p, String i, String l, String f, String s, String d, String t) {
		this.user_id = id;
		this.password = p;
		this.identity = i;
		this.lName = l;
		this.fName = f;
		this.sex = s;
		this.DoB = d;
		this.telephone = t;
	}
	public String getUser_id() {
		return this.user_id;
	}
	public void setUser_id(String id) {
		this.user_id = id;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String p) {
		this.password = p;
	}
	public String getIdentity() {
		return this.identity;
	}
	public void setIdentity(String i) {
		this.identity = i;
	}
	public String getLName() {
		return this.lName;
	}
	public void setLName(String l) {
		this.lName = l;
	}
	public String getFName() {
		return this.fName;
	}
	public void setFName(String f) {
		this.fName = f;
	}
	public String getSex() {
		return this.sex;
	}
	public void setSex(String s) {
		this.sex = s;
	}
	public String getDoB() {
		return this.DoB;
	}
	public void setDoB(String d) {
		this.DoB = d;
	}
	public String getTelephone() {
		return this.telephone;
	}
	public void setTelephone(String t) {
		this.telephone = t;
	}
}
