package xiaoxueqi;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;

public class SKUpdate extends JFrame implements ActionListener{
	JLabel l1 = new JLabel("更新商家的id");
	JTextField t1=new JTextField(15);
	JLabel l2 = new JLabel("重置密码");
	JPasswordField pfPassword=new JPasswordField(15);
	JLabel l3 = new JLabel("重置电话");
	JTextField t2=new JTextField(15);
	JLabel l4 = new JLabel("重置店名");
	JTextField t3=new JTextField(15);
	JButton b1 = new JButton("重置");
	JButton b2 = new JButton("返回");
	JButton b3 = new JButton("确定");
	public SKUpdate(){
		super("更新用户信息");
		this.setLayout(new FlowLayout());
      		this.add(l1);this.add(t1);
       		this.add(l2);this.add(pfPassword);
       		this.add(l3);this.add(t2);
       		this.add(l4);this.add(t3);
       		this.add(b1);
       		this.add(b2);	
       		this.add(b3);
        	this.setSize(300,200);
        	l2.setPreferredSize(new Dimension(78,20));
    		l3.setPreferredSize(new Dimension(78,20));
    		l4.setPreferredSize(new Dimension(78,20));
        	GUIUtil.toCenter(this);
       		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	this.setResizable(false);
        	this.setVisible(true);
        	b1.addActionListener(this);
        	b2.addActionListener(this);
        	b3.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
			String s1 = t1.getText();
			String s2  = new String(pfPassword.getPassword());	
			String s3 = t2.getText();
			String s4 = t3.getText();
   	 	if(e.getSource()==b1) {
   	 		this.dispose();
			new SKUpdate();
    	}
   	 	else if(e.getSource()==b2) {
       		this.dispose();
       		new SKManage();
   		}
   	 	else {
   	 		AdministratorOperation.updateShop(s1,s2,s3,s4);
   	 		JOptionPane.showMessageDialog(this,"更新成功");
   	 		this.dispose();
   	 		new SKManage();
   	 	}
   		
}
}
