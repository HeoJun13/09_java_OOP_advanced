package step9_02.atm_v2_필기;

import java.util.Random;
import java.util.Scanner;

import step9_01.atm_v1.UserManager;

public class AccountManager2 {
	
	private AccountManager2() {}
	private static AccountManager2 instace = new AccountManager2();
	private static AccountManager2 getInstance() {
		return instace;}
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	userManager_9_2_필기 um = userManager_9_2_필기.getInstance();
	
	void creatAcc(int idenfifier) {
		
		int accCntByuser = um.userList[idenfifier].accCnt;
		
		if (accCntByuser == um.Acc_Max_CNT) {
			System.out.println("[메세지] 계좌설계은 3개까지 생성가능합니다.");
			return;
			
		}
		
		um.userList[idenfifier].acc[accCntByuser] = new Account_9_2_필기();
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
