package xiaoxueqi;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class userCreate  extends JFrame implements ActionListener{
	JLabel l1 = new JLabel("新用户id：");
	JLabel t1=new JLabel("" + (User.count+1));
	JLabel l2 = new JLabel("用户密码：");
	JPasswordField pfPassword=new JPasswordField(15);
	JLabel l3 = new JLabel("姓：");
	JTextField t2=new JTextField(15);
	JLabel l4 = new JLabel("名：");
	JTextField t3=new JTextField(15);
	JLabel l5 = new JLabel("性别:");
	JComboBox cbDept=new JComboBox();
	JLabel l6 = new JLabel("出生年-月-日：");
	JTextField t4=new JTextField(15);
	JLabel l9 = new JLabel("电话号码：");
	JTextField t7=new JTextField(15);
	JLabel l10 = new JLabel("身份：");
	JComboBox cbDept4 =new JComboBox();
	JButton b1 = new JButton("重置");
	JButton b2 = new JButton("返回");
	JButton b3 = new JButton("确定");
	public userCreate(){
		super("创建新用户");
		this.setLayout(new FlowLayout());
       	this.add(l1,BorderLayout.NORTH);
       	this.add(t1,BorderLayout.NORTH);
       	this.add(l2,BorderLayout.CENTER);
       	this.add(pfPassword,BorderLayout.CENTER);
     	this.add(l3,BorderLayout.CENTER);
       	this.add(t2,BorderLayout.CENTER);	
       	this.add(l4,BorderLayout.CENTER);
       	this.add(t3,BorderLayout.CENTER);
       	this.add(l5,BorderLayout.CENTER);
       	this.add(cbDept);
       	this.add(l10,BorderLayout.CENTER);
       	this.add(cbDept4);
       	this.add(l6,BorderLayout.CENTER);
        this.add(t4,BorderLayout.CENTER);
       	this.add(l9,BorderLayout.CENTER);
       	this.add(t7,BorderLayout.CENTER);
       	this.add(b1,BorderLayout.SOUTH);
       	this.add(b2,BorderLayout.SOUTH);
       	this.add(b3,BorderLayout.SOUTH);
       	cbDept.addItem("男");
        cbDept.addItem("女");
        cbDept4.addItem("用户");
        cbDept4.addItem("商家");
        cbDept4.addItem("管理员");
        
       	t1.setPreferredSize(new Dimension(180,20));
       	l3.setPreferredSize(new Dimension(60,20));
       	l4.setPreferredSize(new Dimension(60,20));
       	l5.setPreferredSize(new Dimension(45,20));
       	cbDept.setPreferredSize(new Dimension(55,20));
    	l10.setPreferredSize(new Dimension(50,20));
       	cbDept4.setPreferredSize(new Dimension(70,20));
        this.setSize(260,280);
        GUIUtil.toCenter(this);
       	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //  this.setResizable(false);
        this.setVisible(true);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		String s1 = t1.getText();	//id
		String s2 = t2.getText();	
		String s3 = new String(pfPassword.getPassword());	//密码
		String s4 = t3.getText();
		String s5 = t7.getText();
		String s6=(String)cbDept4.getSelectedItem();
		String s7=(String)cbDept.getSelectedItem();
		String s8=t4.getText();
   	 	if(e.getSource()==b1) {
   	 		this.dispose();
			new userCreate();
   	 	}
   	 	else if(e.getSource()==b2){
   	 		this.dispose();
   	 		new userManage();
   	 	}	
   	 	else {
   	 		if(s1.length()==0||s2.length()==0||s3.length()==0||s4.length()==0||s5.length()==0||s6.length()==0||s7.length()==0||s8.length()==0) {
   	 			JOptionPane.showMessageDialog(this,"创建失败! 请输入完整信息！");
   	 			return;
	 		}
	 		else {
	 			User user_create = new User(s1,s3,s6,s4,s2,s7,s8,s5);
	 			AdministratorOperation.insertUser(user_create);
	 			JOptionPane.showMessageDialog(this,"创建成功");
	   	 		this.dispose();
	   	 		new userManage();
	 		}
   	 		
   	 		
   	 	}
   	 	
}
}

