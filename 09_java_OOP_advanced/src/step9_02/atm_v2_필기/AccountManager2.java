package step9_02.atm_v2_필기;

// 계좌삭제 메서드 추가 밑 조회 1시간걸림 
// 계좌가 하나일때, 삭제할 계좌번호가 맞을때 삭제만 가능 번호가 틀렸을떄 오류 

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import step9_01.atm_v1.UserManager;
import step9_01.atm_v2.userManager_필기;


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
			makeAcc = ran.nextInt(234234)+2819+"";
			//if (user.getCheckAcc(makeAcc) == false) {
			if (!user.getCheckAcc(makeAcc)) {
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
	
	void deletAcc(int Identifier) {
		
		if (user.userList[Identifier].accCnt== 0) {
			System.out.println("[메세지] 더이상 삭제할수없습니다.");
		}
		if (user.userList[Identifier].accCnt== 1) { // 계좌가 하나일때 바로 삭제기능.
			System.out.println("[메세지] 생성하신 계좌 :" + user.userList[Identifier].acc[0].accNumber + "삭제되었습니다.");
			userManager_9_2_필기.getInstance().userList[Identifier].acc = null;
		}
		else  { // 여러개 계좌 직접입력으로 삭제가능.
			System.out.print("[메세지] 삭제하고싶은 계좌 입력:");
			String AccDelet = scan.next();
			int tempACCment = userManager_9_2_필기.getInstance().userCnt;
			int delIdx  = -1;
			for (int i = 0; i < tempACCment; i++) {
				if (AccDelet.equals(userManager_9_2_필기.getInstance().userList[Identifier].acc[i].accNumber)) {
					System.out.println("[메세지] 생성하신 계좌 :" + user.userList[Identifier].acc[0].accNumber + "삭제되었습니다.");
					
					delIdx  = i;
				}
			}
			
			if (delIdx == -1) {
				System.out.println("[메세지] 작성하신 계좌 확인부탁드립니다.");	
				return;
			}
		}
		userManager_9_2_필기.getInstance().userList[Identifier].accCnt--;
		
		}
	
		
		
	

	public static void main(String[] args) {

	}

}
