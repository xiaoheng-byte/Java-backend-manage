package xiaoxueqi;

import java.sql.*;

public class Connect {
	public static final String url = "jdbc:mysql://localhost:3306/xiaoxueqi1?" 
			+"serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8";  
	public static final String driver = "com.mysql.cj.jdbc.Driver";  
	public static final String user = "root";  
	public static final String password = "Fnx0202";  
	  
	public static Connection getConnection() {
		Connection conn = null;  
		try {  
			    Class.forName(driver);//ָ����������  
	            conn = DriverManager.getConnection(url, user, password);//��ȡ����  
	            System.out.println("����jdbc�ɹ���");
	        } 
		catch (Exception e) {   
			 	System.out.println("����jdbcʧ��");
	            e.printStackTrace(); 
	        }
		return conn ;
	    }  
	public static Statement getStatement(Connection conn){
		try {
			 System.out.println("����Mysql server�ɹ�");
			 return conn.createStatement();
		 }
		catch (Exception e) {  
			 System.out.println("����Mysql serverʧ��!");
		      e.printStackTrace();
		      return null ;
		 }
	 }

}
