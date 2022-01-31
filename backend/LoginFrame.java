package xiaoxueqi;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

public class LoginFrame extends JFrame implements ActionListener{
	JLabel l1 = new JLabel("———————亲，请输入信息后登录！———————");
	JLabel l2 = new JLabel("请输入用户名：");
	JTextField tfAccount=new JTextField(20);
	JLabel l3 = new JLabel("请输入密码： ");
	JPasswordField pfPassword=new JPasswordField(20);
	JButton b = new JButton("重置");
	JButton btLogin = new JButton("登录");
	Font font1 = new Font("Helvetica",Font.PLAIN,14);
	public LoginFrame(){
		super("登录");
		this.setLayout(new FlowLayout());
      		this.add(l1);
       		this.add(l2);this.add(tfAccount);
       		this.add(l3);this.add(pfPassword);
       		this.add(b);
       		this.add(btLogin);	
       		l1.setPreferredSize(new Dimension(350,80));
       		l1.setFont(font1);
    		l2.setPreferredSize(new Dimension(100,50));
    		l3.setPreferredSize(new Dimension(100,60));
    		b.setPreferredSize(new Dimension(120,30));
    		btLogin.setPreferredSize(new Dimension(120,30));
        	this.setSize(400,400);
        	GUIUtil.toCenter(this);
       		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	this.setResizable(false);
        	this.setVisible(true);
        	btLogin.addActionListener(this);
        	b.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
   	 	if(e.getSource()==btLogin) {
      			String account=tfAccount.getText();
       			String password=new String(pfPassword.getPassword());
       			//FileOpe.getInfoByAccount(account);
       			if(account.length() ==0||password.length() ==0) {
       				JOptionPane.showMessageDialog(this,"登录失败! 请输入完整信息！");
       				return;
       			}
       			int loginJudge = LoginJudge.loginJudge(account, password);
       			if(account==null) {
           				JOptionPane.showMessageDialog(this,"登录失败！密码错误或无该用户！");
           				return;
       			 }
       			
        			
		if(loginJudge == 2) {
		//	setShopkeeper_id(account);
			JOptionPane.showMessageDialog(this,"登录成功");
			System.out.println(loginJudge);
			new OperationSKFrame();
			this.dispose();
		}
			
		else if(loginJudge == 3) {
			JOptionPane.showMessageDialog(this,"登录成功");
		System.out.println(loginJudge);
			new OperationADFrame();
			this.dispose();
    	}
		}
    		if(e.getSource()==b) {
       			this.dispose();
       			new LoginFrame();
   		}
   		
}
}
