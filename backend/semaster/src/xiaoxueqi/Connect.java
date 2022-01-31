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
			    Class.forName(driver);//指定连接类型  
	            conn = DriverManager.getConnection(url, user, password);//获取连接  
	            System.out.println("加载jdbc成功！");
	        } 
		catch (Exception e) {   
			 	System.out.println("加载jdbc失败");
	            e.printStackTrace(); 
	        }
		return conn ;
	    }  
	public static Statement getStatement(Connection conn){
		try {
			 System.out.println("连接Mysql server成功");
			 return conn.createStatement();
		 }
		catch (Exception e) {  
			 System.out.println("连接Mysql server失败!");
		      e.printStackTrace();
		      return null ;
		 }
	 }

}
