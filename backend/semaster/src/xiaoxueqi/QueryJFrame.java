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
	//private Connection conn;                               //���ݿ����Ӷ��� 

//���췽����driverָ��JDBC��������urlָ�����ݿ�URL��tableָ�����ݿ��б���
public QueryJFrame() 
        
{
    super();
    this.setBounds(300,240,1600,700);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    //Class.forName(driver);                             //ָ��JDBC��������
    //this.conn=DriverManager.getConnection(url);        //�������ݿ����Ӷ���
    JTable jtable1 = AdministratorOperation.selectShopByAttribute("password", "abc123456");
    QueryJFrame.setTableFont(jtable1);
    JTable jtable2 = ShopkeeperOperation.selectProductByAttribute("s_category", "��Ϊ�ֻ�", "U00001");
    QueryJFrame.setTableFont(jtable2);

    //ִ�����ݲ�ѯ���������
    this.getContentPane().add(new JScrollPane(jtable2));//�������񣨰��������ӵ�������ݴ����в�
    this.setVisible(true);
}

public static void setTableFont(JTable jtable) {
	  
	  JTableHeader head = jtable.getTableHeader(); // �������������
    head.setPreferredSize(new Dimension(head.getWidth(), 35));// ���ñ�ͷ��С
    head.setFont(new Font("����", Font.PLAIN, 28));// ���ñ������
    jtable.setRowHeight(30);// ���ñ����
    jtable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// �������ñ���п�
   
    jtable.setFont(new Font("����", Font.PLAIN, 24));
}

//��������ò���
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
	         header.setResizingColumn(column); // ���к���Ҫ
	         column.setWidth(width+myTable.getIntercellSpacing().width);}
	     }

public static void main(String args[]) throws ClassNotFoundException, SQLException
{
    //String driver = "com.mysql.jdbc.Driver";           //ָ��MySQL JDBC��������
    //String url="jdbc:mysql://127.0.0.1/student?user=root&password=123456";
    new QueryJFrame( );
}

public void finalize() throws SQLException             //�����������ر����ݿ�����
{
    //this.conn.close();
}

}



