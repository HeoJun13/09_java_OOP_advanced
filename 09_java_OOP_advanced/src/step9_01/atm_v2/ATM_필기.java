package step9_01.atm_v2;

import java.util.Random;
import java.util.Scanner;

import step9_01.atm_v1.UserManager;

public class ATM_필기 {

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	int idnstifier = -1;
	
	void printMainMenu() {
		
		while(true) {
			
			System.out.println("\n [GIGA ATM] ");
			System.out.print("[1.회원가입] [2.로그인] [3.로그아웃] [4.회원탈퇴] [0.종료] :");
			int sel = scan.nextInt();
			
			if (sel == 1) join();
			if (sel == 0) break;
		}
		
		System.out.println("[메세지] 프로그램을 종료합니다");
		
	}
	
	void join() {
		userManager_필기 userManager_필기 = new userManager_필기();
		userManager_필기.addUser1();
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
	

	}

}
