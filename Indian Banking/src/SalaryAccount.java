
public class SalaryAccount extends Account{
	String empId;
	String companyName;
	public SalaryAccount(String accountNumber, double initialDeposit,String companyName,String empId)
    {
        super(accountNumber,initialDeposit);
		this.companyName = companyName;
		this.empId = empId;
        this.minBalance = 2000.0;
        this.maxDeposit = 200000.0;
        this.maxWithdrawal = 200000.0;
        this.type = "Salary Account";
    }

}
