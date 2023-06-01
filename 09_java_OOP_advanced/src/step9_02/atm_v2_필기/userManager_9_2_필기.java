package step9_02.atm_v2_필기;

import java.util.Scanner;

public class userManager_9_2_필기 {
	
	private static final boolean Not = false;
	private userManager_9_2_필기() {}
	static private userManager_9_2_필기 instance = new userManager_9_2_필기();
	static public  userManager_9_2_필기 getInstance() {
		return instance;
		
	}
	Scanner scan = new Scanner(System.in);
	
	final int Acc_Max_CNT = 5;
	User_9_2_필기[] userList = null;
	int userCnt = 0;
	
	void PrintAlluser() {
		
		for (int i = 0; i < userCnt; i++) {
			System.out.print((i+1) + "ID(" + userList[i].id + ")\tPW(" + userList[i].pw + ")");
			if (userList[i].accCnt != 0) {
				for (int j = 0; j < userList[i].accCnt; j++) {
					System.out.print("(" + userList[i].acc[i].accNumber + "/" + userList[i].acc[j].money + ")" );
				}
				System.out.println();
				
			}
		}
		

	}
	
	boolean getCheckAcc(String account ) {
		boolean Not = false;
		for (int i = 0; i < userCnt; i++) {
			for (int j = 0; j < userList[i].accCnt; j++) {
				if (account.equals(userList[i].acc[j].accNumber)) {
					Not = true;
				}
			}
		}
		
		return Not;
		
	}
	
	int logUser() { // 로그인
		
		int identifier = 1;
		
		System.out.println("[로그인]아이디를 입력하세요 : ");
		String id = scan.next();
		System.out.println("[로그인]패스워드를 입력하세요 : ");
		String pw = scan.next();
		
		for (int i = 0; i < userManager_9_2_필기.instance.userCnt; i++) {
			if (userList[i].id.equals(id) && userList[i].pw.equals(pw)) {
				identifier = i;
				
			}
			
		}
		
		return identifier;
		
	}
	
	boolean checkID(String id) { // id 맞는지 아닌지 확인용
		
		boolean Not = false;
		for (int i = 0; i < userCnt; i++) {
			if (userList[i].id.equals(id)) {
				Not = true;
			}
		}
		
		return Not;
		
	}
	
	void joinMember() { // 중복
		
		System.out.println("[로그인]아이디를 입력하세요 : ");
		String id = scan.next();
		System.out.println("[로그인]패스워드를 입력하세요 : ");
		String pw = scan.next();
		
		boolean isResule = checkID(id);
		
		if (isResule) {
			System.out.println("[메세지] 아이디가 중복됩니다.");
			return;
		}
		
		
		if (userCnt == 0) {
			
			
		}
		
		
		
	}
	
	

	public static void main(String[] args) {

	}

}
