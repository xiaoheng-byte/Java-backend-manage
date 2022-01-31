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

public class SKSearchTable extends JFrame implements ActionListener {
	DefaultTableModel model = null;
	JTable table = null;
	JButton addB1 = new JButton("返回上一级");
	JButton addB2 = new JButton("重新查询");
	public SKSearchTable(){
	   super("商家查询");
	   String[][] datas = {};
	   String[] titles = { "商家id", "店名" };
	   model = new DefaultTableModel(datas, titles);
	   table = new JTable(model);
	   ArrayList<Shop> lists = new ArrayList<Shop> ();
	   Shop shop1 = new Shop("123123","asdfghjkl","shopkeeper","A","BC","F","1999/12/26","15611235300","食品店");
	   Shop shop2 = new Shop("234234","asdfsgjkl","shopkeeper","C","苟迩","F","1997/12/26","15611235300","服装店");
	   Shop shop3 = new Shop("345345","asdawgaj","shopkeeper","shide","苟迩","F","1998/12/26","15611235300","宠物店");
	   lists.add(shop1);
	   lists.add(shop2);
	   lists.add(shop3);
	   for(Shop shop:lists)
	         model.addRow(new String[] { shop.getUser_id(), shop.getShop_name() });
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
			new SKManage();
   	 	}
   	 	else{
   	 		this.dispose();
   	 		new SKSearch();
   	 	}		
	}
}




  