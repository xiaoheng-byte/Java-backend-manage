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
public class productDelivery  extends JFrame implements ActionListener {
	JLabel l1 = new JLabel("�����붩���ţ�");
	JTextField t1=new JTextField(20);
	JButton b1 = new JButton("����");
    JButton b2 = new JButton("����");
    JButton b3 = new JButton("ȷ��");
	public productDelivery(){
		super("ȥ����");
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
   	 	if(e.getSource()==b1) {
   	 		this.dispose();
			new productDelivery();
   	 	}
   	 	else if(e.getSource()==b2){
   	 		this.dispose();
   	 		new orderManage();
   	 	}	
   	 	else {
   	 		ShopkeeperOperation.updateOrderInfo(t1.getText(), LoginJudge.user_id);
   	 		JOptionPane.showMessageDialog(this,"�����ɹ�");
			this.dispose();
			new orderManage();
   	 	}
	}
}