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
	JLabel l1 = new JLabel("���̼�id��");
	JLabel t1=new JLabel("" + (User.count+1));
	JLabel l2 = new JLabel("�̼����룺");
	JPasswordField pfPassword=new JPasswordField(15);
	JLabel ln = new JLabel("�������ƣ�");
	JTextField tn=new JTextField(15);
	JLabel l3 = new JLabel("�գ�");
	JTextField t2=new JTextField(15);
	JLabel l4 = new JLabel("����");
	JTextField t3=new JTextField(15);
	JLabel l5 = new JLabel("�Ա�:");
	JComboBox cbDept=new JComboBox();
	JTextField t4=new JTextField(20);
	JLabel l6 = new JLabel("������-��-�գ�");
	JTextField t6 = new JTextField(15);
	JLabel l9 = new JLabel("�绰���룺");
	JTextField t7=new JTextField(15);
	JButton b1 = new JButton("����");
	JButton b2 = new JButton("����");
	JButton b3 = new JButton("ȷ��");
	public SKCreate(){
		super("�������̼�");
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
       	cbDept.addItem("��");
        cbDept.addItem("Ů");
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
   	 			JOptionPane.showMessageDialog(this,"����ʧ��! ������������Ϣ��");
   	 			return;
	 		}
	 		else {
	 			Shop shop = new Shop(s1,s3,"�̼�",s2,s4,s8,s7,s5,s6);
	 			AdministratorOperation.insertShop(shop);
	 			JOptionPane.showMessageDialog(this,"�����ɹ�");
	   	 		this.dispose();
	   	 		new SKManage();
	 		}
   	 		
   	 		
   	 	}
   	 	
}
}

