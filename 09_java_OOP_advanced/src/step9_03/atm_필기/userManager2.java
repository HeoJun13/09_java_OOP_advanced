package step9_03.atm_필기;

import java.util.Iterator;

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
		}
		if (userCount == -1) {
			System.out.println("아이디 와 비번을 다시 확인해주새요.");
		}
		else {
			System.out.println("[메세지] " + id + "님 환영합니다 " );
			AfterMenu();
		}
		
	}
	
	void joinManager () {
		
		System.out.println("[회원가입] 아이디를 입력 :");
		String id = scan.next();
		
		int checkID = checkID(id);
		if (checkID != -1) {
			System.out.println("[메세지] 아이디가 중복입니다.");
			return;
		}
		System.out.println("[회원가입] 비밀번호 입력 :");
		String pw = scan.next();
		
		if (userCount == 0) {
			userList = new User2[1];
			userList[0] = new User2(id , pw);
			
		}
		else if (userCount == -1) {
			User2[] temp = userList;
			
			userList = new User2[userCount + 1];
			for (int i = 0; i < userCount; i++) {
				userList[i]=temp[i];
			}
			userList[0] = new User2(id , pw);
			
			
		}
		userCount++;
		System.out.println("[메세지] " + id + "님 회원가입을 축하합니다.");
		
	}

	private int checkID(String id) {
		
		int check = -1;
		for (int i = 0; i < userCount; i++) {
			if (userList[i].id.equals(id)) {
				check = i;
			}
			
		}
		return check;
	}
	
	void AfterMenu() {
		
		while (true) {
			
			System.out.println("[1]계정생성, [2]입금하기, [3]출금하기 , [4]이체하기 , [5]계좌조회" + 
			 "[6]계좌삭제 , [7]회원탈퇴 , [0]뒤로가기");
			System.out.println("[메세지] 메뉴선택 : ");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				AccountManager2.getInstance().CreatAccount();
			}
			else if (sel == 1) {}
			else if (sel == 2) {}
			else if (sel == 3) {}
			else if (sel == 4) {}
			else if (sel == 5) {}
			else if (sel == 6) {}
			else if (sel == 7) {}
			else if (sel == 0) {}
			
			
		}
		
	}

	public static void main(String[] args) {

	}

}
