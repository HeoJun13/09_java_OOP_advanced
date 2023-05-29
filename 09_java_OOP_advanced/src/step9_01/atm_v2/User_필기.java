package step9_01.atm_v2;

public class User_필기 {
	
	String id;
	int accCount;
	Account_필기[] acc;
	
	void PringAccount() {
		
		for (int i = 0; i < accCount; i++) {
			acc[i].printAccountInquiry();
		}
	}
	
	
	public static void main(String[] args) {
	}
	


}
