package xiaoxueqi;

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
import java.awt.Dimension;

public class userUpdate extends JFrame implements ActionListener{
	JLabel l1 = new JLabel("�����û���id");
	JTextField t1=new JTextField(15);
	JLabel l2 = new JLabel("��������");
	JPasswordField pfPassword=new JPasswordField(15);
	JLabel l3 = new JLabel("���õ绰");
	JTextField t2=new JTextField(15);
	JButton b1 = new JButton("����");
	JButton b2 = new JButton("����");
	JButton b3 = new JButton("ȷ��");
	public userUpdate(){
		super("�����û���Ϣ");
		this.setLayout(new FlowLayout());
      		this.add(l1);this.add(t1);
       		this.add(l2);this.add(pfPassword);
       		this.add(l3);this.add(t2);
       		this.add(b1);
       		this.add(b2);	
       		this.add(b3);
        	this.setSize(300,200);
        	l2.setPreferredSize(new Dimension(78,20));
    		l3.setPreferredSize(new Dimension(78,20));
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
   	 	if(e.getSource()==b1) {
   	 		this.dispose();
			new userUpdate();
    	}
   	 	else if(e.getSource()==b2) {
       		this.dispose();
       		new userManage();
   		}
   	 	else {
   	 		AdministratorOperation.updateUser(s1, s2, s3);
   	 		JOptionPane.showMessageDialog(this,"���³ɹ�");
   	 		this.dispose();
			new userManage();
   	 	}
   		
}
}

