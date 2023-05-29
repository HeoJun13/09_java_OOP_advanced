package step9_01.atm_v1;

import java.util.Iterator;
import java.util.Scanner;

public class userManager_필기 {

		
		Scanner scan = new Scanner(System.in);
		
		User[] user = null;
		int userCount = 0;
		
		void printAllUser () {
			for (int i = 0; i < user.length; i++) {
				user[i].printAccount();
			}
		}
		
		
		void addUser() {
			
			if (userCount == 0) {
				
				user = new User[1];
				
				System.out.println("[가입] 아이디를 입력하세요 : ");
				String id = scan.next();
				
				user[userCount] = new User();
				user[userCount].id = id;
				System.out.println("[메세지] ID : " + id + "가입 되었습니다");
				
			}
			else {
				
				System.out.println("[가입] 아이디를 입력하세요 : ");
				String id = scan.next();
				
				boolean Not = false;
				for (int i = 0; i < userCount; i++) {
					if (user[i].id.equals(id)) {
						Not = true;
					}
				}
				
				if (!Not) {
					
				User[] temp = user;
				user = new User[userCount+1];
				for (int i = 0; i < userCount; i++) {
					user[i] = temp[i];
				}
				temp = null;
				
				user[userCount] = new User();
				user[userCount].id = id;
				System.out.println("[메세지] ID : " +id + " 가입 되었습니다.");
					
				}
				else {
					System.out.println("[메세지] " + id + "이미 가입된 아이디 입니다." );
				}
				
				
			}
		}
		
		

		public static void main(String[] args) {
	}

}
