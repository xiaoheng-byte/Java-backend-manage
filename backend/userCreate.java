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
	JLabel l1 = new JLabel("���û�id��");
	JLabel t1=new JLabel("" + (User.count+1));
	JLabel l2 = new JLabel("�û����룺");
	JPasswordField pfPassword=new JPasswordField(15);
	JLabel l3 = new JLabel("�գ�");
	JTextField t2=new JTextField(15);
	JLabel l4 = new JLabel("����");
	JTextField t3=new JTextField(15);
	JLabel l5 = new JLabel("�Ա�:");
	JComboBox cbDept=new JComboBox();
	JLabel l6 = new JLabel("������-��-�գ�");
	JTextField t4=new JTextField(15);
	JLabel l9 = new JLabel("�绰���룺");
	JTextField t7=new JTextField(15);
	JLabel l10 = new JLabel("��ݣ�");
	JComboBox cbDept4 =new JComboBox();
	JButton b1 = new JButton("����");
	JButton b2 = new JButton("����");
	JButton b3 = new JButton("ȷ��");
	public userCreate(){
		super("�������û�");
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
       	cbDept.addItem("��");
        cbDept.addItem("Ů");
        cbDept4.addItem("�û�");
        cbDept4.addItem("�̼�");
        cbDept4.addItem("����Ա");
        
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
		String s3 = new String(pfPassword.getPassword());	//����
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
   	 			JOptionPane.showMessageDialog(this,"����ʧ��! ������������Ϣ��");
   	 			return;
	 		}
	 		else {
	 			User user_create = new User(s1,s3,s6,s4,s2,s7,s8,s5);
	 			AdministratorOperation.insertUser(user_create);
	 			JOptionPane.showMessageDialog(this,"�����ɹ�");
	   	 		this.dispose();
	   	 		new userManage();
	 		}
   	 		
   	 		
   	 	}
   	 	
}
}

