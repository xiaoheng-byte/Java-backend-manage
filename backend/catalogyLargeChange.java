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
public class catalogyLargeChange  extends JFrame implements ActionListener {
	JLabel l1 = new JLabel("�����������޸Ĵ��ࡪ����������");
	
	JLabel l2 = new JLabel("ԭ������:");
	JTextField t2=new JTextField(15);
	
	JLabel l3 = new JLabel("�´�����:");
	JTextField t3 = new JTextField(15);
	JButton b1 = new JButton("����");
    JButton b2 = new JButton("����");
    JButton b3 = new JButton("ȷ��");
    public catalogyLargeChange(){
		super("�޸Ĵ���");
		this.setLayout(new FlowLayout());
       	this.add(l1);
   
       	this.add(l2);
       	this.add(t2);
       	
       	this.add(l3);
       	this.add(t3);
       	
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
		String s1 = t2.getText();
		String s2 = t3.getText();
   	 	if(e.getSource()==b1) {
   	 		this.dispose();
			new catalogyLargeChange();
   	 	}
   	 	else if(e.getSource()==b2) {
   	 		this.dispose();
   	 		new catalogyManage();
   	 	}	
   	 	else {
   	 		if(s1.length()==0||s2.length()==0) {
   	 			JOptionPane.showMessageDialog(this,"�޸�ʧ��! ������������Ϣ��");
   	 			return;
   	 		}
   	 		else {
   	 			JOptionPane.showMessageDialog(this,"�޸ĳɹ�!");
   	 			this.dispose();
   	 			new catalogyManage();
   	 			AdministratorOperation.updateL_Category(s1, s2);
   	 		}
   	 		
   	 	}
	}
}

