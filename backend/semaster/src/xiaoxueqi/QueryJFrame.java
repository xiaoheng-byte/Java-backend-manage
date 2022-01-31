package xiaoxueqi;

//import QueryJFrame;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import java.sql.*;
import java.util.Enumeration;

public class QueryJFrame extends JFrame
{
	//private Connection conn;                               //数据库连接对象 

//构造方法，driver指定JDBC驱动程序，url指定数据库URL，table指定数据库中表名
public QueryJFrame() 
        
{
    super();
    this.setBounds(300,240,1600,700);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    //Class.forName(driver);                             //指定JDBC驱动程序
    //this.conn=DriverManager.getConnection(url);        //返回数据库连接对象
    JTable jtable1 = AdministratorOperation.selectShopByAttribute("password", "abc123456");
    QueryJFrame.setTableFont(jtable1);
    JTable jtable2 = ShopkeeperOperation.selectProductByAttribute("s_category", "华为手机", "U00001");
    QueryJFrame.setTableFont(jtable2);

    //执行数据查询，创建表格
    this.getContentPane().add(new JScrollPane(jtable2));//滚动窗格（包含表格）添加到框架内容窗格中部
    this.setVisible(true);
}

public static void setTableFont(JTable jtable) {
	  
	  JTableHeader head = jtable.getTableHeader(); // 创建表格标题对象
    head.setPreferredSize(new Dimension(head.getWidth(), 35));// 设置表头大小
    head.setFont(new Font("楷体", Font.PLAIN, 28));// 设置表格字体
    jtable.setRowHeight(30);// 设置表格行
    jtable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// 以下设置表格列宽
   
    jtable.setFont(new Font("楷体", Font.PLAIN, 24));
}

//这个好像用不到
public static void FitTableColumns(JTable myTable){
	  JTableHeader header = myTable.getTableHeader();
	     int rowCount = myTable.getRowCount();
	     Enumeration columns = myTable.getColumnModel().getColumns();
	     while(columns.hasMoreElements()){
	         TableColumn column = (TableColumn)columns.nextElement();
	         int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
	         int width = (int)myTable.getTableHeader().getDefaultRenderer()
	                 .getTableCellRendererComponent(myTable, column.getIdentifier()
	                         , false, false, -1, col).getPreferredSize().getWidth();
	         for(int row = 0; row<rowCount; row++){
	             int preferedWidth = (int)myTable.getCellRenderer(row, col).getTableCellRendererComponent(myTable,
	               myTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
	             width = Math.max(width, preferedWidth);
	         }
	         header.setResizingColumn(column); // 此行很重要
	         column.setWidth(width+myTable.getIntercellSpacing().width);}
	     }

public static void main(String args[]) throws ClassNotFoundException, SQLException
{
    //String driver = "com.mysql.jdbc.Driver";           //指定MySQL JDBC驱动程序
    //String url="jdbc:mysql://127.0.0.1/student?user=root&password=123456";
    new QueryJFrame( );
}

public void finalize() throws SQLException             //析构方法，关闭数据库连接
{
    //this.conn.close();
}

}



