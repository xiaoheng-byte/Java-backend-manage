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
public class productSearch  extends JFrame implements ActionListener {
	JLabel l1 = new JLabel("��ѯ(������product_id��product_name��s_category��price����������");
	JTextField t1=new JTextField(15);
	JLabel l2 = new JLabel("Ϊ:");
	JTextField t2=new JTextField(15);
	JLabel l3 = new JLabel("��ȫ����Ʒ");
	JButton b1 = new JButton("����");
    JButton b2 = new JButton("����");
    JButton b3 = new JButton("ȷ��");
    public productSearch(){
		super("������Ʒ");
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
        this.setResizable(false);
        this.setVisible(true);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
   	 	if(e.getSource()==b1) {
   	 		this.dispose();
			new productSearch();
   	 	}
   	 	else if(e.getSource()==b2) {
   	 		this.dispose();
   	 		new productManage();
   	 	}	
   	 	else {
   	 		this.dispose();
   	 		new productManage();
   	 		String s1 = t1.getText();
   	 		String s2 = t2.getText();
   	 		new QueryJFrame(ShopkeeperOperation.selectProductByAttribute(s1, s2, LoginJudge.user_id));
   	 	
   	 	}
	}
}
