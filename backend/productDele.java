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
public class productDele  extends JFrame implements ActionListener {
	JLabel l1 = new JLabel("请输入需要删除的商品id：");
	JTextField t1=new JTextField(20);
	JButton b1 = new JButton("重置");
    JButton b2 = new JButton("返回");
    JButton b3 = new JButton("确定");
	public productDele(){
		super("删除商品");
		this.setLayout(new FlowLayout());
       	this.add(l1);
       	this.add(t1);
       	this.add(b1);
       	this.add(b2);
       	this.add(b3);
        this.setSize(260,200);
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
   	 	if(e.getSource()==b1) {
   	 		this.dispose();
			new productDele();
   	 	}
   	 	else if(e.getSource()==b2) {
   	 		this.dispose();
   	 		new productManage();
   	 	}	
   	 	else {
   	 		if(s1.length()==0) {
	 			JOptionPane.showMessageDialog(this,"删除失败! 请输入正确id！");
	 			return;
	 		}
   	 		else {
   	 		ShopkeeperOperation.deleteProduct(s1, LoginJudge.user_id);
   	 			JOptionPane.showMessageDialog(this,"删除成功");
   	 			this.dispose();
   	 			new productManage();
   	 		}
   	 		
   	 	}
	}
}
