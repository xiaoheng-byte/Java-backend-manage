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
        		return 0;//�޸��û�
        	}
        	else {
        		String identity = rs.getString(1);
        		if(identity.contentEquals("�̼�")) {
        			rs.close();
                	pstmt.close();
                	conn.close();
        			return 2;//�̼�
        		}
        		else if(identity.contentEquals("����Ա") ) {
        			rs.close();
                	pstmt.close();
                	conn.close();
        			return 3;//����Ա
        		}
        		else {
        			rs.close();
                	pstmt.close();
                	conn.close();
        			return 1;//�û�
        		
        		}
        		
        	}
        	
    	}
    	catch(SQLException e) {
  		  e.printStackTrace();
    	}
		return 0;//���� 0����֤ʧ�ܣ�1���û���2���̼ң�3������Ա
	}
	
	
	
	
	
	
	
	
	
}
