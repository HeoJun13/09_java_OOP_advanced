package step9_03.atm_필기;

public class User2 {
	
	String id;
	String password;
	Account2[] accList;
	int accCount;
	
	User2() {}
	
	User2(String id, String password ) {
		this.id = id;
		this.password = password;
		this.accList = accList;
		this.accCount = accCount;
		
	}
	
	void PrintOnrUserAllCounts() {
		
		if (accCount == 0) {
			System.out.println(id +" " + password + "계좌를 계설해주세요.");
		} 
		else if (accCount > 0) {
			System.out.println(id + " " + password + " ");
			for (int i = 0; i < accCount; i++) {
				System.out.print(accList[i].number + " " + accList[i].money + " 원입니다;");
			}
			System.out.println();
			
		}
		
		
		
	}
	

	public static void main(String[] args) {

	}

}
