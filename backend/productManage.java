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

public class productManage extends JFrame implements ActionListener{
	JLabel l1 = new JLabel("————————————商品管理———————————");
	JButton b1 = new JButton("已有商品改动");
	JButton b2 = new JButton("增加商品");
	JButton b3 = new JButton("删除商品");
	JButton b4 = new JButton("查找商品");
	JButton b5 = new JButton("返回上一级");
	public productManage(){
		super("商品管理"); 		
		this.setLayout(new FlowLayout());
  		this.add(l1);
   		this.add(b1);
   		this.add(b2);	
   		this.add(b3);
   		this.add(b4);
   		this.add(b5);
   		this.setLayout(null);
   		this.setSize(400,400);
    	l1.setBounds(20,20,350,30);
    	b1.setBounds(90,60,220,30);
    	b2.setBounds(90,110,220,30);
    	b3.setBounds(90,160,220,30);
    	b4.setBounds(90,210,220,30);
    	b5.setBounds(90,260,220,30);
    	GUIUtil.toCenter(this);
   		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setResizable(false);
    	this.setVisible(true);
    	b1.addActionListener(this);
    	b2.addActionListener(this);
    	b3.addActionListener(this);
    	b4.addActionListener(this);
    	b5.addActionListener(this);
    	
 	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b1){	
			this.dispose();
			new productRevise();
		}
		else if(e.getSource()==b2){
			this.dispose();
			new productAdd();
			
		}
		else if(e.getSource()==b3){
			this.dispose();
			new productDele();
		}
		else if(e.getSource()==b4){						
			this.dispose();
			new productSearch();
		}
		else {
			this.dispose();
			new OperationSKFrame();
		}
			
	}
}	

