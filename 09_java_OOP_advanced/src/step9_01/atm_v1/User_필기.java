package step9_01.atm_v1;

public class User_필기 {
	
	String id;
	int accAcount;
	Account[] acc;
	
	void printAccount() {
		
		for (int i = 0; i < accAcount; i++) {
			acc[i].printOwnAccount();
		}
	}

}
