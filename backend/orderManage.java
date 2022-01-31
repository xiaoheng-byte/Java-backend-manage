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
import javax.swing.JTextField;

public class orderManage extends JFrame implements ActionListener {
	JLabel t1 = new JLabel("————————————订单管理————————————");
	JButton b1 = new JButton("去发货");
	JButton b2 = new JButton("订单查询");
	JButton b3 = new JButton("返回上一级");
	public orderManage(){
		super("订单管理");
		this.setLayout(new FlowLayout());
		this.add(t1);
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.setSize(400,400);
		this.setLayout(null);
		t1.setBounds(20,20,350,30);
    	b1.setBounds(100,80,200,30);
    	b2.setBounds(100,140,200,30);
    	b3.setBounds(100,200,200,30);
		GUIUtil.toCenter(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		b1.addActionListener(this);
   		b2.addActionListener(this);
   		b3.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b1){	
			this.dispose();
			new productDelivery();
		}
		else if(e.getSource()==b2){
			this.dispose();
			new orderQuery();
			
		}
		else if(e.getSource()==b3){
			this.dispose();
			new OperationSKFrame();
		}
			
	}
}	



