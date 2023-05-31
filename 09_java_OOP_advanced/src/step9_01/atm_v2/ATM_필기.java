package step9_01.atm_v2;

import java.util.Random;
import java.util.Scanner;

import step9_01.atm_v1.UserManager;

public class ATM_필기 {

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	int idnstifier = -1;
	userManager_필기 userManager_필기 = new userManager_필기();
	void printMainMenu() {
		
		while(true) {
			
			System.out.println("\n [GIGA ATM] ");
			System.out.print("[1.회원가입] [2.로그인] [3.로그아웃] [4.회원탈퇴] [0.종료] :");
			int sel = scan.nextInt();
			
			if (sel == 1)    	join();
			else if (sel == 2)  login();
			else if (sel == 3) 	logout();
			else if (sel == 4) 	leave();
			else if (sel == 0) break;
		}
		
		System.out.println("[메세지] 프로그램을 종료합니다");
		
	}
	
	void join() {
		userManager_필기.addUser1();
		
	
	}
	
	void login () {
		
		idnstifier = userManager_필기.logUser();
		
		if (idnstifier != -1) {
			printMainMenu1();
		}
		else {
			System.out.println("[메세지] 로그인실패.");
		}
		
		
	}
	void logout () {
		
		if (idnstifier == -1) {
			System.out.println("[메세지] 로그인을 하신 후 이용이 가능합니다");
			
		}
		else {
			System.out.println("로그아웃이 되었습니다.");
		}
	}
	
	void leave () {
		userManager_필기.leave();
		
	}
	
	void printMainMenu1 () {
		
		while (true) {
			
			System.out.print("[1.계좌생성] [2.계좌삭제] [3.조회] [0.로그아웃] : ");
			int sel = scan.nextInt();
			
			String makeAccount = Integer.toString(ran.nextInt(80021)+20000);
			
			if (sel == 1) {
				
				if (userManager_필기.user[idnstifier].accCount == 0) {
					userManager_필기.user[idnstifier].acc = new Account_필기[1];
					
					userManager_필기.user[idnstifier].acc[0] = new Account_필기();
					userManager_필기.user[idnstifier].acc[0].number = makeAccount;
				}
				else {
					Account_필기[] temp = userManager_필기.getUser(idnstifier).acc;
					int tempAcc = userManager_필기.getUser(idnstifier).accCount;
					userManager_필기.user[idnstifier].acc = new Account_필기[tempAcc+1];
					for (int i = 0; i < tempAcc; i++) {
						userManager_필기.user[idnstifier].acc[i] = temp[i];
					}
					userManager_필기.user[idnstifier].acc[tempAcc] = new Account_필기();
					userManager_필기.user[idnstifier].acc[tempAcc].number = makeAccount;
					
				}
				userManager_필기.user[idnstifier].accCount++;
				System.out.println("[메시지]'"+makeAccount +"'계좌가 생성되었습니다.\n");
			
			}
			else if(sel == 2) {
				
				if (userManager_필기.user[idnstifier].accCount == 0) {
					System.out.println("[메세지] 더 이상 삭제할 수 없습니다.");
					continue;
				}
				if (userManager_필기.user[idnstifier].accCount == 1) {
					System.out.println("[메세지] 계좌번호 : " + userManager_필기.user[idnstifier].acc[0].number+ "삭제 되었습니다");
					userManager_필기.user[idnstifier].acc = null;	
				}
				else {
					System.out.println("삭제 하고 싶은 계좌 번호를 입력하세요");
					String deletAccCount = scan.next();
					int tempAccCount = userManager_필기.user[idnstifier].accCount;
					int delIdx = -1;
					for (int i = 0; i < tempAccCount; i++) {
						if (deletAccCount.equals(userManager_필기.user[idnstifier].acc[i].number)) {
							delIdx = i;
							
						}
					}
					if (delIdx == -1) {
						System.out.println("[메세지] 계좌번호를 확인해주세요.");
						continue;
					}
					else {
						System.out.println("[메세지] 계좌번호 :" + userManager_필기.user[idnstifier].acc[delIdx].number + "삭제 되었습니다.");
						
						Account_필기[] temp = userManager_필기.user[idnstifier].acc;
						userManager_필기.user[idnstifier].acc = new Account_필기[tempAccCount -1];
						
						for (int i = 0; i < delIdx; i++) {
							userManager_필기.user[idnstifier].acc[i] = temp[i];
						}
						for (int i = 0; i < tempAccCount - 1; i++) {
							userManager_필기.user[idnstifier].acc[i] = temp[i+1];
						}
											
					}
				}
				userManager_필기.user[idnstifier].accCount--;
					
				}
			else if (sel == 3) {
				
				if (userManager_필기.user[idnstifier].accCount == 0) {
					System.out.println("[메세지] 생성된 계좌가 없습니다.");
					
				}
				else {
					userManager_필기.user[idnstifier].PringAccount();
				}
		
				
			}
			else if (sel == 0) {
				logout();
				break;
			}
			
		}
			
	}
}
	

		
		
