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
public class catalogySmallChange  extends JFrame implements ActionListener {
	JLabel l1 = new JLabel("—————修改小类——————");
	
	JLabel l2 = new JLabel("原小类名:");
	JTextField t2=new JTextField(15);
	
	JLabel l3 = new JLabel("新小类名:");
	JTextField t3 = new JTextField(15);
	JButton b1 = new JButton("重置");
    JButton b2 = new JButton("返回");
    JButton b3 = new JButton("确定");
    public catalogySmallChange(){
		super("修改小类");
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
			new catalogySmallChange();
   	 	}
   	 	else if(e.getSource()==b2) {
   	 		this.dispose();
   	 		new catalogyManage();
   	 	}	
   	 	else {
   	 		if(s1.length()==0||s2.length()==0) {
   	 			JOptionPane.showMessageDialog(this,"修改失败! 请输入完整信息！");
   	 			return;
   	 		}
   	 		else {
   	 			
   	 			JOptionPane.showMessageDialog(this,"修改成功!");
   	 			this.dispose();
   	 			new catalogyManage();
   	 			AdministratorOperation.updateS_Category(s1, s2);
   	 		}
   	 		
   	 	}
	}
}

