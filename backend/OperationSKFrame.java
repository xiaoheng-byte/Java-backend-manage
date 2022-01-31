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

public class OperationSKFrame extends JFrame implements ActionListener{
	JLabel l1 = new JLabel("————————商家"+ LoginJudge.user_id +"您好！请选择操作————————");
	JButton b1 = new JButton("商品管理");
	JButton b2 = new JButton("订单管理");
	public OperationSKFrame(){
		super("商家界面"); 		
		this.setLayout(new FlowLayout());
  		this.add(l1);
   		this.add(b1);
   		this.add(b2);	
    	this.setSize(400,400);
    	l1.setPreferredSize(new Dimension(150,100));
    	b1.setPreferredSize(new Dimension(200,30));
    	b2.setPreferredSize(new Dimension(200,30));
    	this.setLayout(null);
    	l1.setBounds(20,20,350,50);
    	b1.setBounds(100,120,180,30);
    	b2.setBounds(100,180,180,30);
    	GUIUtil.toCenter(this);
   		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setResizable(false);
    	this.setVisible(true);
    	b1.addActionListener(this);
    	b2.addActionListener(this);
    	
    	
 	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == b1) {
			this.setVisible(false);
			new productManage();
		}	
		else {
			this.setVisible(false);
			new orderManage();
		}		
	}	
}



