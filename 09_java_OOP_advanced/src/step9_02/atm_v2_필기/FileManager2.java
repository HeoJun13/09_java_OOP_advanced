package step9_02.atm_v2_필기;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager2 {
	
	private FileManager2() {}
	private static FileManager2 instance = new FileManager2();
	public  static FileManager2 getInstance() {
		return instance;
		
	}
	
	String FileName = "ATM.txt";
	String data = "";
	userManager_9_2_필기 um  = userManager_9_2_필기.getInstance();
	
	void setData() {
		
		data = "";
		int userCount = um.userCnt;
		data += userCount;
		data += "\n";
		
		for (int i = 0; i < userCount; i++) {
			data += um.userList[i].id;
			data += "\n";
			data += um.userList[i].pw;			
			data += "\n";
			data += um.userList[i].accCnt;
			data += "\n";
			
			if (um.userList[i].accCnt == 0) {
				data += "\n";
			}
			else {
				for (int j = 0; j < um.userList[i].accCnt; j++) {
					data += um.userList[i].acc[j].accNumber;
					data += "/";
					data += um.userList[i].acc[j].money;
					if (j != um.userList[i].accCnt - 1) {
						data += ",";
					}
				}
			}
		}
	}
	
	void save() {
		
		setData();
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(FileName);
			fw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	void load() {
		
		File file = new File(FileName);
		FileReader fr = null;
		BufferedReader br = null;
		
			if (file.exists()) {
				
				try {
					fr = new FileReader(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				br = new BufferedReader(fr);
				while (true) {
					try {
						String line = br.readLine();
						if (line == null)
							break;
					}
					
					catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				
			}
			
}

	public static void main(String[] args) {

	}

}
