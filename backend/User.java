package xiaoxueqi;

import java.io.IOException;
import java.sql.SQLException;

public class User {
	private String user_id;
	private String password;
	private String identity;
	private String lName;
	private String fName;
	private String sex;
	private String DoB;
	private String telephone;
	public static int count;
	public User() {User.count++;}
	public User(String id, String p, String i, String l, String f, String s, String d, String t) {
		this.user_id = id;
		this.password = p;
		this.identity = i;
		this.lName = l;
		this.fName = f;
		this.sex = s;
		this.DoB = d;
		this.telephone = t;
		User.count++;
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
	
	
		public static double suijiDouble(int max) {//0��max-1
			return  max*Math.random();
		}
		public static int suijiInt(int max) {//0��max-1
			return  (int) ((int)max*Math.random());
		}
		public static int suijiBiggerInt(int max) {//1��max
			return  (int) (1+(int)max*Math.random());
		}
		public static String suijiChar() {
			return User.suijiInt(10) + "";
		}
		public static String suijiChar(int max) {//0��max-1
			return User.suijiInt(max) + "";
		}
		public static String suijiString( int num) {
			String s = "";
			for(int i = 0; i < num; i++) {
				s = s + User.suijiChar();
			}
			return s;
		}
		//�����û�
		public static void suijicreateUser() {
			String[] fNameChar = {"��","��","��","��","��","֣","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","ʩ","��","��","��","��","��","��","κ","��","��"};
			String[] lNameChar = {"��","˼","ѩ","��","��","��","��","ɺ","��","ľ","��","��","��","��","��","ά","��","��","��","��","ͨ","��","��","�","��","��","��","��","��","��","ϣ","Ϫ","��","��","��","ݷ","ң","Ң","��","��","��","��","��","��"};
			String[] sex = {"��","Ů"};
			
			
			for(int i = 0; i < 1101; i++) {
				User user = new User();
				user.setUser_id("U" + User.count);
				user.setPassword(User.suijiString(8));
				user.setIdentity("�û�");
				user.setLName(fNameChar[User.suijiInt(31)]);
				user.setFName(lNameChar[User.suijiInt(44)] + lNameChar[User.suijiInt(44)]);
				user.setSex(sex[User.suijiInt(2)]);
				user.setDoB((1969 + User.suijiInt(40)) + "-" + (1+User.suijiInt(12)) + "-" +(1+User.suijiInt(28)));
				user.setTelephone("1"+suijiString(10));
				
				AdministratorOperation.insertUser(user);
			}
		}
		
		//�����̼�
				public static void suijicreateShop(String[] dianjia) throws IOException {
					String[] fNameChar = {"��","��","��","��","��","֣","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","ʩ","��","��","��","��","��","��","κ","��","��"};
					String[] lNameChar = {"��","˼","ѩ","��","��","��","��","ɺ","��","ľ","��","��","��","��","��","ά","��","��","��","��","ͨ","��","��","�","��","��","��","��","��","��","ϣ","Ϫ","��","��","��","ݷ","ң","Ң","��","��","��","��","��","��"};
					String[] sex = {"��","Ů"};
					
				
					
					for(int i = 0; i < 1; i++) {
						Shop user = new Shop();
						user.setUser_id("U0" + User.count);
						user.setPassword(User.suijiString(8));
						user.setIdentity("�̼�");
						user.setLName(fNameChar[User.suijiInt(31)]);
						user.setFName(lNameChar[User.suijiInt(44)] + lNameChar[User.suijiInt(44)]);
						user.setSex(sex[User.suijiInt(2)]);
						user.setDoB((1969 + User.suijiInt(40)) + "-" + User.suijiInt(12) + "-" +User.suijiInt(28));
						user.setTelephone("1"+suijiString(10));
						user.setShop_name(dianjia[i]);
						AdministratorOperation.insertShop(user);
					}
				
				}
				
			
		
}
