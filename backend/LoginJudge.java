package xiaoxueqi;

import java.sql.*;

public class LoginJudge {
	private static Connection conn ;
    private static PreparedStatement pstmt ;
    public static String user_id;
	public static int loginJudge(String account, String password) {
		user_id = account;
		conn = Connect.getConnection();
		String sql = "Select identity from user where user_id = '" + account +"' and password = '"+ password + "'";
		try {
    		pstmt = conn.prepareStatement(sql);
        	pstmt.executeQuery();
        	ResultSet rs = pstmt.executeQuery();
        	if(rs.next() == false) {
        		rs.close();
            	pstmt.close();
            	conn.close();
        		return 0;//无该用户
        	}
        	else {
        		String identity = rs.getString(1);
        		if(identity.contentEquals("商家")) {
        			rs.close();
                	pstmt.close();
                	conn.close();
        			return 2;//商家
        		}
        		else if(identity.contentEquals("管理员") ) {
        			rs.close();
                	pstmt.close();
                	conn.close();
        			return 3;//管理员
        		}
        		else {
        			rs.close();
                	pstmt.close();
                	conn.close();
        			return 1;//用户
        		
        		}
        		
        	}
        	
    	}
    	catch(SQLException e) {
  		  e.printStackTrace();
    	}
		return 0;//返回 0：验证失败，1：用户，2：商家，3：管理员
	}
	
	
	
	
	
	
	
	
	
}
