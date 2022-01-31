package xiaoxueqi.semaster.src.xiaoxueqi;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import xiaoxueqi.Shop;
import xiaoxueqi.orderQuery;
import xiaoxueqi.orderQueryTime1;

public class orderQueryTimeTable extends JFrame implements ActionListener {
	int ordernumber = 3;
	int totalprice = 300;
	DefaultTableModel model = null;
	JTable table = null;
	JButton addB1 = new JButton("������һ��");
	JButton addB2 = new JButton("���²�ѯ");
	JLabel t1 = new JLabel("������(��)��"+ordernumber);
	JLabel t2 = new JLabel("�ܽ��(Ԫ)��"+totalprice);
	public orderQueryTimeTable(){
	   super("������ѯ");
	   String[][] datas = {};
	   String[] titles = { "������", "�ܽ��" };
	   model = new DefaultTableModel(datas, titles);
	   table = new JTable(model);
	   ArrayList<Shop> lists = new ArrayList<Shop> ();
	   Shop shop1 = new Shop("123123","asdfghjkl","shopkeeper","A","BC","F","1999/12/26","15611235300","50");
	   Shop shop2 = new Shop("234234","asdfsgjkl","shopkeeper","C","����","F","1997/12/26","15611235300","200");
	   Shop shop3 = new Shop("345345","asdawgaj","shopkeeper","shide","����","F","1998/12/26","15611235300","50");
	   lists.add(shop1);
	   lists.add(shop2);
	   lists.add(shop3);
	   for(Shop shop:lists)
	         model.addRow(new String[] { shop.getUser_id(), shop.getShop_name() });
	   this.setLayout(new FlowLayout());
	   this.add(addB1);
	   this.add(addB2);
	   this.add(t1);
	   this.add(t2);
	   t1.setPreferredSize(new Dimension(100,20));
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
			new orderQuery();
   	 	}
   	 	else{
   	 		this.dispose();
   	 		new orderQueryTime1();
   	 	}		
	}
}




  