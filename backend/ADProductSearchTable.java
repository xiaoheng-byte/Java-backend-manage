package xiaoxueqi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.*; 
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ADProductSearchTable extends JFrame implements ActionListener {
	DefaultTableModel model = null;
	JTable table = null;
	JButton addB1 = new JButton("返回上一级");
	JButton addB2 = new JButton("重新查询");
	public ADProductSearchTable(){
	   super("商品查询");
	   String[][] datas = {};
	   String[] titles = { "商品id"};
	   model = new DefaultTableModel(datas, titles);
	   table = new JTable(model);
	   ArrayList<Product> lists = new ArrayList<Product> ();
	   Product product1 = new Product("123123","asdfghjkl","shopkeeper","A","BC","F","1999/2/26");
	   Product product2 = new Product("234234","asdfsgjkl","AD","C","苟迩","M","1997/12/2");
	   Product product3 = new Product("345345","asdawgaj","AD","shide","苟迩","F","1998/11/26");
	   lists.add(product1);
	   lists.add(product2);
	   lists.add(product3);
	   for(Product product:lists)
	         model.addRow(new String[] {product.getProduct_id()});
	   this.setLayout(new FlowLayout());
	   this.add(addB1);
	   this.add(addB2);
	   this.add(new JScrollPane(table));
	   this.setSize(500, 400);
	   this.setLocationRelativeTo(null);
	   this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   this.setVisible(true);
	   addB1.addActionListener(this);
	   addB2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
   	 	if(e.getSource()==addB1) {
   	 		this.dispose();
			new ADProductManage();
   	 	}
   	 	else{
   	 		this.dispose();
   	 		new ADProductSearch();
   	 	}		
	}
}




  

