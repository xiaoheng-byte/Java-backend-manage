5package xiaoxueqi;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class catalogyManage extends JFrame implements ActionListener {
	JLabel t1 = new JLabel("——————————你要重命名的是——————————");
	JRadioButton large = new JRadioButton("大类");
	JRadioButton medium = new JRadioButton("中类");
	JRadioButton small = new JRadioButton("小类");
    JButton b1 = new JButton("返回上一级");
 
	public catalogyManage(){
		super("类别管理");
		this.setLayout(new FlowLayout());
		this.add(t1);
		this.add(large);
		this.add(medium);
		this.add(small);
		this.add(b1);
		this.setSize(400,400);
		this.setLayout(null);
		t1.setBounds(20,20,350,30);
    	large.setBounds(100,80,200,30);
    	medium.setBounds(100,130,200,30);
    	small.setBounds(100,180,200,30);
    	b1.setBounds(100,280,200,30);
		GUIUtil.toCenter(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		large.addActionListener(this);
   		medium.addActionListener(this);
   		small.addActionListener(this);
   		b1.addActionListener(this);
   		
   		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==large){	
			this.dispose();
			new catalogyLargeChange();
		}
		else if(e.getSource()==medium){
			this.dispose();
			new catalogyMediumChange();
			
		}
		else if(e.getSource()==small){
			this.dispose();
			new catalogySmallChange();
		}
		else  {
			this.dispose();
			new OperationADFrame();
		}
			
	}
}	



