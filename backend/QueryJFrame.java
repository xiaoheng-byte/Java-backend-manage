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
      QueryJFrame.setTableFont(jtable);//ִ�����ݲ�ѯ���������
      this.getContentPane().add(new JScrollPane(jtable));//�������񣨰��������ӵ�������ݴ����в�
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



}


