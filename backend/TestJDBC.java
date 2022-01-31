package xiaoxueqi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestJDBC {
	private Connection conn ;
    private Statement stat ;
    
    public void showMetaData() throws Exception
	 {
    	conn = Connect.getConnection();//连接数据库
		DatabaseMetaData dbmd = conn.getMetaData();        //获得所连接数据库的属性信息
	    System.out.println("JDBC驱动程序："+dbmd.getDriverName()+"，"+dbmd.getDriverVersion()
	            +"\nJDBC URL："+dbmd.getURL()+"\n数据库："+dbmd.getDatabaseProductName()
	            +"，版本："+dbmd.getDatabaseProductVersion()+"，用户名："+dbmd.getUserName()+"\n");
	    conn.close();
	 }
    
    public void showData(String sql) throws Exception
    {
    	conn = Connect.getConnection();//连接数据库
		stat = Connect.getStatement(conn);
		ResultSet ret = null;
  
        try {  
            ret = stat.executeQuery(sql);//执行语句，得到结果集  
            while (ret.next()) {  
                String uid = ret.getString(1);  
                String ufname = ret.getString(2);  
                String ulname = ret.getString(3);  
                String udate = ret.getString(4);  
                System.out.println(uid + "\t" + ufname + "\t" + ulname + "\t" + udate );  
            }//显示数据  
            ret.close();  
            stat.close();//关闭连接  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }
    
    
    
	public static void main(String[] args) throws Exception{
		TestJDBC test = new TestJDBC();
		String sql = null; 
		//User.count = 9999;
		
		
		
		//String[] dianjia = new String[1000];
		//String[][] str = new String[1000][];
		//str =  File_CSV.getData("C:\\Users\\14472\\Desktop\\小学期数据库\\data\\店家1.csv");
		//for(int i = 0;i < 1000;i++) {
		//		dianjia[i] = str[i][0];
		//}
		//User.suijicreateUser();
		int i= 0;
		Order.count = 87000;
		for( i = 0; i<8000;i++) {
		Order.suijicreateOrder();
		}
		
		
		
		
		//List<String> list = new ArrayList<String>();
		//list.add("U00006");
        //list.add("U00007");
        
        //File_CSV.getData(list, "C:\\Users\\14472\\Desktop\\小学期数据库\\data\\店家1.csv");
		//\\小学期数据库\\data\\店家1
		
		
		//下面全是实验，之后删掉
		//test.showMetaData();	
		
		//管理员操作
		//用户管理实验
		User user1 = new User("U00021","12345678","user","小","天使","M","1999/12/2","12346215300");
		sql = "select * from user";//SQL语句 
		//AdministratorOperation.insertUser(user1);
		//test.showData(sql);
		//AdministratorOperation.deleteUser(user1.getUser_id());
		//test.showData(sql);
		//AdministratorOperation.updateUser("U00010", "zxcvbnm", "13001993301");
		//test.showData(sql);
		//AdministratorOperation.selectUserByAttribute("password", "zxcvbnm");
		//test.showData(sql);
		
		//商家管理实验
		Shop shop1 = new Shop("U00003","asdfghjkl","shopkeeper","于","苟迩","F","1999/12/26","15611235300","宠物食物店");
		
		//AdministratorOperation.insertShop(shop1);
		
		//AdministratorOperation.deleteShop(shop1.getUser_id());
		
		//AdministratorOperation.updateShop("U00011", "abc123456", "13001993301","狗粮专卖店");
	
		//AdministratorOperation.selectShopByAttribute("password", "abc123456");
		
		
		//商品管理实验
		//AdministratorOperation.deleteProduct("P0000002", "U00001");
		//AdministratorOperation.selectProductByAttribute("shopkeeper_id", "U00001");
		
		
		//类别管理实验
		//小类改名
		//AdministratorOperation.updateS_Category("华为手机！", "华为手机");
		//AdministratorOperation.updateM_Category("手机！","手机");
		//AdministratorOperation.updateL_Category("家电","数码产品");
		
		
		
		//订单管理实验
		//订单功能1：查询某时间段的订单数和总金额
		//AdministratorOperation.selectTotalNumAndTotalPriceOfOrderInfoByTime("2019-7-4", "2019-7-6");
		//试过了，"2019-7-4", "2019-07-04", "2019-7-4 00:00:00", "2019-07-04 00:00:00" 这些格式都可以！！！
		
		//订单功能2：查询某小类商品的订单数和总金额实验
		//AdministratorOperation.selectTotalNumAndTotalPriceOfOrderByS_Category("华为手机");
		//AdministratorOperation.selectTotalNumAndTotalPriceOfOrderByM_Category("狗狗");
		//AdministratorOperation.selectTotalNumAndTotalPriceOfOrderByL_Category("数码产品");
		
		
		
		
		
		
		
		//商家操作
		//商品管理实验
		Product product1 = new Product("P0000003","U00001","华为手机","华为P30","做你的智能小天使，拍照神器","4998","240");
		Product product2 = new Product("P0000004","U00003","狗粮","幼犬粮","让小狗狗开心","50","300");
		Product product3 = new Product("P0000005","U00003","磨牙棒","幼犬磨牙饼干","让小狗狗开心磨牙","60","100");
		//ShopkeeperOperation.insertProduct(product3);
		//ShopkeeperOperation.deleteProduct("P0000003", "U00001");
		//ShopkeeperOperation.updateProduct("P0000003", "华为P300", "华为手机","做你的智能小天使，拍照神器呀", "5998","240", "U00001");
		//ShopkeeperOperation.selectProductByAttribute("s_category", "华为手机", "U00001");
		
		
		
		
		
		//订单操作
		//订单功能1：查询某时间段的订单数和总金额
		//ShopkeeperOperation.selectTotalNumAndTotalPriceOfOrderInfoByTime("2019-7-4", "2019-7-6","U00001");
		//订单功能2：查询某小类商品的订单数和总金额实验
		//ShopkeeperOperation.selectTotalNumAndTotalPriceOfOrderByS_Category("华为手机", "U00001");
		//ShopkeeperOperation.selectTotalNumAndTotalPriceOfOrderByM_Category("狗狗", "U00003");
		//ShopkeeperOperation.selectTotalNumAndTotalPriceOfOrderByL_Category("数码产品", "U00001");
		
	}

}
