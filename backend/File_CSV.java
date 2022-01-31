package xiaoxueqi;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 * ��ȡcsv�ļ�
 */
public class File_CSV {
	public static void addCloumn(List<String> pList, String filePath) throws IOException{
		BufferedReader bufReader = new BufferedReader(new FileReader(filePath));
		String lineStr = "";
		int rowNumber = 0;//�����ڼ���
		StringBuffer nContent = new StringBuffer();
		while((lineStr = bufReader.readLine()) != null){
			String addValue = "";
			if(rowNumber < pList.size()){
				addValue = pList.get(rowNumber);
			}
			if(lineStr.endsWith(",")){
				nContent.append(lineStr).append("\""+addValue+"\"");
			}
			else{
				nContent.append(lineStr).append(",\""+addValue+"\"");
			}
			rowNumber++;
			nContent.append("\r\n");
		}
		bufReader.close();

		FileOutputStream fileOs = new FileOutputStream(new File(filePath), false);
		fileOs.write(nContent.toString().getBytes());
		fileOs.close();
	}
	
	
    public static String[][] getData(String fileName) throws IOException {
        List<String[]> records = new ArrayList<String[]>();
        String line;
        // �趨UTF-8�ַ�����ʹ�ô����������ַ�������BufferedReader��ȡ�ļ�����
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
        file.readLine(); //������ͷ���ڵ���
        
        // ���������в��洢����Ϊrecords��ArrayList�У�ÿһ��records�д洢�Ķ���Ϊһ��String����
        while ((line = file.readLine()) != null) {
            String word[] = line.split(",");//word��ÿһ�б����ŷָ���һ��string�������飩
            records.add(word);//ÿһ���������������ʽ����list
        }
        // �ر��ļ�
        file.close();
        // ���洢�������ݵ�Listת��Ϊһ��Object�Ķ�ά����
        String[][] results = new String[records.size()][];
        // ���ö�λ����ÿ�е�ֵ��ÿ����һ��Object����
        for (int i = 0; i < records.size(); i++) {
            results[i] = (String[]) records.get(i);
        }
        return results;
    }
}