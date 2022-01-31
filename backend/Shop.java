package xiaoxueqi;

public class Shop extends User{
	private String shop_name;
	public Shop() {super();}
	public Shop(String id, String p, String i, String l, String f, String s, String d, String t, String sn) {
		super(id,p,i,l,f,s,d,t);
		this.shop_name = sn;
	}
	public String getUser_id() {
		return super.getUser_id();
	}
	public void setUser_id(String id) {
		super.setUser_id(id);
	}
	public String getPassword() {
		return super.getPassword();
	}
	public void setPassword(String p) {
		super.setPassword(p);
	}
	public String getIdentity() {
		return super.getIdentity();
	}
	public void setIdentity(String i) {
		super.setIdentity(i);
	}
	public String getLName() {
		return super.getLName();
	}
	public void setLName(String l) {
		super.setLName(l);
	}
	public String getFName() {
		return super.getFName();
	}
	public void setFName(String f) {
		super.setFName(f);
	}
	public String getSex() {
		return super.getSex();
	}
	public void setSex(String s) {
		super.setSex(s);
	}
	public String getDoB() {
		return super.getDoB();
	}
	public void setDoB(String d) {
		super.setDoB(d);
	}
	public String getTelephone() {
		return super.getTelephone();
	}
	public void setTelephone(String t) {
		super.setTelephone(t);
	}
	public String getShop_name() {
		return this.shop_name;
	}
	public void setShop_name(String sn) {
		this.shop_name = sn;
	}
}
