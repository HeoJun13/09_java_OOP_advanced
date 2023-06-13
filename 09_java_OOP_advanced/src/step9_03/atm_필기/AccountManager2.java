package step9_03.atm_필기;

import java.security.Identity;
import java.util.Random;
import java.util.Scanner;

public class AccountManager2 {
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	
	private AccountManager2() {}
	private static AccountManager2 Instance = new AccountManager2();
	public static AccountManager2 getInstance() {
		return Instance;
		
	}
	
	void CreatAccount() {
		
		User2 logUser2 = userManager2.getInstance().userList[userManager2.getInstance().identifier];
		
		if (logUser2.accCount == 4) {
			System.out.println("[메세지] 더이상 계좌를 만들수없습니다.");
			return;
		}
		if (logUser2.accCount == 0) {
			logUser2.accList = new Account2[logUser2.accCount + 1];
		}
		else if (logUser2.accCount > 0) {
			Account2[] temp = logUser2.accList;
			
			logUser2.accList = new Account2[logUser2.accCount + 1];
			for (int i = 0; i < logUser2.accCount; i++) {
				logUser2.accList[i] = temp[i];
			}
			temp = null;
		}
		logUser2.accList[logUser2.accCount] = new Account2();
		
		String MakeAccount = ran.nextInt(1002050000)+500000 + "";
		logUser2.accList[logUser2.accCount].number = MakeAccount;
		logUser2.accList[logUser2.accCount].money = 0;
		
		logUser2.accCount++;
		System.out.println("[메세지] 계좌번호" +MakeAccount+ " 생성되었습니다.");
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
