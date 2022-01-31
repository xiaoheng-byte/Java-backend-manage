package xiaoxueqi;

import java.util.*;

import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class ShopkeeperOperation {
	private static Connection conn ;
    private static PreparedStatement pstmt ;
    
    
    //增加店内商品
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
        	System.out.println("增加商品成功！");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
  		  e.printStackTrace();
    	}
    }
    
    //下架（删除）店内商品
    public static void deleteProduct(String product_id, String shopkeeper_id) {//这里的shopkeeper_id来自登陆时的信息
    	conn = Connect.getConnection();
    	String sql = "update Product set isExist = 0 where shopkeeper_id = '" + shopkeeper_id + "' and product_id = '" + product_id + "'";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	pstmt.executeUpdate();
        	System.out.println("删除商品成功！");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
  		  e.printStackTrace();
    	}
    }
    
    //更新店内商品信息
    public static void updateProduct(String product_id, String product_name, String s_category, String product_introduction,
    String price, String present_stock,String shopkeeper_id)
    {//这里的shopkeeper_id来自登陆时的信息
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
        	System.out.println("更新商品信息成功！");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
    }
    //查找店内商品
    public static JTable selectProductByAttribute(String attributeName, String attribute, String shopkeeper_id){//这里的shopkeeper_id来自登陆时的信息
    	conn = Connect.getConnection();
    	String sql = "select product_id as '商品编号',  product_name as '商品名', s_category as '商品类别', price as '价格', present_stock as'库存量', product_introduction as '商品说明' "
    			+ " from Product where isExist = 1 and " + attributeName + " = '" + attribute + "' and shopkeeper_id ='" + shopkeeper_id + "'";
    	
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	DefaultTableModel tablemodel=new DefaultTableModel(); //表格模型
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //获得列数
            for (int j=1; j<=count; j++) {                       //将各列名添加到表格模型作为标题，列序号≥1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
            }
          //将结果集中各行数据添加到表格模型，一次遍历
            Object[] columns=new Object[count];                //创建列对象数组，数组长度为列数
            while (rs.next())                                //迭代遍历结果集，从前向后访问每行
            {
                for (int j=1; j<=columns.length; j++)          //获得每行各列值
                    columns[j-1]=rs.getString(j);
                tablemodel.addRow(columns);                    //表格模型添加一行，参数指数各列值
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
    
    
    //订单管理
    //去发货
    public static void updateOrderInfo(String order_id, String state, String shopkeeper_id){//这里的shopkeeperid来自登陆时的信息
    	    	conn = Connect.getConnection();
    	    	String sql = "update OrderInfo set state = ? where shopkeeper_id = '" + shopkeeper_id + "' and order_id ='" + order_id + "'";
    	    	try {
    	    		pstmt = conn.prepareStatement(sql);
    	        	pstmt.setString(1, "已发货");
    	        	pstmt.executeUpdate();
    	        	System.out.println("发货成功！");
    	        	pstmt.close();
    	        	conn.close();
    	    	}
    	    	catch(SQLException e) {
    	    		  e.printStackTrace();
    	    	}
    }
    //订单功能1：查询某时间段的订单数和总金额
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByTime(String t_from, String t_to, String shopkeeper_id){
    	conn = Connect.getConnection();
    	String sql = "select count(distinct order_id) as '该时间段订单数', sum(total_price) as '该时间段订单总金额'  from OrderInfo where shopkeeper_id = '" + shopkeeper_id + "' and order_time > '" + t_from + "' and order_time < '" + t_to + "'" ;
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	DefaultTableModel tablemodel=new DefaultTableModel(); //表格模型
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //获得列数
            for (int j=1; j<=count; j++) {                       //将各列名添加到表格模型作为标题，列序号≥1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
            }
          //将结果集中各行数据添加到表格模型，一次遍历
            Object[] columns=new Object[count];                //创建列对象数组，数组长度为列数
            while (rs.next())                                //迭代遍历结果集，从前向后访问每行
            {
                for (int j=1; j<=columns.length; j++)          //获得每行各列值
                    columns[j-1]=rs.getString(j);
                tablemodel.addRow(columns);                    //表格模型添加一行，参数指数各列值
            }
            rs.close();
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);      //创建表格，指定表格模型
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
    
    //订单功能2.1：查询某小类商品的订单数和总金额
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByS_Category(String s_category, String shopkeeper_id){//这里的shopkeeperid来自登陆时的信息
    	conn = Connect.getConnection();
    	String sql = "select count(distinct op.order_id) as '该类商品订单数', sum(op.amount*p.price) as '该类商品订单总金额'  from OrderProduct op, Product p  where op.shopkeeper_id = '" + shopkeeper_id +  "' and p.product_id = op.product_id and p.s_category = '" + s_category + "' and p.shopkeeper_id = '" + shopkeeper_id +  "'";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	DefaultTableModel tablemodel=new DefaultTableModel(); //表格模型
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //获得列数
            for (int j=1; j<=count; j++) {                       //将各列名添加到表格模型作为标题，列序号≥1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
            }
          //将结果集中各行数据添加到表格模型，一次遍历
            Object[] columns=new Object[count];                //创建列对象数组，数组长度为列数
            while (rs.next())                                //迭代遍历结果集，从前向后访问每行
            {
                for (int j=1; j<=columns.length; j++)          //获得每行各列值
                    columns[j-1]=rs.getString(j);
                tablemodel.addRow(columns);                    //表格模型添加一行，参数指数各列值
            }
            rs.close();
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);      //创建表格，指定表格模型
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
  //订单功能2.2：查询某中类商品的订单数和总金额
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByM_Category(String m_category, String shopkeeper_id){//这里的shopkeeperid来自登陆时的信息
    	conn = Connect.getConnection();
    	String sql = "select count(distinct op.order_id) as '该类商品订单数', sum(op.amount*p.price)  as '该类商品订单总金额'   from OrderProduct op, Product p, Category c  where op.shopkeeper_id = '" + shopkeeper_id +  "' and p.product_id = op.product_id and p.s_category = c.s_category and c.m_category = '" + m_category + "' and p.shopkeeper_id = '" + shopkeeper_id +  "'";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	DefaultTableModel tablemodel=new DefaultTableModel(); //表格模型
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //获得列数
            for (int j=1; j<=count; j++) {                       //将各列名添加到表格模型作为标题，列序号≥1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
            }
          //将结果集中各行数据添加到表格模型，一次遍历
            Object[] columns=new Object[count];                //创建列对象数组，数组长度为列数
            while (rs.next())                                //迭代遍历结果集，从前向后访问每行
            {
                for (int j=1; j<=columns.length; j++)          //获得每行各列值
                    columns[j-1]=rs.getString(j);
                tablemodel.addRow(columns);                    //表格模型添加一行，参数指数各列值
            }
            rs.close();
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);      //创建表格，指定表格模型
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
  //订单功能2.3：查询某大类商品的订单数和总金额
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByL_Category(String l_category, String shopkeeper_id){//这里的shopkeeperid来自登陆时的信息
    	conn = Connect.getConnection();
    	String sql = "select count(distinct op.order_id) as '该类商品订单数', sum(op.amount*p.price)  as '该类商品订单总金额'   from OrderProduct op, Product p, Category c  where op.shopkeeper_id = '" + shopkeeper_id +  "' and p.product_id = op.product_id and p.s_category = c.s_category and c.l_category = '" + l_category + "' and p.shopkeeper_id = '" + shopkeeper_id +  "'";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	DefaultTableModel tablemodel=new DefaultTableModel(); //表格模型
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //获得列数
            for (int j=1; j<=count; j++) {                       //将各列名添加到表格模型作为标题，列序号≥1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
            }
          //将结果集中各行数据添加到表格模型，一次遍历
            Object[] columns=new Object[count];                //创建列对象数组，数组长度为列数
            while (rs.next())                                //迭代遍历结果集，从前向后访问每行
            {
                for (int j=1; j<=columns.length; j++)          //获得每行各列值
                    columns[j-1]=rs.getString(j);
                tablemodel.addRow(columns);                    //表格模型添加一行，参数指数各列值
            }
            rs.close();
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);      //创建表格，指定表格模型
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
    
    
  //订单功能3：查询某时间段内前十名热销商品
    public static JTable selectMostPopularProductByTime(String t_from, String t_to, String shopkeeper_id){//这里的shopkeeper_id来自登陆时的信息
    	conn = Connect.getConnection();
    	String sql ="select p.product_id as '商品编号', p.product_name as '商品名', sum(op.amount)  as '该时间段订单数量'  "
    			+ "from OrderInfo oi, OrderProduct op, Product p   "
    			+ "where p.product_id = op.product_id and oi.order_id = op.order_id and oi.shopkeeper_id = '"
    			+ shopkeeper_id + " and oi.order_time > '" + t_from + "' and oi.order_time < '" + t_to + "'"
    			+ "group by p.product_id, p.product_name order by sum(op.amount) desc limit 10";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	DefaultTableModel tablemodel=new DefaultTableModel(); //表格模型
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //获得列数
            for (int j=1; j<=count; j++) {                       //将各列名添加到表格模型作为标题，列序号≥1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
            }
          //将结果集中各行数据添加到表格模型，一次遍历
            Object[] columns=new Object[count];                //创建列对象数组，数组长度为列数
            while (rs.next())                                //迭代遍历结果集，从前向后访问每行
            {
                for (int j=1; j<=columns.length; j++)          //获得每行各列值
                    columns[j-1]=rs.getString(j);
                tablemodel.addRow(columns);                    //表格模型添加一行，参数指数各列值
            }
            rs.close();
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);      //创建表格，指定表格模型
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
  //订单功能4：查询前十名热销商品
    public static JTable selectMostPopularProduct(String shopkeeper_id){//这里的shopkeeper_id来自登陆时的信息
    	conn = Connect.getConnection();
    	String sql ="select p.product_id as '商品编号', p.product_name as '商品名', sum(op.amount)  as '订单数量'  "
    			+ "from OrderProduct op, Product p   "
    			+ "where p.product_id = op.product_id and oi.order_id = op.order_id and oi.shopkeeper_id = '" + shopkeeper_id 
    			+ "' group by p.product_id, p.product_name order by sum(op.amount) desc limit 10";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	
        	DefaultTableModel tablemodel=new DefaultTableModel(); //表格模型
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //获得列数
            for (int j=1; j<=count; j++) {                       //将各列名添加到表格模型作为标题，列序号≥1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
            }
          //将结果集中各行数据添加到表格模型，一次遍历
            Object[] columns=new Object[count];                //创建列对象数组，数组长度为列数
            while (rs.next())                                //迭代遍历结果集，从前向后访问每行
            {
                for (int j=1; j<=columns.length; j++)          //获得每行各列值
                    columns[j-1]=rs.getString(j);
                tablemodel.addRow(columns);                    //表格模型添加一行，参数指数各列值
            }
            rs.close();
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);      //创建表格，指定表格模型
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
  //订单功能5：查询评分前十名商品
    public static JTable selectBestScoreProduct(String shopkeeper_id){//这里的shopkeeper_id来自登陆时的信息
    	conn = Connect.getConnection();
    	String sql ="select p.product_id as '商品编号',   p.product_name as '商品名',  avg(op.score) as '评分' "
    			+ " from product p, OrderProduct op  where p.product_id = op.product_id and p.shopkeeper_id = '" + shopkeeper_id 
    			+ "' group by p.product_id, p.product_name order by avg(op.score) desc, p.product_id asc limit 10";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	
        	DefaultTableModel tablemodel=new DefaultTableModel(); //表格模型
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //获得列数
            for (int j=1; j<=count; j++) {                       //将各列名添加到表格模型作为标题，列序号≥1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
            }
          //将结果集中各行数据添加到表格模型，一次遍历
            Object[] columns=new Object[count];                //创建列对象数组，数组长度为列数
            while (rs.next())                                //迭代遍历结果集，从前向后访问每行
            {
                for (int j=1; j<=columns.length; j++)          //获得每行各列值
                    columns[j-1]=rs.getString(j);
                tablemodel.addRow(columns);                    //表格模型添加一行，参数指数各列值
            }
            rs.close();
        	pstmt.close();
        	conn.close();
        	return new JTable(tablemodel);      //创建表格，指定表格模型
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
		return null;
    }
}

