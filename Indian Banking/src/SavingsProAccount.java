
public class SavingsProAccount extends Account{
	
	//Constructor

	public SavingsProAccount(String accountNumber, double initialDeposit)
    {
        super(accountNumber,initialDeposit);
        this.minBalance = 2000.0;
        this.maxDeposit = 200000.0;
        this.maxWithdrawal = 200000.0;
        this.type = "Savings Pro Account";
    }

}
