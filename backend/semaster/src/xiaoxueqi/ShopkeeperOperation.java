package xiaoxueqi;

import java.util.*;

import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class ShopkeeperOperation {
	private static Connection conn ;
    private static PreparedStatement pstmt ;
    
    
    //���ӵ�����Ʒ
    public static void insertProduct(Product product) {
    	conn = Connect.getConnection();
    	String sql = "insert into Product (product_id, shopkeeper_id, s_category, product_name, product_introduction, price, present_stock) values(?,?,?,?,?,?,?)";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	pstmt.setString(1, product.getProduct_id());
        	pstmt.setString(2, product.getShopkeeper_id());
        	pstmt.setString(3, product.getS_category());
        	pstmt.setString(4, product.getProduct_name());
        	pstmt.setString(5, product.getProduct_introduction());
        	pstmt.setString(6, product.getPrice());
        	pstmt.setString(7, product.getPresent_stock());
        	pstmt.executeUpdate();
        	System.out.println("������Ʒ�ɹ���");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
  		  e.printStackTrace();
    	}
    }
    
    //�¼ܣ�ɾ����������Ʒ
    public static void deleteProduct(String product_id, String shopkeeper_id) {//�����shopkeeper_id���Ե�½ʱ����Ϣ
    	conn = Connect.getConnection();
    	String sql = "update Product set isExist = 0 where shopkeeper_id = '" + shopkeeper_id + "' and product_id = '" + product_id + "'";
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
    
    //���µ�����Ʒ��Ϣ
    public static void updateProduct(String product_id, String product_name, String s_category, String product_introduction,
    String price, String present_stock,String shopkeeper_id)
    {//�����shopkeeper_id���Ե�½ʱ����Ϣ
    	conn = Connect.getConnection();
    	String sql1 = "update Product set product_name = ?,s_category = ?, product_introduction = ? , price = ? , present_stock = ? "
    			+ "where shopkeeper_id = '" + shopkeeper_id + "' and product_id ='" + product_id + "'";
    	try {
    		pstmt = conn.prepareStatement(sql1);
        	pstmt.setString(1, product_name);
        	pstmt.setString(2, s_category);
        	pstmt.setString(3, product_introduction);
        	pstmt.setString(4, price);
        	pstmt.setString(5, present_stock);
        	pstmt.executeUpdate();
        	System.out.println("������Ʒ��Ϣ�ɹ���");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
    }
    //���ҵ�����Ʒ
    public static JTable selectProductByAttribute(String attributeName, String attribute, String shopkeeper_id){//�����shopkeeper_id���Ե�½ʱ����Ϣ
    	conn = Connect.getConnection();
    	String sql = "select product_id as '��Ʒ���',  product_name as '��Ʒ��', s_category as '��Ʒ���', price as '�۸�', present_stock as'�����', product_introduction as '��Ʒ˵��' "
    			+ " from Product where isExist = 1 and " + attributeName + " = '" + attribute + "' and shopkeeper_id ='" + shopkeeper_id + "'";
    	
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
    
    
    //��������
    //ȥ����
    public static void updateOrderInfo(String order_id, String state, String shopkeeper_id){//�����shopkeeperid���Ե�½ʱ����Ϣ
    	    	conn = Connect.getConnection();
    	    	String sql = "update OrderInfo set state = ? where shopkeeper_id = '" + shopkeeper_id + "' and order_id ='" + order_id + "'";
    	    	try {
    	    		pstmt = conn.prepareStatement(sql);
    	        	pstmt.setString(1, "�ѷ���");
    	        	pstmt.executeUpdate();
    	        	System.out.println("�����ɹ���");
    	        	pstmt.close();
    	        	conn.close();
    	    	}
    	    	catch(SQLException e) {
    	    		  e.printStackTrace();
    	    	}
    }
    //��������1����ѯĳʱ��εĶ��������ܽ��
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByTime(String t_from, String t_to, String shopkeeper_id){
    	conn = Connect.getConnection();
    	String sql = "select count(distinct order_id) as '��ʱ��ζ�����', sum(total_price) as '��ʱ��ζ����ܽ��'  from OrderInfo where shopkeeper_id = '" + shopkeeper_id + "' and order_time > '" + t_from + "' and order_time < '" + t_to + "'" ;
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
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByS_Category(String s_category, String shopkeeper_id){//�����shopkeeperid���Ե�½ʱ����Ϣ
    	conn = Connect.getConnection();
    	String sql = "select count(distinct op.order_id) as '������Ʒ������', sum(op.amount*p.price) as '������Ʒ�����ܽ��'  from OrderProduct op, Product p  where op.shopkeeper_id = '" + shopkeeper_id +  "' and p.product_id = op.product_id and p.s_category = '" + s_category + "' and p.shopkeeper_id = '" + shopkeeper_id +  "'";
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
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByM_Category(String m_category, String shopkeeper_id){//�����shopkeeperid���Ե�½ʱ����Ϣ
    	conn = Connect.getConnection();
    	String sql = "select count(distinct op.order_id) as '������Ʒ������', sum(op.amount*p.price)  as '������Ʒ�����ܽ��'   from OrderProduct op, Product p, Category c  where op.shopkeeper_id = '" + shopkeeper_id +  "' and p.product_id = op.product_id and p.s_category = c.s_category and c.m_category = '" + m_category + "' and p.shopkeeper_id = '" + shopkeeper_id +  "'";
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
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByL_Category(String l_category, String shopkeeper_id){//�����shopkeeperid���Ե�½ʱ����Ϣ
    	conn = Connect.getConnection();
    	String sql = "select count(distinct op.order_id) as '������Ʒ������', sum(op.amount*p.price)  as '������Ʒ�����ܽ��'   from OrderProduct op, Product p, Category c  where op.shopkeeper_id = '" + shopkeeper_id +  "' and p.product_id = op.product_id and p.s_category = c.s_category and c.l_category = '" + l_category + "' and p.shopkeeper_id = '" + shopkeeper_id +  "'";
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
    public static JTable selectMostPopularProductByTime(String t_from, String t_to, String shopkeeper_id){//�����shopkeeper_id���Ե�½ʱ����Ϣ
    	conn = Connect.getConnection();
    	String sql ="select p.product_id as '��Ʒ���', p.product_name as '��Ʒ��', sum(op.amount)  as '��ʱ��ζ�������'  "
    			+ "from OrderInfo oi, OrderProduct op, Product p   "
    			+ "where p.product_id = op.product_id and oi.order_id = op.order_id and oi.shopkeeper_id = '"
    			+ shopkeeper_id + " and oi.order_time > '" + t_from + "' and oi.order_time < '" + t_to + "'"
    			+ "group by p.product_id, p.product_name order by sum(op.amount) desc limit 10";
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
  //��������4����ѯǰʮ��������Ʒ
    public static JTable selectMostPopularProduct(String shopkeeper_id){//�����shopkeeper_id���Ե�½ʱ����Ϣ
    	conn = Connect.getConnection();
    	String sql ="select p.product_id as '��Ʒ���', p.product_name as '��Ʒ��', sum(op.amount)  as '��������'  "
    			+ "from OrderProduct op, Product p   "
    			+ "where p.product_id = op.product_id and oi.order_id = op.order_id and oi.shopkeeper_id = '" + shopkeeper_id 
    			+ "' group by p.product_id, p.product_name order by sum(op.amount) desc limit 10";
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
  //��������5����ѯ����ǰʮ����Ʒ
    public static JTable selectBestScoreProduct(String shopkeeper_id){//�����shopkeeper_id���Ե�½ʱ����Ϣ
    	conn = Connect.getConnection();
    	String sql ="select p.product_id as '��Ʒ���',   p.product_name as '��Ʒ��',  avg(op.score) as '����' "
    			+ " from product p, OrderProduct op  where p.product_id = op.product_id and p.shopkeeper_id = '" + shopkeeper_id 
    			+ "' group by p.product_id, p.product_name order by avg(op.score) desc, p.product_id asc limit 10";
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
}

