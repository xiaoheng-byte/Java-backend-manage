package xiaoxueqi;
//ÿ���µĶ��������ͽ�����ͳ�ƣ�Ҫ�󶩵�ʱ���Ȳ�����һ��
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
	JLabel l1 = new JLabel("�������ѯ��ʼʱ��(����2000-01-01)");
	JTextField t1 =new JTextField(20);
	JLabel l2 = new JLabel("�������ѯ��ֹʱ��(����2000-01-01)");
	JTextField t2 =new JTextField(20);
	JButton b1 = new JButton("����");
    JButton b2 = new JButton("����");
    JButton b3 = new JButton("ȷ��");
    public ADSpecialselectByMonth(){
		super("ÿ���µĶ��������ͽ�����ͳ��");
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
				JOptionPane.showMessageDialog(this,"��ѯʧ��! �밴��ʽ������ȷ���ڣ�");
				return;
   	 		}
   	 		else {
   	 		//selectTotalNumAndTotalPriceOfOrderInfoByTime(s1, s2, String shopkeeper_id)
   	 			new orderQueryTimeTable();
   	 		}
   	 		
   	 	}
	}
}

