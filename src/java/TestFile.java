import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TestFile {
	
	public static void main(String[] args) {
		try {
			//输出文件路径
			File src = new File("E:/银行间/InnerTools_v2.0_buyside_ByLxq/InnerTools_v2.0_buyside_ByLxq/inpout/sql1.sql");
			//输入文件路径
			String cont = TestFile.read("E:/银行间/InnerTools_v2.0_buyside_ByLxq/InnerTools_v2.0_buyside_ByLxq/inpout/sql.sql");
			Map<String,String> mapData = new HashMap<>();//键为需要替换的值，值为替换后的值
			mapData.put("`", " ");
			mapData.put("decimal", "number");
			mapData.put("bigint", "number");
			mapData.put("int", "number");
			mapData.put("varchar", "varchar2");
			mapData.put("NOT NULL", " ");
			mapData.put("DEFAULT NULL", " ");
			mapData.put("DEFAULT '-1'", " ");
			mapData.put("DEFAULT '0'", " ");
			mapData.put("DEFAULT '1'", " ");
			mapData.put("DEFAULT '4'", " ");
			mapData.put("DEFAULT '0.2000'", " ");
			mapData.put("DEFAULT '100.0000'", " ");
			mapData.put("DEFAULT 'RMB'", " ");
			mapData.put("DEFAULT 'AUTO'", " ");
			mapData.put("DEFAULT '0.00'", " ");
			mapData.put("DEFAULT '0.000'", " ");
			mapData.put("DEFAULT '0.0000'", " ");
			mapData.put("DEFAULT '0.00000'", " ");
			mapData.put("DEFAULT '0.000000'", " ");
			mapData.put("DEFAULT '0.00000000'", " ");
			mapData.put("bignumber", "number");
			String str = replactStringType(cont,mapData);
			TestFile.write(str, src);
			System.out.println("生成SQL脚本成功");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static String replactStringType(String cont, Map<String, String> mapData) {
		for(String key:mapData.keySet()) {
			cont = cont.replaceAll(key, mapData.get(key));
		}
		return cont;
	}

	public static  String read(String path) {
		StringBuffer res = new StringBuffer();
        String line = null;
		try {
			 BufferedReader reader = new BufferedReader(new InputStreamReader( new FileInputStream(path), "UTF-8"));
			 while ((line = reader.readLine()) != null) {
		            res.append(line + "\n");
             }
			 reader.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res.toString();
		
	}
	public static String readFor(String path,int num,int size) {
		StringBuffer res = new StringBuffer();
        String line = null;
        int sum = 0;
        int start = (num-1) * size + 1;
        int y =0;
        
        try {
        	BufferedReader reader = new BufferedReader(new InputStreamReader( new FileInputStream(path), "UTF-8"));
        	while ((line = reader.readLine()) != null) {
        		 sum += 1;
                 if(sum == start){
                	 sum -= 1;
                     if(y < size){
                         res.append(line + ",");
                         y+=1;
                     }else{
                         break;
                     }
                 }
        	}
        	reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return res.toString();
	}
	
	public static boolean write(String cont, File dist) {
		try {
			 BufferedWriter writer = new BufferedWriter(new FileWriter(dist));
	         writer.write(cont);
	         writer.flush();
	         writer.close();
	           return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
	          return false;
		}
	}

}
