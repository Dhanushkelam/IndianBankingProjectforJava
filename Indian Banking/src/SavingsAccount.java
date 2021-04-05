
public class SavingsAccount extends Account {
	public SavingsAccount(String accountNumber, double initialDeposit)
    {
        super(accountNumber,initialDeposit);
        this.minBalance = 0.0;
        this.maxDeposit = 100000.0;
        this.maxWithdrawal = 100000.0;
        this.type = "Savings Account";
    }

}
