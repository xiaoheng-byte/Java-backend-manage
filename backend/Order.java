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
		public String product[][];//一个表，第一列商品编号，第二列数量，第三列价格
		public Order() {Order.count++;}
		public Order(int productNum) {//有productNum种商品的订单
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
		
		
		
		//插入订单
		public static void suijicreateOrder() throws IOException {
			String[] location = {"香港","澳门","北京市","天津市","上海市","重庆市","河北省","山西省","辽宁省","吉林省","黑龙江省","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","海南省","四川省","贵州省","云南省","陕西省","甘肃省","青海省"};
			//28个城市
			String[] comment1  = {"商家态度很好","物流很快","物超所值","会推荐给朋友","还没使用，习惯性好评","活动价格实惠，非常满意","值得推荐，超级喜欢","质量不错","很划算","值得回购","个人使用感良好","包装精美","赠了赠品","优惠力度大","值得囤货","很合适","很满意的购物体验","交易愉快","比实体店便宜","比实体店合算","比实体店优惠力度大","无限回购","服务态度好评","客服很耐心","和实体店里感觉一样"};
			String[] comment2  = {"有效果","快递包的很严实","好用得没话说","疯狂安利","仿佛打开了新世界的大门","神仙物品","值得推荐，超级喜欢","包装很仔细","售后有保障","值得回购","非常靠谱","一直以来最爱用的","正品保障","确认了是正品无疑","一如既往好用","必备物品","回购三次了","品质没得说","棒！！！","棒棒的！！","非常棒！","快！齐！全！","服务态度好评","次日达，超级快","一直买它，值得拥有"};
			String[] comment3  = {"好评满分","好评100分","品质和速度让人满意","好用，实惠。","真的很好！","一如既往支持","一定要买来试试呀！！","赞赞赞！","客服超可爱的","值得买！","一定要买它买它","一用几年了，真的蛮好","超好用","是正品","赶紧买吧","真是必备的","无限回购","真的是好物","好评","给商家点赞！","非常good！","物流给力","客服态度真好","终于拔草了","真心赞"};
			//25 25 25
			String[] comment4  = {"试试这个牌子，对比一下","希望好用","不错，好用，好评了","东西OK没问题","质量杠杠的！！","还行吧","质量一般","没有特别惊艳","一般一般","值得买！","一定要买它买它","一用几年了，真的蛮好","超好用","是正品","赶紧买吧","真是必备的","无限回购","真的是好物","好评","给商家点赞！","非常good！","物流给力","客服态度真好","终于拔草了","真心赞"};
			
			
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
				order.setproduct_id(j,strings[i]);//店内随机商品编号
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
			
			order.state = "已完成";//////!!!!!!!!!!!!!!!!!!!!!!!!!!!!    "2019-07-"+  (User.suijiBiggerInt(9) )+" "+ User.suijiInt(24) +":"+ User.suijiInt(60) +":"+ User.suijiInt(60) 
			
			AdministratorOperation.insertOrder(order);
			System.out.println(str1 +" 创建成功! 店铺为"+ str2);
			
			AdministratorOperation.insertProductIntoOrder(order);
			System.out.println(str1 +" 订单商品数为"+ product_num);
			
			
		}	
		
		
		
 
}
