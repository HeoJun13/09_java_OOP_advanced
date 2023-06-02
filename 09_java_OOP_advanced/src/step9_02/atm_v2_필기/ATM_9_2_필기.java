package step9_02.atm_v2_필기;

import java.util.Scanner;

public class ATM_9_2_필기 {
	
	Scanner scan = new Scanner(System.in);
	int indentifier = -1;
	userManager_9_2_필기 um = userManager_9_2_필기.getInstance();
	
	void play() {
		
		FileManager2.getInstance().load();
		userManager_9_2_필기.getInstance().PrintAlluser();
		
		while(true) {
			
			System.out.println("[ABC ATM]");
			System.out.println("[1.회원가입]\n[2.로그인]\n[0.종료]");
			System.out.print("메뉴 선택 :");
			int sel = scan.nextInt();
			
			if		(sel == 1)  join();
			else if (sel == 2)  login();  
			else if (sel == 0)  break;
		}
	}
	
	
	void join () {
		userManager_9_2_필기.getInstance().joinMember();
	}
	
	void login () {
		indentifier = um.logUser();
		if (indentifier != -1) loginMeue();
		else {
			System.out.println("[메세지] 아이디와 패스워드를 확인해주세요");
	}
	}
	
	void loginMeue() {
		
		
		while (true) {
			
			System.out.println(" [" + um.userList[indentifier].id + " 님 환영합니다");
			System.out.println();
			
			
		}
		
		
	}

	
	public static void main(String[] args) {

	}

}
