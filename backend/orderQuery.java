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

public class orderQuery extends JFrame implements ActionListener{
	JLabel l1 = new JLabel("������������������������������ѯ����������������������");
	JButton b1 = new JButton("ĳʱ������ж��������ܽ��");
	JButton b2 = new JButton("ĳ����Ʒ�Ķ��������ܽ��");
	JButton b3 = new JButton("ĳʱ�����ǰʮ��������Ʒ");
	JButton b4 = new JButton("�����̶�ǰʮ����Ʒ");
	JButton b5 = new JButton("������ǰʮ����Ʒ");
	JButton b6 = new JButton("������һ��");
	public orderQuery(){
		super("������ѯ"); 		
		this.setLayout(new FlowLayout());
  		this.add(l1);
   		this.add(b1);
   		this.add(b2);	
   		this.add(b3);
   		this.add(b4);
   		this.add(b5);
   		this.add(b6);
   		this.setLayout(null);
   		this.setSize(400,400);
    	l1.setBounds(20,20,350,30);
    	b1.setBounds(90,50,220,30);
    	b2.setBounds(90,100,220,30);
    	b3.setBounds(90,150,220,30);
    	b4.setBounds(90,200,220,30);
    	b5.setBounds(90,250,220,30);
    	b6.setBounds(90,300,220,30);
    	GUIUtil.toCenter(this);
   		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setResizable(false);
    	this.setVisible(true);
    	b1.addActionListener(this);
    	b2.addActionListener(this);
    	b3.addActionListener(this);
    	b4.addActionListener(this);
    	b5.addActionListener(this);
    	b6.addActionListener(this);
    	
 	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b1){	
			this.dispose();
			new orderQueryTime1();
		}
		else if(e.getSource()==b2){
			this.dispose();
			new orderQueryCatalogy2();
			
		}
		else if(e.getSource()==b3){
			this.dispose();
			new orderQueryTop10_3();
		}
		else if(e.getSource()==b4){						
			this.dispose();
			new orderQuery();
			new QueryJFrame(ShopkeeperOperation.selectMostPopularProduct(LoginJudge.user_id));
		}
		else if(e.getSource()==b5){
			this.dispose();
			new orderQuery();
			new QueryJFrame(ShopkeeperOperation.selectBestScoreProduct(LoginJudge.user_id));
			
		}
		else {
			this.dispose();
			new orderManage();
		}
			
	}
}	

