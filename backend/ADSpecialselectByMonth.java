package xiaoxueqi;
//每个月的订单数量和金额情况统计（要求订单时间跨度不低于一年
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

import xiaoxueqi.semaster.src.xiaoxueqi.orderQueryTimeTable;
public class ADSpecialselectByMonth  extends JFrame implements ActionListener {
	JLabel l1 = new JLabel("请输入查询起始时间(例如2000-01-01)");
	JTextField t1 =new JTextField(20);
	JLabel l2 = new JLabel("请输入查询终止时间(例如2000-01-01)");
	JTextField t2 =new JTextField(20);
	JButton b1 = new JButton("重置");
    JButton b2 = new JButton("返回");
    JButton b3 = new JButton("确定");
    public ADSpecialselectByMonth(){
		super("每个月的订单数量和金额情况统计");
		this.setLayout(new FlowLayout());
       	this.add(l1);
       	this.add(t1);
       	this.add(l2);
       	this.add(t2);
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
		String s1=t1.getText();
		String s2=t2.getText();
		
   	 	if(e.getSource()==b1) {
   	 		this.dispose();
			new ADSpecialselectByMonth();
   	 	}
   	 	else if(e.getSource()==b2) {
   	 		this.dispose();
   	 		new orderQuery();
   	 	}	
   	 	else {
   	 		if(s1.length()==0||s2.length()==0) {
				JOptionPane.showMessageDialog(this,"查询失败! 请按格式输入正确日期！");
				return;
   	 		}
   	 		else {
   	 		//selectTotalNumAndTotalPriceOfOrderInfoByTime(s1, s2, String shopkeeper_id)
   	 			new orderQueryTimeTable();
   	 		}
   	 		
   	 	}
	}
}


