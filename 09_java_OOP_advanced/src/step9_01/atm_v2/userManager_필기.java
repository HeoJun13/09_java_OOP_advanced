package step9_01.atm_v2;

import java.util.Iterator;
import java.util.Scanner;

import step9_01.atm_v1.User;

public class userManager_필기 {
	
		Scanner scan = new Scanner(System.in);
		User_필기[] user = null;
		int userCount = 0;
		
		void PrintAlluser() {
			for (int i = 0; i < userCount; i++) {
				user[i].PringAccount();
			}
		}
		
		void addUser1() {
			
			if(userCount == 0) {
				
				user = new User_필기[1];
				
				System.out.println("[가입] 아이디를 입력하세요 : ");
				String id =scan.next();
				
				user[userCount] = new User_필기();
				user[userCount].id = id;
				System.out.println("[메세지] ID : " + id + " 가입 되었습니다. ");
				userCount++;
				
			}
			else {
				
				System.out.println("[가입] 아이디를 입력하세요 : ");
				String id = scan.next();
				
				boolean not = false;
				for (int i = 0; i < userCount; i++) {
					if (user[i].id.equals(id)) {
						not = true;
					}
				}
				
				if (!not) {
					
					User_필기[] temp = user;
					user = new User_필기[userCount +1];
					for (int i = 0; i < userCount; i++) {
						user[i] = temp[i];
					}
					temp = null;
					
					user[userCount] = new User_필기();
					user[userCount].id = id;
					System.out.println("[메세지] ID : " + id + "가입 되었습니다.");
					userCount++;
					
				}
				else {
					System.out.println("[메세지] ID : " + id + "이미 가입된 ID 입니다.");
				}
			}
			
			
		}
		
		User_필기 getUser(int idx) {
			return user[idx];
			
		}
		
		int logUser() {
			
			int identifier = -1;
			System.out.print("[입력] 아이디를 입력하세요 :");
			String id = scan.next();
			
		 for (int i = 0; i < userCount; i++) {
			 if (id.equals(user[i].id)) {
				 identifier = i;
				 System.out.println("[" + user[identifier].id +"] 님 로그인.");
			 }
			
		}
		 
		 return identifier;
			
	}
		void leave() {
			
			System.out.println("[입력] 탈퇴할 아이디를 입력해주세요 :");
			String name = scan.next();
			int identifier = -1;
			for (int i = 0; i < userCount; i++) {
				if (name.equals(user[i].id)) {
					identifier = i;
				}
				
			}
			if (identifier == -1) {
				System.out.println("[메세지] 아이디를 다시 확인하세요.");
				return;
			}
			System.out.println(" ID : " + user[identifier].id + "가 탈퇴되었습니다.");
			
			User_필기[] temp = user;
			user = new User_필기[userCount - 1];
			
			for (int i = 0; i < identifier; i++) {
				user[i] = temp[i];
				
			}
			for (int i = identifier; i < userCount-1; i++) {
				user[i] = temp[i + 1];
				
			}
			
			userCount--;
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		public static void main(String[] args) {
	}

}
