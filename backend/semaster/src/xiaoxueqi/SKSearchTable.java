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
	JButton addB1 = new JButton("������һ��");
	JButton addB2 = new JButton("���²�ѯ");
	public SKSearchTable(){
	   super("�̼Ҳ�ѯ");
	   String[][] datas = {};
	   String[] titles = { "�̼�id", "����" };
	   model = new DefaultTableModel(datas, titles);
	   table = new JTable(model);
	   ArrayList<Shop> lists = new ArrayList<Shop> ();
	   Shop shop1 = new Shop("123123","asdfghjkl","shopkeeper","A","BC","F","1999/12/26","15611235300","ʳƷ��");
	   Shop shop2 = new Shop("234234","asdfsgjkl","shopkeeper","C","����","F","1997/12/26","15611235300","��װ��");
	   Shop shop3 = new Shop("345345","asdawgaj","shopkeeper","shide","����","F","1998/12/26","15611235300","�����");
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




  