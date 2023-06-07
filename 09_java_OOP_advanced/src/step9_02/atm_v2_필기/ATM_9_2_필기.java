package step9_02.atm_v2_필기;

import java.util.Scanner;


public class ATM_9_2_필기 {
	
	Scanner scan = new Scanner(System.in);
	int identifier = -1;
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
		identifier = um.logUser();
		if (identifier != -1) loginMeue();
		else {
			System.out.println("[메세지] 아이디와 패스워드를 확인해주세요");
	}
	}
	
	void loginMeue() {
		
		
		while (true) {
			
			System.out.println(" [" + um.userList[identifier].id + " 님 환영합니다");
			System.out.println("[1.계정생성],[2.계정삭제],[3.조희],[4.탈퇴],[0.로그아웃],");
			System.out.print("메뉴선택 : ");
			int Menu = scan.nextInt();
			
			if(Menu == 1 ) {
				AccountManager2.getIntance().creatAcc(identifier);
				FileManager2.getInstance().save();
				
			}
			else if(Menu == 2 ) {
				
			}
			else if(Menu == 3 ) {
				AccountManager2.getIntance().printAcc(identifier);
			}
			else if(Menu == 4 ) {
				identifier = um.deleteUser(identifier);
			break;
			}
			else if(Menu == 0 ) {
				identifier = -1;
				System.out.println("로그아웃 되었습니다.");
			}
		
			
			
			
		}
		
		
	}

	
	public static void main(String[] args) {

	}

}
