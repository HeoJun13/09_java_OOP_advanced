package step9_03.atm_필기;

// 2023/06/08 while문 까먹지말고 작성

import java.util.Scanner;

public class ATM2 {
	
	Scanner scan = new Scanner(System.in);

	void ShowMain() {
		
		while(true) {
			
			System.out.println("[CVG ATM]");
			System.out.println("[1.회원가입], [2.로그인], [0.종료]");
			System.out.println("[메세지] 메뉴 선택: ");
			int sel = scan.nextInt();
			
			if		(sel == 1) join();
			else if (sel == 2) login();
			else if (sel == 3) break;
			
		}
	}
		


	void join() {
		userManager2.getInstance().joinManager();
		
	
	}

	void login() {
		userManager2.getInstance().loginManger();
	
	}


}

