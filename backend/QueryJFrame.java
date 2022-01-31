package xiaoxueqi;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import java.sql.*;
import java.util.Enumeration;

public class QueryJFrame extends JFrame
{                     
	JTable jtable;
	public QueryJFrame(JTable jtable) {
      super();
      this.setBounds(300,240,1600,700);
      QueryJFrame.setTableFont(jtable);//执行数据查询，创建表格
      this.getContentPane().add(new JScrollPane(jtable));//滚动窗格（包含表格）添加到框架内容窗格中部
      this.setVisible(true);
    }
  
  public static void setTableFont(JTable jtable) {
	  
	  JTableHeader head = jtable.getTableHeader(); // 创建表格标题对象
      head.setPreferredSize(new Dimension(head.getWidth(), 35));// 设置表头大小
      head.setFont(new Font("黑体", Font.PLAIN, 28));// 设置表格字体
      jtable.setRowHeight(30);// 设置表格行
      jtable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// 以下设置表格列宽
     
      jtable.setFont(new Font("黑体", Font.PLAIN, 24));
  }



}


