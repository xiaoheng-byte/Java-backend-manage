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
public class ADProductSearch  extends JFrame implements ActionListener {
	JLabel l1 = new JLabel("查询(请输入product_id、shopkeeper_id、product_name、s_category、price等属性名）");
	JTextField t1=new JTextField(24);
	JLabel l2 = new JLabel("为:");
	JTextField t2=new JTextField(15);
	JLabel l3 = new JLabel("的全部商品");
	JButton b1 = new JButton("重置");
    JButton b2 = new JButton("返回");
    JButton b3 = new JButton("确定");
    public ADProductSearch(){
		super("查找商品");
		this.setLayout(new FlowLayout());
       	this.add(l1);
       	this.add(t1);
       	this.add(l2);
       	this.add(t2);
       	this.add(l3);
       	this.add(b1);
       	this.add(b2);
       	this.add(b3);
        this.setSize(260,200);
        GUIUtil.toCenter(this);
       	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		String s1 = t1.getText(); 
		String s2 = t2.getText();
   	 	if(e.getSource()==b1) {
   	 		this.dispose();
			new ADProductSearch();
   	 	}
   	 	else if(e.getSource()==b2) {
   	 		this.dispose();
   	 		new ADProductManage();
   	 	}	
   	 	else {
   	 		if(s1.length()==0||s2.length()==0) {
   	 			JOptionPane.showMessageDialog(this,"查找失败! 请输入完整信息！");
   	 			return;
   	 		}
   	 		else {
   	 			AdministratorOperation.selectProductByAttribute(s1, s2);
   	 			this.dispose();
   	 			new ADProductSearchTable();
   	 			
   	 		}
   	 		
   	 	}
	}
}

