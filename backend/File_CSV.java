package xiaoxueqi;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 * 读取csv文件
 */
public class File_CSV {
	public static void addCloumn(List<String> pList, String filePath) throws IOException{
		BufferedReader bufReader = new BufferedReader(new FileReader(filePath));
		String lineStr = "";
		int rowNumber = 0;//读到第几行
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
        // 设定UTF-8字符集，使用带缓冲区的字符输入流BufferedReader读取文件内容
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
        file.readLine(); //跳过表头所在的行
        
        // 遍历数据行并存储在名为records的ArrayList中，每一行records中存储的对象为一个String数组
        while ((line = file.readLine()) != null) {
            String word[] = line.split(",");//word是每一行被逗号分割后的一组string（是数组）
            records.add(word);//每一行内容以数组的形式加入list
        }
        // 关闭文件
        file.close();
        // 将存储测试数据的List转换为一个Object的二维数组
        String[][] results = new String[records.size()][];
        // 设置二位数组每行的值，每行是一个Object对象
        for (int i = 0; i < records.size(); i++) {
            results[i] = (String[]) records.get(i);
        }
        return results;
    }
}