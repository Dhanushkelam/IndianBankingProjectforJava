
public class Account {
	String accountNo;
	double currentBalance = 0.0;
	double minBalance = 0.0;
	double maxDeposit = 0.0;
	double maxWithdrawal = 0.0;
	String type= "";
	public Account(String accountNumber,double initialDeposit) {
		this.accountNo = accountNumber;
		this.currentBalance = initialDeposit;
	}
	public boolean deposit(double amount) {
		if (amount <= this.maxDeposit) {
            this.currentBalance += amount;
            System.out.println("Current Balance:"+this.currentBalance+"\n");
            return true;
        }
        else{
        	System.out.println("Transaction UnSuccessfull");
        	System.out.println("Your Account type can only deposit maximum of "+this.maxDeposit+"\n");
            return false;
        }
	}
	public boolean withDraw(double amount) {		
		 if (amount <= currentBalance){
	            if (amount <= this.maxWithdrawal){
	                this.currentBalance -= amount;
	                System.out.println("Current Balance:"+this.currentBalance+"\n");
	                return true;
	            }else{
	            	System.out.println("Transaction UnSuccessfull");
	            	System.out.println("Your Account type can only withdraw maximum of "+this.maxWithdrawal+"\n");
	                return false;
	            }
	        }else{
	        	System.out.println("Transaction UnSuccessfull");
            	System.out.println("Balance Insufficient, Current Balance: "+this.currentBalance+"\n");
                return false;
	        }
	}
	public String writeAccount() {
		return this.type+ ","+this.accountNo+","+this.currentBalance;
	}

}
