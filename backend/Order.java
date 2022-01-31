package xiaoxueqi;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Order {
		public static int count;
		public static int product_num;
		private String order_id;
		private String shopkeeper_id;
		private String user_id;
		private String state;
		private String order_time;
		private double total_price;
		private int fare;
		private String place_from;
		private String place_to;
		public String product[][];//һ������һ����Ʒ��ţ��ڶ��������������м۸�
		public Order() {Order.count++;}
		public Order(int productNum) {//��productNum����Ʒ�Ķ���
			Order.count++; 
			this.product = new String[productNum][4];
		}
		public Order(String id, String p, String i, String l, String f, double s, int d, String t) {
			this.order_id = id;
			this.shopkeeper_id = p;
			this.user_id = i;
			this.state = l;
			this.order_time = f;
			this.total_price = s;
			this.fare = d;
			this.place_from = t;
			Order.count++;
		}
		public String getproduct_id(int i) {
			return this.product[i][0];
		}
		public String getproduct_num(int i) {
			return this.product[i][1];
		}
		public String getproduct_price(int i) {
			return this.product[i][2];
		}
		public String getcomment(int i) {
			return this.product[i][3];
		}
		public void setproduct_id(int num,String id) {
			this.product[num][0] = id;
		}
		public void setproduct_num(int num,int product_num) {
			this.product[num][1] = ""+product_num;
		}
		public void setproduct_price(int num,double price) {
			this.product[num][2] = ""+price;
		}
		public void setcomment(int num,String comment) {
			this.product[num][3] = comment;
		}
		public String getorder_id() {
			return this.order_id;
		}
		public void setorder_id(String id) {
			this.order_id = id;
		}
		public String getshopkeeper_id() {
			return this.shopkeeper_id;
		}
		public void setshopkeeper_id(String p) {
			this.shopkeeper_id = p;
		}
		public String getuser_id() {
			return this.user_id;
		}
		public void setuser_id(String i) {
			this.user_id = i;
		}
		public String getstate() {
			return this.state;
		}
		public void setstate(String l) {
			this.state = l;
		}
		public String getorder_time() {
			return this.order_time;
		}
		public void setorder_time(String f) {
			this.order_time = f;
		}
		public double gettotal_price() {
			return this.total_price;
		}
		public void settotal_price(double s) {
			this.total_price = s;
		}
		public int getfare() {
			return this.fare;
		}
		public void setfare(int d) {
			this.fare = d;
		}
		public String getplace_from() {
			return this.place_from;
		}
		public void setplace_from(String t) {
			this.place_from = t;
		}
		public String getplace_to() {
			return this.place_to;
		}
		public void setplace_to(String t) {
			this.place_to = t;
		}
		
		
		
		//���붩��
		public static void suijicreateOrder() throws IOException {
			String[] location = {"���","����","������","�����","�Ϻ���","������","�ӱ�ʡ","ɽ��ʡ","����ʡ","����ʡ","������ʡ","����ʡ","�㽭ʡ","����ʡ","����ʡ","����ʡ","ɽ��ʡ","����ʡ","����ʡ","����ʡ","�㶫ʡ","����ʡ","�Ĵ�ʡ","����ʡ","����ʡ","����ʡ","����ʡ","�ຣʡ"};
			//28������
			String[] comment1  = {"�̼�̬�Ⱥܺ�","�����ܿ�","�ﳬ��ֵ","���Ƽ�������","��ûʹ�ã�ϰ���Ժ���","��۸�ʵ�ݣ��ǳ�����","ֵ���Ƽ�������ϲ��","��������","�ܻ���","ֵ�ûع�","����ʹ�ø�����","��װ����","������Ʒ","�Ż����ȴ�","ֵ�öڻ�","�ܺ���","������Ĺ�������","�������","��ʵ������","��ʵ������","��ʵ����Ż����ȴ�","���޻ع�","����̬�Ⱥ���","�ͷ�������","��ʵ�����о�һ��"};
			String[] comment2  = {"��Ч��","��ݰ��ĺ���ʵ","���õ�û��˵","�����","�·����������Ĵ���","������Ʒ","ֵ���Ƽ�������ϲ��","��װ����ϸ","�ۺ��б���","ֵ�ûع�","�ǳ�����","һֱ������õ�","��Ʒ����","ȷ��������Ʒ����","һ���������","�ر���Ʒ","�ع�������","Ʒ��û��˵","��������","�����ģ���","�ǳ�����","�죡�룡ȫ��","����̬�Ⱥ���","���մ������","һֱ������ֵ��ӵ��"};
			String[] comment3  = {"��������","����100��","Ʒ�ʺ��ٶ���������","���ã�ʵ�ݡ�","��ĺܺã�","һ�����֧��","һ��Ҫ��������ѽ����","�����ޣ�","�ͷ����ɰ���","ֵ����","һ��Ҫ��������","һ�ü����ˣ��������","������","����Ʒ","�Ͻ����","���Ǳر���","���޻ع�","����Ǻ���","����","���̼ҵ��ޣ�","�ǳ�good��","��������","�ͷ�̬�����","���ڰβ���","������"};
			//25 25 25
			String[] comment4  = {"����������ӣ��Ա�һ��","ϣ������","�������ã�������","����OKû����","�����ܸܵģ���","���а�","����һ��","û���ر���","һ��һ��","ֵ����","һ��Ҫ��������","һ�ü����ˣ��������","������","����Ʒ","�Ͻ����","���Ǳر���","���޻ع�","����Ǻ���","����","���̼ҵ��ޣ�","�ǳ�good��","��������","�ͷ�̬�����","���ڰβ���","������"};
			
			
			String str2 = "U" + String.format("%5d", (5 + User.suijiBiggerInt(1005))).replace(" ", "0");
			
			
			List<String> list = AdministratorOperation.selectProductOfShop(str2);
			product_num = User.suijiBiggerInt(3);
			while(product_num >= list.size()) {
				str2 = "U" + String.format("%5d", (5 + User.suijiBiggerInt(1005))).replace(" ", "0");
				list = AdministratorOperation.selectProductOfShop(str2);
				product_num = User.suijiBiggerInt(3);
			}
			
			Order order = new Order(product_num);
			
			String str1 = "OR" + String.format("%7d", Order.count).replace(" ", "0"); 
			String[] strings = new String[list.size()];
			list.toArray(strings);
			int xuhao = User.suijiInt(strings.length - product_num);
			for(int i = xuhao,j = 0; j<product_num; i++,j++) {
				order.setproduct_id(j,strings[i]);//���������Ʒ���
				order.setproduct_num(j, User.suijiBiggerInt(5));
				order.setproduct_price(j, AdministratorOperation.selectProductPrice(strings[i], str2));
				order.setcomment(j,comment1[User.suijiInt(25)]+ ","+comment2[User.suijiInt(25)]+","+comment3[User.suijiInt(25)]);
			
			}
			
			int[] fare = {0,0,0,0,0,9,10,11,12,13};
			order.setorder_id(str1);
			order.setshopkeeper_id(str2);
			order.setfare(fare[User.suijiInt(10)]);
			double total = 0;
			for(int i = 0; i < product_num; i++) {
				total = total + Double.parseDouble(order.getproduct_num(i))*Double.parseDouble(order.getproduct_price(i));
			}
			order.settotal_price((double) Math.round(total*100) / 100);
			order.setuser_id("U" + String.format("%5d", (1010 + User.suijiBiggerInt(10090))).replace(" ", "0"));
			order.setplace_from(location[User.suijiInt(28)]);
			order.setplace_to(location[User.suijiInt(28)]);
			
			order.setorder_time( (2017+User.suijiInt(3)) +"-"+ User.suijiBiggerInt(12) +"-"+  User.suijiBiggerInt(28) +" "+ User.suijiInt(24) +":"+ User.suijiInt(60) +":"+ User.suijiInt(60) );
			
			order.state = "�����";//////!!!!!!!!!!!!!!!!!!!!!!!!!!!!    "2019-07-"+  (User.suijiBiggerInt(9) )+" "+ User.suijiInt(24) +":"+ User.suijiInt(60) +":"+ User.suijiInt(60) 
			
			AdministratorOperation.insertOrder(order);
			System.out.println(str1 +" �����ɹ�! ����Ϊ"+ str2);
			
			AdministratorOperation.insertProductIntoOrder(order);
			System.out.println(str1 +" ������Ʒ��Ϊ"+ product_num);
			
			
		}	
		
		
		
 
}
