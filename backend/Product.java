package xiaoxueqi;

public class Product {
	private String product_id;
	private String shopkeeper_id;
	private String s_category;
	private String product_name;
	private String product_introduction;
	private String price;
	private String present_stock;
	public Product() {}
	public Product(String pid, String sid, String c, String n, String i, String p, String ps) {
		this.product_id = pid;
		this.shopkeeper_id = sid;
		this.s_category = c;
		this.product_name = n;
		this.product_introduction = i;
		this.price = p;
		this.present_stock = ps;
	}
	public String getProduct_id() {
		return this.product_id;
	}
	public void setProduct_id(String pid) {
		this.product_id = pid;
	}
	public String getShopkeeper_id() {
		return this.shopkeeper_id;
	}
	public void setShopkeeper_id(String sid) {
		this.shopkeeper_id = sid;
	}
	public String getS_category() {
		return this.s_category;
	}
	public void setS_category(String c) {
		this.s_category = c;
	}
	public String getProduct_name() {
		return this.product_name;
	}
	public void setProduct_name(String n) {
		this.product_name = n;
	}
	public String getProduct_introduction() {
		return this.product_introduction;
	}
	public void setProduct_introduction(String i) {
		this.product_introduction = i;
	}
	public String getPrice() {
		return this.price;
	}
	public void setPrice(String p) {
		this.price = p;
	}
	public String getPresent_stock() {
		return this.present_stock;
	}
	public void setPresent_stock(String ps) {
		this.present_stock = ps;
	}
	
}
