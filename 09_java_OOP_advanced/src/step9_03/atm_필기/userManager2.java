package step9_03.atm_필기;

// 6/9일 새벽 2:55분 로그인,회원가입 메니저 메서드 생성.

import java.util.Random;
import java.util.Scanner;

public class userManager2 {
	
	private userManager2 () {}
	private static userManager2 instance = new userManager2();
	public static userManager2 getInstance() {
		return instance;
		}
	
	User2[] userList;
	int userCount;
	int identifier = -1;
	
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	
	void loginManger() {
		
		System.out.println("[로그인] 아이디입력 :");
		String id = scan.next();
		System.out.println("[로그인] 비밀번호 입력 :");
		String pw = scan.next();
		
		for (int i = 0; i < userCount ; i++) {
			if (userList[i].id.equals(id) && userList[i].password.equals(pw)) {
				identifier = i;
				
			}
			else if (userCount == -1) {
				System.out.println("아이디 와 비번을 다시 확인해주새요.");
			}
			else {
				System.out.println("[메세지] " + id + "님 환영합니다 " );
			}
		}
		
	}
	
	void joinManager () {
		
		System.out.println("회원가입] 아이디를 입력 :");
		String id = scan.next();
		
		int checkID = checkID(id);
		if (checkID == -1) {
			System.out.println("메세지] 아이디가 중복입니다.");
			return;
		}
		System.out.println("[회원가입] 비밀번호 입력 :");
		String pw = scan.next();
		
		if (userCount == 0) {
			userList = new User2[1];
			userList[0] = new User2(id , pw);
			
		}
		
	}
	
	
	
	
	

	private int checkID(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {

	}

}
