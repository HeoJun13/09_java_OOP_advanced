package step9_03.atm_필기;

import java.security.Identity;
import java.util.Iterator;
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
		
		String MakeAccount = ran.nextInt(8456367)+500000 + "";
		logUser2.accList[logUser2.accCount].number = MakeAccount;
		logUser2.accList[logUser2.accCount].money = 0;
		
		logUser2.accCount++;
		System.out.println("[메세지] 계좌번호" +MakeAccount+ " 생성되었습니다.");
		
	}
	
	int ShowAccount(String msg) {
		int loginCheck = -1;
		
		User2 logUser2 = userManager2.getInstance().userList[userManager2.getInstance().identifier];
		
		if (logUser2.accCount > 0) {
			for (int i = 0; i < logUser2.accCount; i++) {
				System.out.println("[" + i+1 + "]" + logUser2.accList[i].number);
			}
			
			System.out.println("[" + msg + "] 계좌를 선택해주세요." );
			loginCheck = scan.nextInt();
			loginCheck--;
		}
		return loginCheck;
	}
	
	void AccountDeposit () {
		int Deposit = ShowAccount("입금");
		if (Deposit == -1) {
			System.out.println("[메세지] 계좌를 먼저 생생해주세요.");
			return;

		}
		System.out.println("[입금] 금액을 입력해주새요.");
		int Money = scan.nextInt();
		
		userManager2.getInstance().userList[userManager2.getInstance().identifier].accList[Deposit].money+=Money;
		System.out.println("[메세지] 입금이 완료되었습니다.");
	}
	
	void AccountWthdr () {
		int Wthdr = ShowAccount("출금");
		if (Wthdr == -1) {
			System.out.println("[메세지] 계좌를 먼저 생생해주세요.");
		}
		System.out.println("[출금] 금액을 입력해주세요.");
		int Money = scan.nextInt();	
		
		if (userManager2.getInstance().userList[userManager2.getInstance().identifier].accList[Wthdr].money < Money) {
			System.out.println("[메세지]잔액이 부죽합니다.");
		 return;
		}
		
		userManager2.getInstance().userList[userManager2.getInstance().identifier].accList[Wthdr].money -= Money;
		System.out.println("[출금] 출금이 완료되었습니다.");
		
	}
	
	void transfer() {
		int trans = ShowAccount("출금");
		if (trans == -1) {
			System.out.println("[메세지] 계좌를 먼저 생생해주세요.");
		
	}
		System.out.println("[이체] 이체 할 계좌를 입력해주세요 : ");
		int transAccount = scan.nextInt();
		System.out.println("[메세지] 계좌번호를 확인해주세요.");
	return;
}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
