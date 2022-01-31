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

public class userSearchTable extends JFrame implements ActionListener {
	DefaultTableModel model = null;
	JTable table = null;
	JButton addB1 = new JButton("返回上一级");
	JButton addB2 = new JButton("重新查询");
	public userSearchTable(){
	   super("用户查询");
	   String[][] datas = {};
	   String[] titles = { "用户id"};
	   model = new DefaultTableModel(datas, titles);
	   table = new JTable(model);
	   ArrayList<User> users = new ArrayList<User> ();
	   User user1 = new User("123123","asdfghjkl","shopkeeper","A","BC","F","1999/12/26","15611235300");
	   User user2 = new User("234234","asdfsgjkl","AD","C","苟迩","M","1997/12/26","15611235300");
	   User user3 = new User("345345","asdawgaj","AD","shide","苟迩","F","1998/12/26","15611235300");
	   users.add(user1);
	   users.add(user2);
	   users.add(user3);
	   for(User user:users)
	         model.addRow(new String[] {user.getUser_id()});
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
			new userManage();
   	 	}
   	 	else{
   	 		this.dispose();
   	 		new userSearch();
   	 	}		
	}
}




  
