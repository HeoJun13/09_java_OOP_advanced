package step9_02.atm_v2_필기;

import java.util.Random;
import java.util.Scanner;

public class AccountManager2 {
	
	private AccountManager2() {}
	private static AccountManager2 Intance = new AccountManager2();
	public static AccountManager2 getIntance() {
		return Intance;
		
	}
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	userManager_9_2_필기 user = userManager_9_2_필기.getInstance();
	
	void creatAcc(int identifier ) {
		
		int accCnt = user.userList[identifier].accCnt;
		
		if (accCnt == user.Acc_Max_CNT) {
			System.out.println("[메세지] 계좌개설은 3개까지만 가능합니다");
			return;
		}
		
		user.userList[identifier].acc[accCnt] = new Account_9_2_필기();
		
		String makeAcc = "";
		while (true) {
			System.out.println("!!!!!!!!!!!");
			makeAcc = ran.nextInt(100205303)+ 502015 + "";
			if (user.getCheckAcc(makeAcc)) {
				break;
			}
		}
		
		user.userList[identifier].acc[accCnt].accNumber = makeAcc;
		user.userList[identifier].accCnt++;
		System.out.println("[메세지]" + makeAcc + "계좌가 생성되었습니다.");
		
		
	}
	
	void printAcc(int Identifier ) {
		
		User_9_2_필기 temp = user.userList[Identifier];
		System.out.println("=================");
		System.out.println(" ID :" + temp.id);
		System.out.println("=================");
		for (int i = 0; i < temp.accCnt; i++) {
			System.out.println("accNumber : " + temp.acc[i].accNumber + "monet : " + temp.acc[i].money);
		}
				
		
	}
	

	public static void main(String[] args) {

	}

}
