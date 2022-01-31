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
public class orderQueryMediumCatalogy  extends JFrame implements ActionListener {
	JLabel l1 = new JLabel("请输入需要查询的中类名称：");
	JTextField t1=new JTextField(20);
	JButton b1 = new JButton("重置");
    JButton b2 = new JButton("返回");
    JButton b3 = new JButton("确定");
	public orderQueryMediumCatalogy(){
		super("按中类查询");
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
		String s = t1.getText();
   	 	if(e.getSource()==b1) {
   	 		this.dispose();
			new orderQueryMediumCatalogy();
   	 	}
   	 	else if(e.getSource()==b2) {
   	 		this.dispose();
   	 		new orderQuery();
   	 	}	
   	 	else {
   	 		if(s.length()==0) {
			JOptionPane.showMessageDialog(this,"查询失败! 请输入完整信息！");
			return;
   	 		}
   	 	else {
   	 	ShopkeeperOperation.selectTotalNumAndTotalPriceOfOrderInfoByS_Category(s, LoginJudge.user_id);
   	 	}
   	 	}
	}
}




