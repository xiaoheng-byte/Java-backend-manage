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
import javax.swing.JTextField;
public class productAdd  extends JFrame implements ActionListener{
	JLabel l2 = new JLabel("商品id：");
	JTextField t1=new JTextField(15);
	JLabel l3 = new JLabel("新商品名：");
	JTextField t2=new JTextField(15);
	JLabel l4 = new JLabel("价格：");
	JTextField t3=new JTextField(5);
	JLabel l6 = new JLabel("库存量：");
	JTextField t5=new JTextField(5);
	JLabel l7 = new JLabel("类别：");
	JTextField t6=new JTextField(15);
	JLabel l5 = new JLabel("新说明：");
	JTextField t4=new JTextField(20);
	JButton b1 = new JButton("重置");
	JButton b2 = new JButton("返回");
	JButton b3 = new JButton("确定");
	public productAdd(){
		super("增加商品");
		this.setLayout(new FlowLayout());
       	this.add(l2,BorderLayout.NORTH);
       	this.add(t1,BorderLayout.NORTH);
       	this.add(l3,BorderLayout.CENTER);
       	this.add(t2,BorderLayout.CENTER);
     	this.add(l4,BorderLayout.CENTER);
       	this.add(t3,BorderLayout.CENTER);	
       	this.add(l6,BorderLayout.CENTER);
       	this.add(t5,BorderLayout.CENTER);
       	this.add(l7,BorderLayout.CENTER);
       	this.add(t6,BorderLayout.CENTER);
       	this.add(l5,BorderLayout.CENTER);
       	this.add(t4,BorderLayout.EAST);
       	this.add(b1,BorderLayout.SOUTH);
       	this.add(b2,BorderLayout.SOUTH);
       	this.add(b3,BorderLayout.SOUTH);
        this.setSize(260,240);
        l2.setPreferredSize(new Dimension(70,20));
       	l3.setPreferredSize(new Dimension(70,20));
       	l7.setPreferredSize(new Dimension(70,20));
       	l4.setPreferredSize(new Dimension(53,20));
       	l6.setPreferredSize(new Dimension(53,20));
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
		String s2 = t2.getText();
		String s3 = t3.getText();
		String s4 = t4.getText();
		String s5 = t5.getText();
		String s6 = t6.getText();
   	 	if(e.getSource()==b1) {
   	 		this.dispose();
			new productAdd();
   	 	}
   	 	else if(e.getSource()==b2){
   	 		this.dispose();
   	 		new productManage();
   	 	}	
   	 	else {
   	 		if(s1.length()==0||s2.length()==0||s3.length()==0||s4.length()==0||s5.length()==0||s6.length()==0) {
   	 			JOptionPane.showMessageDialog(this,"修改失败! 请输入完整信息！");
	 			return;
   	 		}
   	 		else {
   	 			ShopkeeperOperation.insertProduct(new Product(s1,LoginJudge.user_id, s6, s2, s4, s3, s5));
   	 			JOptionPane.showMessageDialog(this,"修改成功");
   	 			this.dispose();
   	 			new productManage();
   	 		}

   	 		
   	 	}
   	 	
}
}
