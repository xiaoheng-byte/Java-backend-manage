package xiaoxueqi;

import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdministratorOperation {
	private static Connection conn ;
    private static PreparedStatement pstmt ;
    
    //用户管理
    //增加用户
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
        	System.out.println("增加用户成功！");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
  		  e.printStackTrace();
    	}
    }
  //删除用户
    public static void deleteUser(String user_id){
    	conn = Connect.getConnection();
    	String sql = "update User set isExist = 0 where user_id = '" + user_id + "'";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	pstmt.executeUpdate();
        	System.out.println("删除用户成功！");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
  		  e.printStackTrace();
    	}
    }
    //更新用户信息
    public static void updateUser(String user_id, String password, String telephone){
    	conn = Connect.getConnection();
    	String sql = "update User set password = ?, telephone = ? where user_id = '" + user_id + "'";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	pstmt.setString(1, password);
        	pstmt.setString(2, telephone);
        	pstmt.executeUpdate();
        	System.out.println("更新用户信息成功！");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
    }
    //查找符合条件的用户
    public static JTable selectUserByAttribute(String attributeName, String attribute){
    	conn = Connect.getConnection();
    	String sql = "select user_id as '用户编号',  lName as '姓', fName as '名', sex as '性别', DoB as '生日' , telephone as '电话号'  "
    			+ " from User where  isExist = 1 and " + attributeName + " = '" + attribute + "'";
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
    
    
    //商家管理
    //增加商家
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
        	System.out.println("增加商家成功！");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
  		  e.printStackTrace();
    	}
    }
    //删除商家
    public static void deleteShop(String user_id){
    	conn = Connect.getConnection();
    	String sql1 = "update User set isExist = 0 where user_id = '" + user_id + "'";	//删除商家user信息
    	//String sql2 = "delete from Shop where shopkeeper_id = '" + user_id + "'";	//删除该商家
    	String sql3 = "update Product set isExist = 0 where shopkeeper_id = '" + user_id + "'";	//删除该店商品
    	try {
    		pstmt = conn.prepareStatement(sql3);
        	pstmt.executeUpdate();
        	//pstmt = conn.prepareStatement(sql2);
        	//pstmt.executeUpdate();
        	pstmt = conn.prepareStatement(sql1);
        	pstmt.executeUpdate();
        	System.out.println("删除商家成功！");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
  		  e.printStackTrace();
    	}
    }
    //更新商家信息
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
        	System.out.println("更新商家成功！");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
    }
    //查找符合条件的商家
    public static JTable selectShopByAttribute(String attributeName, String attribute){
    	conn = Connect.getConnection();
    	String sql = "select u.user_id as '店铺编号', s.shop_name as '店铺名',  u.telephone as '电话号' , u.lName as '店主姓', u.fName as '店主名', u.sex as '性别', u.DoB as '生日'  from User u, Shop s "
    			+ "where u.isExist = 1 and u.user_id = s.shopkeeper_id and " + attributeName + " = '" + attribute + "'";
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
    
    
    //商家管理
    //下架（删除）商品
    public static void deleteProduct(String product_id, String shopkeeper_id) {
    	conn = Connect.getConnection();
    	String sql = "update Product  set isExist = 0  where shopkeeper_id = '" + shopkeeper_id + "' and product_id = '" + product_id + "'";
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
    //查找商品
    public static JTable selectProductByAttribute(String attributeName, String attribute){
    	conn = Connect.getConnection();
    	String sql = "select product_id as '商品编号', shopkeeper_id as '商家编号',   product_name as '商品名', s_category as '商品类别',price as '价格', present_stock as'库存量', product_introduction as '商品说明' "
    			+ "  from Product where  isExist = 1 and " + attributeName + " = '" + attribute + "'";
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
    
    
    //String l_category, String m_category, 
    //类别管理
    //改小类
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
        	System.out.println("更新小类成功！");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
    }
    
    //改中类
    public static void updateM_Category(String m_category,String newM){
    	conn = Connect.getConnection();
    	String sql1 = "update Category set m_category = ? where m_category = '" + m_category + "'";
    	try {
    		pstmt = conn.prepareStatement(sql1);
        	pstmt.setString(1, newM);
        	pstmt.executeUpdate();
        	System.out.println("更新中类成功！");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
    }
    
  //改大类
    public static void updateL_Category(String l_category,String newL){
    	conn = Connect.getConnection();
    	String sql1 = "update Category set l_category = ? where l_category = '" + l_category + "'";
    	try {
    		pstmt = conn.prepareStatement(sql1);
        	pstmt.setString(1, newL);
        	pstmt.executeUpdate();
        	System.out.println("更新大类成功！");
        	pstmt.close();
        	conn.close();
    	}
    	catch(SQLException e) {
    		  e.printStackTrace();
    	}
    }
    
    
    
    
    
    
    //订单管理
      
    //订单功能1：查询某时间段的订单数和总金额
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByTime(String t_from, String t_to){
    	conn = Connect.getConnection();
    	String sql = "select count(distinct order_id) as '该时间段订单数', sum(total_price) as '该时间段订单总金额'  from OrderInfo where state != '已取消' and order_time > '" + t_from + "' and order_time < '" + t_to + "'" ;
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
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByS_Category(String s_category){
    	conn = Connect.getConnection();
    	String sql = "select count(distinct op.order_id) as '该类商品订单数', sum(op.amount*p.price) as '该类商品订单总金额'  from OrderProduct op, Product p ,OrderInfo oi where oi.order_id = op.order_id and  oi.state != '已取消'  and p.product_id = op.product_id and p.s_category = '" + s_category + "'";
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
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByM_Category(String m_category){
    	conn = Connect.getConnection();
    	String sql = "select count(distinct op.order_id) as '该类商品订单数', sum(op.amount*p.price) as '该类商品订单总金额'    from OrderProduct op, Product p, Category c, OrderInfo oi  where  oi.order_id = op.order_id and  oi.state != '已取消'  and p.product_id = op.product_id and p.s_category = c.s_category and c.m_category = '" + m_category + "'";
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
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByL_Category(String l_category){
    	conn = Connect.getConnection();
    	
    	String sql = "select count(distinct op.order_id) as '该类商品订单数', sum(op.amount*p.price) as '该类商品订单总金额'    from OrderProduct op, Product p, Category c, OrderInfo oi  where  oi.order_id = op.order_id and  oi.state != '已取消'  and p.product_id = op.product_id and p.s_category = c.s_category and c.l_category = '" + l_category + "'";
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
    public static JTable selectMostPopularProductByTime(String t_from, String t_to){
    	conn = Connect.getConnection();
    	String sql ="select p.shopkeeper_id as '店铺编号', p.product_id as '商品编号'  , p.product_name as '商品名'  , sum(op.amount) as '该时间段内订单数量'  "
    			+ "from OrderInfo oi, OrderProduct op, Product p   "
    			+ "where oi.state != '已取消'  and p.product_id = op.product_id and oi.order_id = op.order_id and oi.order_time > '" + t_from + "' and oi.order_time < '" + t_to + "'"
    			+ "group by p.shopkeeper_id, p.product_id, p.product_name order by sum(op.amount) desc,p.shopkeeper_id asc  limit 10";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	
        	DefaultTableModel tablemodel=new DefaultTableModel(); //表格模型
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //获得resultSet的列数
        	tablemodel.addColumn("排名");
            for (int j=1; j<=count; j++) {                       //将各列名添加到表格模型作为标题，列序号≥1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
                System.out.println(j);
            }
            
          //将结果集中各行数据添加到表格模型，一次遍历
            Object[] columns=new Object[count + 1];                //创建列对象数组，数组长度为列数
            while (rs.next())                                //迭代遍历结果集，从前向后访问每行
            {
                for (int j=1, k = 0; j<columns.length; j++,k++) {         //获得每行各列值
                     columns[0] =tablemodel.getRowCount() + 1;
                	columns[j]=rs.getString(j);
                	 System.out.println(j);
                }
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
    public static JTable selectMostPopularProduct(){
    	
    	conn = Connect.getConnection();
    	String sql ="select p.product_id as '商品编号' , p.product_name as '商品名' , sum(op.amount)  as '订单数量' "
    			+ "from OrderProduct op, Product p, OrderInfo oi   "
    			+ "where oi.state != '已取消'  and oi.order_id = op.order_id and p.product_id = op.product_id  "
    			+ "group by p.product_id, p.product_name order by sum(op.amount) desc,p.shopkeeper_id asc limit 10";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	
        	DefaultTableModel tablemodel=new DefaultTableModel(); //表格模型
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //获得resultSet的列数
        	tablemodel.addColumn("排名");
            for (int j=1; j<=count; j++) {                       //将各列名添加到表格模型作为标题，列序号≥1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
                System.out.println(j);
            }
            
          //将结果集中各行数据添加到表格模型，一次遍历
            Object[] columns=new Object[count + 1];                //创建列对象数组，数组长度为列数
            while (rs.next())                                //迭代遍历结果集，从前向后访问每行
            {
                for (int j=1, k = 0; j<columns.length; j++,k++) {         //获得每行各列值
                     columns[0] =tablemodel.getRowCount() + 1;
                	columns[j]=rs.getString(j);
                	 System.out.println(j);
                }
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
    public static JTable selectBestScoreProduct(){
    	
    	conn = Connect.getConnection();
    	String sql ="select p.product_id as '商品编号', p.shopkeeper_id as '店铺编号',  p.product_name as '商品名',  avg(op.score) as '评分' "
    			+ " from product p, OrderProduct op,OrderInfo oi  where oi.state != '已取消'  and oi.order_id = op.order_id and p.product_id = op.product_id  "
    			+ "group by p.product_id, p.product_name order by avg(op.score) desc, p.product_id asc limit 10";
    			
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	
        	DefaultTableModel tablemodel=new DefaultTableModel(); //表格模型
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //获得resultSet的列数
        	tablemodel.addColumn("排名");
            for (int j=1; j<=count; j++) {                       //将各列名添加到表格模型作为标题，列序号≥1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
                System.out.println(j);
            }
            
          //将结果集中各行数据添加到表格模型，一次遍历
            Object[] columns=new Object[count + 1];                //创建列对象数组，数组长度为列数
            while (rs.next())                                //迭代遍历结果集，从前向后访问每行
            {
                for (int j=1, k = 0; j<columns.length; j++,k++) {         //获得每行各列值
                     columns[0] =tablemodel.getRowCount() + 1;
                	columns[j]=rs.getString(j);
                	 System.out.println(j);
                }
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
    
    //按照商家统计某段时间的订单数和总金额
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByShopAndTime( String t_from, String t_to){
    	
    	conn = Connect.getConnection();
    	String sql = "select s.shopkeeper_id as '商家编号', s.shop_name as '商家名', count(distinct oi.order_id) as '该店铺该时间段订单数' , sum(oi.total_price) as '该店铺该时间段订单总金额'  from  OrderInfo oi, Shop s " +
    			" where oi.shopkeeper_id = s.shopkeeper_id and oi.state !='已取消' and oi.order_time > '"+ t_from +"' and oi.order_time < '"+ t_to +"'"
    			+ " group by s.shopkeeper_id, s.shop_name";
    			
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
    
    //某个时间段内，销量排名前十名的商家
    public static JTable selectMostSellShopByTime( String t_from, String t_to){
    	
    	conn = Connect.getConnection();
    	String sql = "select s.shopkeeper_id as '商家编号', s.shop_name as '商家名', count(distinct oi.order_id) as '该店铺该时间段总订单数'   from  OrderInfo oi, Shop s " +
    			" where oi.shopkeeper_id = s.shopkeeper_id and oi.state !='已取消' and oi.order_time > '"+ t_from +"' and oi.order_time < '"+ t_to +"'"
    			+ " group by s.shopkeeper_id, s.shop_name order by count(distinct oi.order_id) desc, s.shopkeeper_id asc limit 10";
    			
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	
        	DefaultTableModel tablemodel=new DefaultTableModel(); //表格模型
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //获得resultSet的列数
        	tablemodel.addColumn("排名");
            for (int j=1; j<=count; j++) {                       //将各列名添加到表格模型作为标题，列序号≥1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
                System.out.println(j);
            }
            
          //将结果集中各行数据添加到表格模型，一次遍历
            Object[] columns=new Object[count + 1];                //创建列对象数组，数组长度为列数
            while (rs.next())                                //迭代遍历结果集，从前向后访问每行
            {
                for (int j=1, k = 0; j<columns.length; j++,k++) {         //获得每行各列值
                     columns[0] =tablemodel.getRowCount() + 1;
                	columns[j]=rs.getString(j);
                	 System.out.println(j);
                }
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
    
	//某个时间段内，成功下单金额前十名的用户
    public static JTable selectMostBuyUserByTime( String t_from, String t_to){
    	
    	conn = Connect.getConnection();
    	String sql = "select u.user_id as '用户编号',  sum(oi.total_price) as '该用户该时间段总下单金额'   from  OrderInfo oi, User u " +
    			" where oi.user_id = u.user_id and oi.state !='已取消' and oi.order_time > '"+ t_from +"' and oi.order_time < '"+ t_to +"'"
    			+ " group by u.user_id order by sum(oi.total_price) desc, u.user_id asc limit 10";
    			
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
        	
        	DefaultTableModel tablemodel=new DefaultTableModel(); //表格模型
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int count = rsmd.getColumnCount();                 //获得resultSet的列数
        	tablemodel.addColumn("排名");
            for (int j=1; j<=count; j++) {                       //将各列名添加到表格模型作为标题，列序号≥1
                tablemodel.addColumn(rsmd.getColumnLabel(j)); 
                System.out.println(j);
            }
            
          //将结果集中各行数据添加到表格模型，一次遍历
            Object[] columns=new Object[count + 1];                //创建列对象数组，数组长度为列数
            while (rs.next())                                //迭代遍历结果集，从前向后访问每行
            {
                for (int j=1, k = 0; j<columns.length; j++,k++) {         //获得每行各列值
                     columns[0] =tablemodel.getRowCount() + 1;
                	columns[j]=rs.getString(j);
                	 System.out.println(j);
                }
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
    	
    //每个月的订单数量和金额情况统计（要求订单时间跨度不低于一年）
    public static JTable selectTotalNumAndTotalPriceOfOrderInfoByMonth( String t_from, String t_to){
    	
    	conn = Connect.getConnection();
    	String sql = "select date_format(order_time,'%Y-%m') as '月份', count(order_id) as '订单数', sum(total_price) as '总金额' from OrderInfo oi "
    			+ "where state != '已取消' and order_time > '"+ t_from +"' and order_time < '"+ t_to +"' "
    			+ "group by date_format(order_time,'%Y-%m') order by date_format(order_time,'%Y-%m')";//month(order_time)
    			
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
    
    //24小时的订单数量分布情况统计
    public static JTable selectDistributionOfOrderInfoBy24Hour( String t_from, String t_to){
    	conn = Connect.getConnection();
    	String sql = "select hour(order_time) AS '时',count(order_id) AS '订单数目'  from OrderInfo where order_time>='"+ t_from +"' and order_time<='"+ t_to +"'"+ 
    		" group by hour(order_time),date(order_time),hour(order_time) order by hour(order_time)";
    			
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
    
    
    
    
    
  //下面都是后台添加数据用的，不是管理员的功能
  //增加订单 实验品
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
        	System.out.println("增加订单成功！");
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
    	//加上问号！！！去掉括号！！！！去掉注释！！！！         (order_id, shopkeeper_id, product_id, amount)
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
            	System.out.println("增加订单成功！");
            	
    		}
    		
        	
        	pstmt.close();
        	
        	conn.close();
    	}
    	catch(SQLException e) {
  		  e.printStackTrace();
    	}
    }
  //查找商品
    public static int selectProductPrice(String product_id, String shopkeeper_id){
    	conn = Connect.getConnection();
    	int thisprice = 0;
    	String sql = "select price as '价格' "
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
    
    //根据商家id查所有商品id
  //查找商品
    public static List<String> selectProductOfShop(String shopkeeper_id){
    	conn = Connect.getConnection();
    	List<String> list = new ArrayList<String>();
    	String sql = "select product_id  "
    			+ "  from Product where  isExist = 1 and shopkeeper_id = '" + shopkeeper_id + "'";
    	try {
    		pstmt = conn.prepareStatement(sql);
        	ResultSet rs = pstmt.executeQuery();
            while (rs.next())                                //迭代遍历结果集，从前向后访问每行
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