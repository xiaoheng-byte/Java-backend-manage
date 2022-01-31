package xiaoxueqi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestJDBC {
	private Connection conn ;
    private Statement stat ;
    
    public void showMetaData() throws Exception
	 {
    	conn = Connect.getConnection();//�������ݿ�
		DatabaseMetaData dbmd = conn.getMetaData();        //������������ݿ��������Ϣ
	    System.out.println("JDBC��������"+dbmd.getDriverName()+"��"+dbmd.getDriverVersion()
	            +"\nJDBC URL��"+dbmd.getURL()+"\n���ݿ⣺"+dbmd.getDatabaseProductName()
	            +"���汾��"+dbmd.getDatabaseProductVersion()+"���û�����"+dbmd.getUserName()+"\n");
	    conn.close();
	 }
    
    public void showData(String sql) throws Exception
    {
    	conn = Connect.getConnection();//�������ݿ�
		stat = Connect.getStatement(conn);
		ResultSet ret = null;
  
        try {  
            ret = stat.executeQuery(sql);//ִ����䣬�õ������  
            while (ret.next()) {  
                String uid = ret.getString(1);  
                String ufname = ret.getString(2);  
                String ulname = ret.getString(3);  
                String udate = ret.getString(4);  
                System.out.println(uid + "\t" + ufname + "\t" + ulname + "\t" + udate );  
            }//��ʾ����  
            ret.close();  
            stat.close();//�ر�����  
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
		//str =  File_CSV.getData("C:\\Users\\14472\\Desktop\\Сѧ�����ݿ�\\data\\���1.csv");
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
        
        //File_CSV.getData(list, "C:\\Users\\14472\\Desktop\\Сѧ�����ݿ�\\data\\���1.csv");
		//\\Сѧ�����ݿ�\\data\\���1
		
		
		//����ȫ��ʵ�飬֮��ɾ��
		//test.showMetaData();	
		
		//����Ա����
		//�û�����ʵ��
		User user1 = new User("U00021","12345678","user","С","��ʹ","M","1999/12/2","12346215300");
		sql = "select * from user";//SQL��� 
		//AdministratorOperation.insertUser(user1);
		//test.showData(sql);
		//AdministratorOperation.deleteUser(user1.getUser_id());
		//test.showData(sql);
		//AdministratorOperation.updateUser("U00010", "zxcvbnm", "13001993301");
		//test.showData(sql);
		//AdministratorOperation.selectUserByAttribute("password", "zxcvbnm");
		//test.showData(sql);
		
		//�̼ҹ���ʵ��
		Shop shop1 = new Shop("U00003","asdfghjkl","shopkeeper","��","����","F","1999/12/26","15611235300","����ʳ���");
		
		//AdministratorOperation.insertShop(shop1);
		
		//AdministratorOperation.deleteShop(shop1.getUser_id());
		
		//AdministratorOperation.updateShop("U00011", "abc123456", "13001993301","����ר����");
	
		//AdministratorOperation.selectShopByAttribute("password", "abc123456");
		
		
		//��Ʒ����ʵ��
		//AdministratorOperation.deleteProduct("P0000002", "U00001");
		//AdministratorOperation.selectProductByAttribute("shopkeeper_id", "U00001");
		
		
		//������ʵ��
		//С�����
		//AdministratorOperation.updateS_Category("��Ϊ�ֻ���", "��Ϊ�ֻ�");
		//AdministratorOperation.updateM_Category("�ֻ���","�ֻ�");
		//AdministratorOperation.updateL_Category("�ҵ�","�����Ʒ");
		
		
		
		//��������ʵ��
		//��������1����ѯĳʱ��εĶ��������ܽ��
		//AdministratorOperation.selectTotalNumAndTotalPriceOfOrderInfoByTime("2019-7-4", "2019-7-6");
		//�Թ��ˣ�"2019-7-4", "2019-07-04", "2019-7-4 00:00:00", "2019-07-04 00:00:00" ��Щ��ʽ�����ԣ�����
		
		//��������2����ѯĳС����Ʒ�Ķ��������ܽ��ʵ��
		//AdministratorOperation.selectTotalNumAndTotalPriceOfOrderByS_Category("��Ϊ�ֻ�");
		//AdministratorOperation.selectTotalNumAndTotalPriceOfOrderByM_Category("����");
		//AdministratorOperation.selectTotalNumAndTotalPriceOfOrderByL_Category("�����Ʒ");
		
		
		
		
		
		
		
		//�̼Ҳ���
		//��Ʒ����ʵ��
		Product product1 = new Product("P0000003","U00001","��Ϊ�ֻ�","��ΪP30","���������С��ʹ����������","4998","240");
		Product product2 = new Product("P0000004","U00003","����","��Ȯ��","��С��������","50","300");
		Product product3 = new Product("P0000005","U00003","ĥ����","��Ȯĥ������","��С��������ĥ��","60","100");
		//ShopkeeperOperation.insertProduct(product3);
		//ShopkeeperOperation.deleteProduct("P0000003", "U00001");
		//ShopkeeperOperation.updateProduct("P0000003", "��ΪP300", "��Ϊ�ֻ�","���������С��ʹ����������ѽ", "5998","240", "U00001");
		//ShopkeeperOperation.selectProductByAttribute("s_category", "��Ϊ�ֻ�", "U00001");
		
		
		
		
		
		//��������
		//��������1����ѯĳʱ��εĶ��������ܽ��
		//ShopkeeperOperation.selectTotalNumAndTotalPriceOfOrderInfoByTime("2019-7-4", "2019-7-6","U00001");
		//��������2����ѯĳС����Ʒ�Ķ��������ܽ��ʵ��
		//ShopkeeperOperation.selectTotalNumAndTotalPriceOfOrderByS_Category("��Ϊ�ֻ�", "U00001");
		//ShopkeeperOperation.selectTotalNumAndTotalPriceOfOrderByM_Category("����", "U00003");
		//ShopkeeperOperation.selectTotalNumAndTotalPriceOfOrderByL_Category("�����Ʒ", "U00001");
		
	}

}
