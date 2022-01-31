package xiaoxueqi;

import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdministratorOperation {
	private static Connection conn ;
    private static PreparedStatement pstmt ;
    
    //�û�����
    //�����û�
    public static void insertUser(User user){
    	conn = Connect.getConnection();
    	String sql = "insert into User(user_id, password, identity, lName, fName, sex, DoB, telephone) values(?,?,?,?,?,?,?,?)";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	pstmt.setString(1, user.getUser_id());
        	pstmt.setString(2, user.getPassword());
        	pstmt.setString(3, user.getIdentity());
        	pstmt.setString(4, user.getLName());
        	pstmt.setString(5, user.getFName());
        	pstmt.setString(6, user.getSex());
        	pstmt.setString(7, user.getDoB());
        	pstmt.setString(8, user.getTelephone());
        	pstmt.executeUpdate();
        	System.out.println("�����û��ɹ���");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
  		  e.printStackTrace();
    	}
    }
  //ɾ���û�
    public static void deleteUser(String user_id){
    	conn = Connect.getConnection();
    	String sql = "update User set isExist = 0 where user_id = '" + user_id + "'";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	pstmt.executeUpdate();
        	System.out.println("ɾ���û��ɹ���");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
  		  e.printStackTrace();
    	}
    }
    //�����û���Ϣ
    public static void updateUser(String user_id, String password, String telephone){
    	conn = Connect.getConnection();
    	String sql = "update User set password = ?, telephone = ? where user_id = '" + user_id + "'";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	pstmt.setString(1, password);
        	pstmt.setString(2, telephone);
        	pstmt.executeUpdate();
        	System.out.println("�����û���Ϣ�ɹ���");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
    }
    //���ҷ����������û�
    public static JTable selectUserByAttribute(String attributeName, String attribute){
    	conn = Connect.getConnection();
    	String sql = "select user_id as '�û����',  lName as '��', fName as '��', sex as '�Ա�', DoB as '����' , telephone as '�绰��'  "
    			+ " from User where  isExist = 1 and " + attributeName + " = '" + attribute + "'";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	DefaultTableModel tablemodel=new DefaultTableModel(); //���ģ��
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //�������
            for (int j=1; j<=count; j++) {                       //����������ӵ����ģ����Ϊ���⣬����š�1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
            }
        	//��������и���������ӵ����ģ�ͣ�һ�α���
            Object[] columns=new Object[count];                //�����ж������飬���鳤��Ϊ����
            while (rs.next())                                //�����������������ǰ������ÿ��
            {
                for (int j=1; j<=columns.length; j++)          //���ÿ�и���ֵ
                    columns[j-1]=rs.getString(j);
                tablemodel.addRow(columns);                    //���ģ�����һ�У�����ָ������ֵ
            }
            rs.close();
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
    
    
    //�̼ҹ���
    //�����̼�
    public static void insertShop(Shop shop){
    	conn = Connect.getConnection();
    	String sql1 = "insert into User(user_id, password, identity, lName, fName, sex, DoB, telephone) values(?,?,?,?,?,?,?,?)";
    	String sql2 = "insert into Shop(shopkeeper_id,shop_name) values(?,?)";
    	try {
    		pstmt = conn.prepareStatement(sql1);
        	pstmt.setString(1, shop.getUser_id());
        	pstmt.setString(2, shop.getPassword());
        	pstmt.setString(3, shop.getIdentity());
        	pstmt.setString(4, shop.getLName());
        	pstmt.setString(5, shop.getFName());
        	pstmt.setString(6, shop.getSex());
        	pstmt.setString(7, shop.getDoB());
        	pstmt.setString(8, shop.getTelephone());
        	pstmt.executeUpdate();
        	pstmt = conn.prepareStatement(sql2);
        	pstmt.setString(1, shop.getUser_id());
        	pstmt.setString(2, shop.getShop_name());
        	pstmt.executeUpdate();
        	System.out.println("�����̼ҳɹ���");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
  		  e.printStackTrace();
    	}
    }
    //ɾ���̼�
    public static void deleteShop(String user_id){
    	conn = Connect.getConnection();
    	String sql1 = "update User set isExist = 0 where user_id = '" + user_id + "'";	//ɾ���̼�user��Ϣ
    	//String sql2 = "delete from Shop where shopkeeper_id = '" + user_id + "'";	//ɾ�����̼�
    	String sql3 = "update Product set isExist = 0 where shopkeeper_id = '" + user_id + "'";	//ɾ���õ���Ʒ
    	try {
    		pstmt = conn.prepareStatement(sql3);
        	pstmt.executeUpdate();
        	//pstmt = conn.prepareStatement(sql2);
        	//pstmt.executeUpdate();
        	pstmt = conn.prepareStatement(sql1);
        	pstmt.executeUpdate();
        	System.out.println("ɾ���̼ҳɹ���");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
  		  e.printStackTrace();
    	}
    }
    //�����̼���Ϣ
    public static void updateShop(String user_id, String password, String telephone,String shop_name){
    	conn = Connect.getConnection();
    	String sql1 = "update User set password = ?, telephone = ? where user_id = '" + user_id + "'";
    	String sql2 = "update Shop set shop_name = ? where shopkeeper_id = '" + user_id + "'";
    	try {
    		pstmt = conn.prepareStatement(sql1);
        	pstmt.setString(1, password);
        	pstmt.setString(2, telephone);
        	pstmt.executeUpdate();
        	pstmt = conn.prepareStatement(sql2);
        	pstmt.setString(1, shop_name);
        	pstmt.executeUpdate();
        	System.out.println("�����̼ҳɹ���");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
    }
    //���ҷ����������̼�
    public static JTable selectShopByAttribute(String attributeName, String attribute){
    	conn = Connect.getConnection();
    	String sql = "select u.user_id as '���̱��', s.shop_name as '������',  u.telephone as '�绰��' , u.lName as '������', u.fName as '������', u.sex as '�Ա�', u.DoB as '����'  from User u, Shop s "
    			+ "where u.isExist = 1 and u.user_id = s.shopkeeper_id and " + attributeName + " = '" + attribute + "'";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	DefaultTableModel tablemodel=new DefaultTableModel(); //���ģ��
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //�������
            for (int j=1; j<=count; j++) {                       //����������ӵ����ģ����Ϊ���⣬����š�1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
            }
        	//��������и���������ӵ����ģ�ͣ�һ�α���
            Object[] columns=new Object[count];                //�����ж������飬���鳤��Ϊ����
            while (rs.next())                                //�����������������ǰ������ÿ��
            {
                for (int j=1; j<=columns.length; j++)          //���ÿ�и���ֵ
                    columns[j-1]=rs.getString(j);
                tablemodel.addRow(columns);                    //���ģ�����һ�У�����ָ������ֵ
            }
            rs.close();
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
    
    
    //�̼ҹ���
    //�¼ܣ�ɾ������Ʒ
    public static void deleteProduct(String product_id, String shopkeeper_id) {
    	conn = Connect.getConnection();
    	String sql = "update Product  set isExist = 0  where shopkeeper_id = '" + shopkeeper_id + "' and product_id = '" + product_id + "'";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	pstmt.executeUpdate();
        	System.out.println("ɾ����Ʒ�ɹ���");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
  		  e.printStackTrace();
    	}
    }
    //������Ʒ
    public static JTable selectProductByAttribute(String attributeName, String attribute){
    	conn = Connect.getConnection();
    	String sql = "select product_id as '��Ʒ���', shopkeeper_id as '�̼ұ��',   product_name as '��Ʒ��', s_category as '��Ʒ���',price as '�۸�', present_stock as'�����', product_introduction as '��Ʒ˵��' "
    			+ "  from Product where  isExist = 1 and " + attributeName + " = '" + attribute + "'";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	
        	DefaultTableModel tablemodel=new DefaultTableModel(); //���ģ��
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //�������
            for (int j=1; j<=count; j++) {                       //����������ӵ����ģ����Ϊ���⣬����š�1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
            }
        	//��������и���������ӵ����ģ�ͣ�һ�α���
            Object[] columns=new Object[count];                //�����ж������飬���鳤��Ϊ����
            while (rs.next())                                //�����������������ǰ������ÿ��
            {
                for (int j=1; j<=columns.length; j++)          //���ÿ�и���ֵ
                    columns[j-1]=rs.getString(j);
                tablemodel.addRow(columns);                    //���ģ�����һ�У�����ָ������ֵ
            }
            rs.close();
            
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
    
    
    //String l_category, String m_category, 
    //������
    //��С��
    public static void updateS_Category(String s_category,String newS){
    	conn = Connect.getConnection();
    	String sql1 = "update Category set s_category = ? where s_category = '" + s_category + "'";
    	String sql2 = "update Product set s_category = ? where s_category is NULL";
    	try {
    		pstmt = conn.prepareStatement(sql1);
        	pstmt.setString(1, newS);
        	pstmt.executeUpdate();
    		pstmt = conn.prepareStatement(sql2);
        	pstmt.setString(1, newS);
        	pstmt.executeUpdate();
        	System.out.println("����С��ɹ���");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
    }
    
    //������
    public static void updateM_Category(String m_category,String newM){
    	conn = Connect.getConnection();
    	String sql1 = "update Category set m_category = ? where m_category = '" + m_category + "'";
    	try {
    		pstmt = conn.prepareStatement(sql1);
        	pstmt.setString(1, newM);
        	pstmt.executeUpdate();
        	System.out.println("��������ɹ���");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
    }
    
  //�Ĵ���
    public static void updateL_Category(String l_category,String newL){
    	conn = Connect.getConnection();
    	String sql1 = "update Category set l_category = ? where l_category = '" + l_category + "'";
    	try {
    		pstmt = conn.prepareStatement(sql1);
        	pstmt.setString(1, newL);
        	pstmt.executeUpdate();
        	System.out.println("���´���ɹ���");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
    }
    
    
    
    
    
    
    //��������
      
    //��������1����ѯĳʱ��εĶ��������ܽ��
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByTime(String t_from, String t_to){
    	conn = Connect.getConnection();
    	String sql = "select count(distinct order_id) as '��ʱ��ζ�����', sum(total_price) as '��ʱ��ζ����ܽ��'  from OrderInfo where state != '��ȡ��' and order_time > '" + t_from + "' and order_time < '" + t_to + "'" ;
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	DefaultTableModel tablemodel=new DefaultTableModel(); //���ģ��
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //�������
            for (int j=1; j<=count; j++) {                       //����������ӵ����ģ����Ϊ���⣬����š�1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
            }
          //��������и���������ӵ����ģ�ͣ�һ�α���
            Object[] columns=new Object[count];                //�����ж������飬���鳤��Ϊ����
            while (rs.next())                                //�����������������ǰ������ÿ��
            {
                for (int j=1; j<=columns.length; j++)          //���ÿ�и���ֵ
                    columns[j-1]=rs.getString(j);
                tablemodel.addRow(columns);                    //���ģ�����һ�У�����ָ������ֵ
            }
            rs.close();
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);      //�������ָ�����ģ��
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
    
    //��������2.1����ѯĳС����Ʒ�Ķ��������ܽ��
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByS_Category(String s_category){
    	conn = Connect.getConnection();
    	String sql = "select count(distinct op.order_id) as '������Ʒ������', sum(op.amount*p.price) as '������Ʒ�����ܽ��'  from OrderProduct op, Product p ,OrderInfo oi where oi.order_id = op.order_id and  oi.state != '��ȡ��'  and p.product_id = op.product_id and p.s_category = '" + s_category + "'";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	DefaultTableModel tablemodel=new DefaultTableModel(); //���ģ��
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //�������
            for (int j=1; j<=count; j++) {                       //����������ӵ����ģ����Ϊ���⣬����š�1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
            }
          //��������и���������ӵ����ģ�ͣ�һ�α���
            Object[] columns=new Object[count];                //�����ж������飬���鳤��Ϊ����
            while (rs.next())                                //�����������������ǰ������ÿ��
            {
                for (int j=1; j<=columns.length; j++)          //���ÿ�и���ֵ
                    columns[j-1]=rs.getString(j);
                tablemodel.addRow(columns);                    //���ģ�����һ�У�����ָ������ֵ
            }
            rs.close();
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);      //�������ָ�����ģ��
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
  //��������2.2����ѯĳ������Ʒ�Ķ��������ܽ��
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByM_Category(String m_category){
    	conn = Connect.getConnection();
    	String sql = "select count(distinct op.order_id) as '������Ʒ������', sum(op.amount*p.price) as '������Ʒ�����ܽ��'    from OrderProduct op, Product p, Category c, OrderInfo oi  where  oi.order_id = op.order_id and  oi.state != '��ȡ��'  and p.product_id = op.product_id and p.s_category = c.s_category and c.m_category = '" + m_category + "'";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	DefaultTableModel tablemodel=new DefaultTableModel(); //���ģ��
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //�������
            for (int j=1; j<=count; j++) {                       //����������ӵ����ģ����Ϊ���⣬����š�1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
            }
          //��������и���������ӵ����ģ�ͣ�һ�α���
            Object[] columns=new Object[count];                //�����ж������飬���鳤��Ϊ����
            while (rs.next())                                //�����������������ǰ������ÿ��
            {
                for (int j=1; j<=columns.length; j++)          //���ÿ�и���ֵ
                    columns[j-1]=rs.getString(j);
                tablemodel.addRow(columns);                    //���ģ�����һ�У�����ָ������ֵ
            }
            rs.close();
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);      //�������ָ�����ģ��
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
  
    
    //��������2.3����ѯĳ������Ʒ�Ķ��������ܽ��
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByL_Category(String l_category){
    	conn = Connect.getConnection();
    	
    	String sql = "select count(distinct op.order_id) as '������Ʒ������', sum(op.amount*p.price) as '������Ʒ�����ܽ��'    from OrderProduct op, Product p, Category c, OrderInfo oi  where  oi.order_id = op.order_id and  oi.state != '��ȡ��'  and p.product_id = op.product_id and p.s_category = c.s_category and c.l_category = '" + l_category + "'";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	
        	
        	DefaultTableModel tablemodel=new DefaultTableModel(); //���ģ��
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //�������
            for (int j=1; j<=count; j++) {                       //����������ӵ����ģ����Ϊ���⣬����š�1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
            }
        	//��������и���������ӵ����ģ�ͣ�һ�α���
            Object[] columns=new Object[count];                //�����ж������飬���鳤��Ϊ����
            while (rs.next())                                //�����������������ǰ������ÿ��
            {
                for (int j=1; j<=columns.length; j++)          //���ÿ�и���ֵ
                    columns[j-1]=rs.getString(j);
                tablemodel.addRow(columns);                    //���ģ�����һ�У�����ָ������ֵ
            }
            rs.close();
        	
            
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);      //�������ָ�����ģ��
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
    
    
    //��������3����ѯĳʱ�����ǰʮ��������Ʒ
    public static JTable selectMostPopularProductByTime(String t_from, String t_to){
    	conn = Connect.getConnection();
    	String sql ="select p.shopkeeper_id as '���̱��', p.product_id as '��Ʒ���'  , p.product_name as '��Ʒ��'  , sum(op.amount) as '��ʱ����ڶ�������'  "
    			+ "from OrderInfo oi, OrderProduct op, Product p   "
    			+ "where oi.state != '��ȡ��'  and p.product_id = op.product_id and oi.order_id = op.order_id and oi.order_time > '" + t_from + "' and oi.order_time < '" + t_to + "'"
    			+ "group by p.shopkeeper_id, p.product_id, p.product_name order by sum(op.amount) desc,p.shopkeeper_id asc  limit 10";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	
        	DefaultTableModel tablemodel=new DefaultTableModel(); //���ģ��
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //���resultSet������
        	tablemodel.addColumn("����");
            for (int j=1; j<=count; j++) {                       //����������ӵ����ģ����Ϊ���⣬����š�1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
                System.out.println(j);
            }
            
          //��������и���������ӵ����ģ�ͣ�һ�α���
            Object[] columns=new Object[count + 1];                //�����ж������飬���鳤��Ϊ����
            while (rs.next())                                //�����������������ǰ������ÿ��
            {
                for (int j=1, k = 0; j<columns.length; j++,k++) {         //���ÿ�и���ֵ
                     columns[0] =tablemodel.getRowCount() + 1;
                	columns[j]=rs.getString(j);
                	 System.out.println(j);
                }
                tablemodel.addRow(columns);                    //���ģ�����һ�У�����ָ������ֵ
               
            }
            rs.close();
            
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);      //�������ָ�����ģ��
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
  //��������4����ѯǰʮ��������Ʒ
    public static JTable selectMostPopularProduct(){
    	
    	conn = Connect.getConnection();
    	String sql ="select p.product_id as '��Ʒ���' , p.product_name as '��Ʒ��' , sum(op.amount)  as '��������' "
    			+ "from OrderProduct op, Product p, OrderInfo oi   "
    			+ "where oi.state != '��ȡ��'  and oi.order_id = op.order_id and p.product_id = op.product_id  "
    			+ "group by p.product_id, p.product_name order by sum(op.amount) desc,p.shopkeeper_id asc limit 10";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	
        	DefaultTableModel tablemodel=new DefaultTableModel(); //���ģ��
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //���resultSet������
        	tablemodel.addColumn("����");
            for (int j=1; j<=count; j++) {                       //����������ӵ����ģ����Ϊ���⣬����š�1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
                System.out.println(j);
            }
            
          //��������и���������ӵ����ģ�ͣ�һ�α���
            Object[] columns=new Object[count + 1];                //�����ж������飬���鳤��Ϊ����
            while (rs.next())                                //�����������������ǰ������ÿ��
            {
                for (int j=1, k = 0; j<columns.length; j++,k++) {         //���ÿ�и���ֵ
                     columns[0] =tablemodel.getRowCount() + 1;
                	columns[j]=rs.getString(j);
                	 System.out.println(j);
                }
                tablemodel.addRow(columns);                    //���ģ�����һ�У�����ָ������ֵ
               
            }
            rs.close();
            
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);      //�������ָ�����ģ��
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
  //��������5����ѯ����ǰʮ����Ʒ
    public static JTable selectBestScoreProduct(){
    	
    	conn = Connect.getConnection();
    	String sql ="select p.product_id as '��Ʒ���', p.shopkeeper_id as '���̱��',  p.product_name as '��Ʒ��',  avg(op.score) as '����' "
    			+ " from product p, OrderProduct op,OrderInfo oi  where oi.state != '��ȡ��'  and oi.order_id = op.order_id and p.product_id = op.product_id  "
    			+ "group by p.product_id, p.product_name order by avg(op.score) desc, p.product_id asc limit 10";
    			
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	
        	DefaultTableModel tablemodel=new DefaultTableModel(); //���ģ��
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //���resultSet������
        	tablemodel.addColumn("����");
            for (int j=1; j<=count; j++) {                       //����������ӵ����ģ����Ϊ���⣬����š�1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
                System.out.println(j);
            }
            
          //��������и���������ӵ����ģ�ͣ�һ�α���
            Object[] columns=new Object[count + 1];                //�����ж������飬���鳤��Ϊ����
            while (rs.next())                                //�����������������ǰ������ÿ��
            {
                for (int j=1, k = 0; j<columns.length; j++,k++) {         //���ÿ�и���ֵ
                     columns[0] =tablemodel.getRowCount() + 1;
                	columns[j]=rs.getString(j);
                	 System.out.println(j);
                }
                tablemodel.addRow(columns);                    //���ģ�����һ�У�����ָ������ֵ
               
            }
            rs.close();
            
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);      //�������ָ�����ģ��
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
    
    //�����̼�ͳ��ĳ��ʱ��Ķ��������ܽ��
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByShopAndTime( String t_from, String t_to){
    	
    	conn = Connect.getConnection();
    	String sql = "select s.shopkeeper_id as '�̼ұ��', s.shop_name as '�̼���', count(distinct oi.order_id) as '�õ��̸�ʱ��ζ�����' , sum(oi.total_price) as '�õ��̸�ʱ��ζ����ܽ��'  from  OrderInfo oi, Shop s " +
    			" where oi.shopkeeper_id = s.shopkeeper_id and oi.state !='��ȡ��' and oi.order_time > '"+ t_from +"' and oi.order_time < '"+ t_to +"'"
    			+ " group by s.shopkeeper_id, s.shop_name";
    			
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	
        	DefaultTableModel tablemodel=new DefaultTableModel(); //���ģ��
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //�������
            for (int j=1; j<=count; j++) {                       //����������ӵ����ģ����Ϊ���⣬����š�1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
            }
          //��������и���������ӵ����ģ�ͣ�һ�α���
            Object[] columns=new Object[count];                //�����ж������飬���鳤��Ϊ����
            while (rs.next())                                //�����������������ǰ������ÿ��
            {
                for (int j=1; j<=columns.length; j++)          //���ÿ�и���ֵ
                    columns[j-1]=rs.getString(j);
                tablemodel.addRow(columns);                    //���ģ�����һ�У�����ָ������ֵ
            }
            rs.close();
            
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);      //�������ָ�����ģ��
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
    
    //ĳ��ʱ����ڣ���������ǰʮ�����̼�
    public static JTable selectMostSellShopByTime( String t_from, String t_to){
    	
    	conn = Connect.getConnection();
    	String sql = "select s.shopkeeper_id as '�̼ұ��', s.shop_name as '�̼���', count(distinct oi.order_id) as '�õ��̸�ʱ����ܶ�����'   from  OrderInfo oi, Shop s " +
    			" where oi.shopkeeper_id = s.shopkeeper_id and oi.state !='��ȡ��' and oi.order_time > '"+ t_from +"' and oi.order_time < '"+ t_to +"'"
    			+ " group by s.shopkeeper_id, s.shop_name order by count(distinct oi.order_id) desc, s.shopkeeper_id asc limit 10";
    			
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	
        	DefaultTableModel tablemodel=new DefaultTableModel(); //���ģ��
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //���resultSet������
        	tablemodel.addColumn("����");
            for (int j=1; j<=count; j++) {                       //����������ӵ����ģ����Ϊ���⣬����š�1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
                System.out.println(j);
            }
            
          //��������и���������ӵ����ģ�ͣ�һ�α���
            Object[] columns=new Object[count + 1];                //�����ж������飬���鳤��Ϊ����
            while (rs.next())                                //�����������������ǰ������ÿ��
            {
                for (int j=1, k = 0; j<columns.length; j++,k++) {         //���ÿ�и���ֵ
                     columns[0] =tablemodel.getRowCount() + 1;
                	columns[j]=rs.getString(j);
                	 System.out.println(j);
                }
                tablemodel.addRow(columns);                    //���ģ�����һ�У�����ָ������ֵ
               
            }
            rs.close();
            
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);      //�������ָ�����ģ��
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
    
	//ĳ��ʱ����ڣ��ɹ��µ����ǰʮ�����û�
    public static JTable selectMostBuyUserByTime( String t_from, String t_to){
    	
    	conn = Connect.getConnection();
    	String sql = "select u.user_id as '�û����',  sum(oi.total_price) as '���û���ʱ������µ����'   from  OrderInfo oi, User u " +
    			" where oi.user_id = u.user_id and oi.state !='��ȡ��' and oi.order_time > '"+ t_from +"' and oi.order_time < '"+ t_to +"'"
    			+ " group by u.user_id order by sum(oi.total_price) desc, u.user_id asc limit 10";
    			
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	
        	DefaultTableModel tablemodel=new DefaultTableModel(); //���ģ��
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //���resultSet������
        	tablemodel.addColumn("����");
            for (int j=1; j<=count; j++) {                       //����������ӵ����ģ����Ϊ���⣬����š�1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
                System.out.println(j);
            }
            
          //��������и���������ӵ����ģ�ͣ�һ�α���
            Object[] columns=new Object[count + 1];                //�����ж������飬���鳤��Ϊ����
            while (rs.next())                                //�����������������ǰ������ÿ��
            {
                for (int j=1, k = 0; j<columns.length; j++,k++) {         //���ÿ�и���ֵ
                     columns[0] =tablemodel.getRowCount() + 1;
                	columns[j]=rs.getString(j);
                	 System.out.println(j);
                }
                tablemodel.addRow(columns);                    //���ģ�����һ�У�����ָ������ֵ
               
            }
            rs.close();
            
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);      //�������ָ�����ģ��
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
    	
    //ÿ���µĶ��������ͽ�����ͳ�ƣ�Ҫ�󶩵�ʱ���Ȳ�����һ�꣩
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByMonth( String t_from, String t_to){
    	
    	conn = Connect.getConnection();
    	String sql = "select date_format(order_time,'%Y-%m') as '�·�', count(order_id) as '������', sum(total_price) as '�ܽ��' from OrderInfo oi "
    			+ "where state != '��ȡ��' and order_time > '"+ t_from +"' and order_time < '"+ t_to +"' "
    			+ "group by date_format(order_time,'%Y-%m') order by date_format(order_time,'%Y-%m')";//month(order_time)
    			
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	
        	DefaultTableModel tablemodel=new DefaultTableModel(); //���ģ��
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //�������
            for (int j=1; j<=count; j++) {                       //����������ӵ����ģ����Ϊ���⣬����š�1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
            }
          //��������и���������ӵ����ģ�ͣ�һ�α���
            Object[] columns=new Object[count];                //�����ж������飬���鳤��Ϊ����
            while (rs.next())                                //�����������������ǰ������ÿ��
            {
                for (int j=1; j<=columns.length; j++)          //���ÿ�и���ֵ
                    columns[j-1]=rs.getString(j);
                tablemodel.addRow(columns);                    //���ģ�����һ�У�����ָ������ֵ
            }
            rs.close();
            
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);      //�������ָ�����ģ��
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
    
    //24Сʱ�Ķ��������ֲ����ͳ��
    public static JTable selectDistributionOfOrderInfoBy24Hour( String t_from, String t_to){
    	conn = Connect.getConnection();
    	String sql = "select hour(order_time) AS 'ʱ',count(order_id) AS '������Ŀ'  from OrderInfo where order_time>='"+ t_from +"' and order_time<='"+ t_to +"'"+ 
    		" group by hour(order_time),date(order_time),hour(order_time) order by hour(order_time)";
    			
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	
        	DefaultTableModel tablemodel=new DefaultTableModel(); //���ģ��
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //�������
            for (int j=1; j<=count; j++) {                       //����������ӵ����ģ����Ϊ���⣬����š�1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
            }
          //��������и���������ӵ����ģ�ͣ�һ�α���
            Object[] columns=new Object[count];                //�����ж������飬���鳤��Ϊ����
            while (rs.next())                                //�����������������ǰ������ÿ��
            {
                for (int j=1; j<=columns.length; j++)          //���ÿ�и���ֵ
                    columns[j-1]=rs.getString(j);
                tablemodel.addRow(columns);                    //���ģ�����һ�У�����ָ������ֵ
            }
            rs.close();
            
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);      //�������ָ�����ģ��
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
    
    
    
    
    
  //���涼�Ǻ�̨��������õģ����ǹ���Ա�Ĺ���
  //���Ӷ��� ʵ��Ʒ
    public static void insertOrder(Order order){
    	conn = Connect.getConnection();
    	String sql = "insert into OrderInfo values(?,?,?,?,?,?,?,?,?)";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	pstmt.setString(1, order.getorder_id());
        	pstmt.setString(2, order.getshopkeeper_id());
        	pstmt.setString(3, order.getuser_id());
        	pstmt.setString(4, order.getstate());
        	pstmt.setString(5, order.getorder_time());
        	pstmt.setDouble(6, order.gettotal_price());
        	pstmt.setInt(7, order.getfare());
        	pstmt.setString(8, order.getplace_from());
        	pstmt.setString(9, order.getplace_to());
        	pstmt.executeUpdate();
        	System.out.println("���Ӷ����ɹ���");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
  		  e.printStackTrace();
    	}
    }
    
    
    public static void insertProductIntoOrder(Order order){
    	conn = Connect.getConnection();
    	String sql = "insert into OrderProduct  values(?,?,?,?,?,?)";
    	//�����ʺţ�����ȥ�����ţ�������ȥ��ע�ͣ�������         (order_id, shopkeeper_id, product_id, amount)
    	try {
    		int i = 0;
    		for(i = 0; i < order.product_num;i++) {
    			pstmt = conn.prepareStatement(sql);
            	pstmt.setString(1, order.getorder_id());
            	pstmt.setString(2, order.getshopkeeper_id());
            	pstmt.setString(3, order.getproduct_id(i));
            	pstmt.setString(4, order.getproduct_num(i));
            	pstmt.setInt(5, 2+User.suijiBiggerInt(3));//null
            	pstmt.setString(6, order.getcomment(i));
            	pstmt.executeUpdate();
            	System.out.println("���Ӷ����ɹ���");
            	
    		}
    		
        	
        	pstmt.close();
        	
        	conn.close();
    	}
    	catch(SQLException e) {
  		  e.printStackTrace();
    	}
    }
  //������Ʒ
    public static int selectProductPrice(String product_id, String shopkeeper_id){
    	conn = Connect.getConnection();
    	int thisprice = 0;
    	String sql = "select price as '�۸�' "
    			+ "  from Product where  isExist = 1 and product_id = '" + product_id + "' and shopkeeper_id = '" + shopkeeper_id + "'";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	while(rs.next()) {
        		thisprice =  rs.getInt(1);
        	}
        	
            rs.close();
            
        	pstmt.close();
        	conn.close();
        	return thisprice;
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return 0;
    }
    
    //�����̼�id��������Ʒid
  //������Ʒ
    public static List<String> selectProductOfShop(String shopkeeper_id){
    	conn = Connect.getConnection();
    	List<String> list = new ArrayList<String>();
    	String sql = "select product_id  "
    			+ "  from Product where  isExist = 1 and shopkeeper_id = '" + shopkeeper_id + "'";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
            while (rs.next())                                //�����������������ǰ������ÿ��
            {
            	list.add(rs.getString(1));
            }
            rs.close();
            
        	pstmt.close();
        	conn.close();
        	return list;
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
}