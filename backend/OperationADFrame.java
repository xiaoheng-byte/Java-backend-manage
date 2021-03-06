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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class OperationADFrame extends JFrame implements ActionListener{
	JLabel l1 = new JLabel("———————管理员\"+ LoginJudge.user_id +\"您好！请选择操作———————");
	JButton b1 = new JButton("用户管理");
	JButton b2 = new JButton("商家管理");
	JButton b3 = new JButton("商品管理");
	JButton b4 = new JButton("订单管理");
	JButton b5 = new JButton("类别管理");
	public OperationADFrame(){
		super("管理员界面"); 		
		this.setLayout(new FlowLayout());
  		this.add(l1);
   		this.add(b1);
   		this.add(b2);	
   		this.add(b3);
   		this.add(b4);
   		this.add(b5);
   		this.setLayout(null);
   		this.setSize(400,400);
    	l1.setBounds(20,20,350,30);
    	b1.setBounds(100,60,180,30);
    	b2.setBounds(100,110,180,30);
    	b3.setBounds(100,160,180,30);
    	b4.setBounds(100,210,180,30);
    	b5.setBounds(100,260,180,30);
    	GUIUtil.toCenter(this);
   		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setResizable(false);
    	this.setVisible(true);
    	b1.addActionListener(this);
    	b2.addActionListener(this);
    	b3.addActionListener(this);
    	b4.addActionListener(this);
    	b5.addActionListener(this);
   
 	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == b1) {
			this.dispose();
			new userManage();
		}	
		else if(e.getSource() == b2){
			this.dispose();
			new SKManage();
		}		
		else if(e.getSource() == b3) {
			this.dispose();
			new ADProductManage();
		}
		else if(e.getSource() == b4) {
			this.dispose();
			new orderManage();
		}
		else {
			this.dispose();
			new catalogyManage();
		}
	}	
}



