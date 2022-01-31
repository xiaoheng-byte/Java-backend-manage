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

public class SKCreate  extends JFrame implements ActionListener{
	JLabel l1 = new JLabel("新商家id：");
	JLabel t1=new JLabel("" + (User.count+1));
	JLabel l2 = new JLabel("商家密码：");
	JPasswordField pfPassword=new JPasswordField(15);
	JLabel ln = new JLabel("店铺名称：");
	JTextField tn=new JTextField(15);
	JLabel l3 = new JLabel("姓：");
	JTextField t2=new JTextField(15);
	JLabel l4 = new JLabel("名：");
	JTextField t3=new JTextField(15);
	JLabel l5 = new JLabel("性别:");
	JComboBox cbDept=new JComboBox();
	JTextField t4=new JTextField(20);
	JLabel l6 = new JLabel("出生年-月-日：");
	JTextField t6 = new JTextField(15);
	JLabel l9 = new JLabel("电话号码：");
	JTextField t7=new JTextField(15);
	JButton b1 = new JButton("重置");
	JButton b2 = new JButton("返回");
	JButton b3 = new JButton("确定");
	public SKCreate(){
		super("创建新商家");
		this.setLayout(new FlowLayout());
       	this.add(l1,BorderLayout.NORTH);
       	this.add(t1,BorderLayout.NORTH);
       	this.add(ln,BorderLayout.NORTH);
       	this.add(tn,BorderLayout.NORTH);
       	this.add(l2,BorderLayout.CENTER);
       	this.add(pfPassword,BorderLayout.CENTER);
     	this.add(l3,BorderLayout.CENTER);
       	this.add(t2,BorderLayout.CENTER);	
       	this.add(l4,BorderLayout.CENTER);
       	this.add(t3,BorderLayout.CENTER);
       	this.add(l5,BorderLayout.CENTER);
       	this.add(cbDept);
       	this.add(l6,BorderLayout.CENTER);
       	this.add(t6,BorderLayout.CENTER);
       	this.add(l9,BorderLayout.CENTER);
       	this.add(t7,BorderLayout.CENTER);
       	this.add(b1,BorderLayout.SOUTH);
       	this.add(b2,BorderLayout.SOUTH);
       	this.add(b3,BorderLayout.SOUTH);
       	cbDept.addItem("男");
        cbDept.addItem("女");
       	t1.setPreferredSize(new Dimension(180,20));
       	l3.setPreferredSize(new Dimension(60,20));
       	l4.setPreferredSize(new Dimension(60,20));
       	l5.setPreferredSize(new Dimension(64,20));
       	cbDept.setPreferredSize(new Dimension(150,20));
        this.setSize(260,300);
        GUIUtil.toCenter(this);
       	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //  this.setResizable(false);
        this.setVisible(true);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		String s1 = t1.getText();
		String s2 = t2.getText();
		String s3 = new String(pfPassword.getPassword());
		String s4 = t3.getText();
		String s5 = t7.getText();
		String s6 = tn.getText();
		String s7 = t6.getText();
		String s8=(String)cbDept.getSelectedItem();
   	 	if(e.getSource()==b1) {
   	 		this.dispose();
			new SKCreate();
   	 	}
   	 	else if(e.getSource()==b2){
   	 		this.dispose();
   	 		new SKManage();
   	 	}	
   	 	else {
   	 		if(s1.length()==0||s2.length()==0||s3.length()==0||s4.length()==0||s5.length()==0||s6.length()==0||s7.length()==0||s8.length()==0) {
   	 			JOptionPane.showMessageDialog(this,"创建失败! 请输入完整信息！");
   	 			return;
	 		}
	 		else {
	 			Shop shop = new Shop(s1,s3,"商家",s2,s4,s8,s7,s5,s6);
	 			AdministratorOperation.insertShop(shop);
	 			JOptionPane.showMessageDialog(this,"创建成功");
	   	 		this.dispose();
	   	 		new SKManage();
	 		}
   	 		
   	 		
   	 	}
   	 	
}
}

