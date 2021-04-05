import java.util.Scanner;

public class Customer {
	Scanner sc =new Scanner(System.in);
	 String cin;
	 String fullName;
	 String fatherName;
	 String dob;
	 String occupation;
	 long phoneNumber;
	 String emailId;  
	 String address; 
	 String city;
	 String panNumber;
	 String aadharNumber;
	 
	 SavingsAccount account1;
	 SavingsProAccount account2;
	 SalaryAccount account3;
	    
	 public Customer (String cin,String fullName,String fatherName,String DOB,String occupation,long phoneNumber,String emailId,String address,String city,String panNumber,String aadharNumber)
	  {
	     this.cin = cin;
	     this.fullName = fullName;
	     this.fatherName = fatherName;
	     this.dob = DOB;
	     this.occupation = occupation;
	     this.phoneNumber = phoneNumber;
	     this.emailId = emailId;
	     this.address = address;
	     this.city = city;
	     this.panNumber = panNumber;
	     this.aadharNumber = aadharNumber;  
	     this.account1 = null;
	     this.account2 = null;
	     this.account3 = null;
	    }
	 
	 public boolean createAccount(int type,String accountNumber,double initialamount) {
		 if (getAccount(type) == null) {
	         switch (type)
	         {	         
	         case 1:
	             if (initialamount >= 0){ 	            	 
	                 this.account1 = new SavingsAccount(accountNumber, initialamount);
	                 System.out.println("Savings Account Creation Successful\nCurrent Balance:" +(this.account1).currentBalance+"\n");
	                 return true;
	             }
	             else{
	            	 System.out.println("Account Creation Unsuccessfull");
	            	 System.out.println("Amount must be not Negative");
	                 return false;
	             }
	             
	         case 2:
	             if (initialamount >= 2000){
	            	 
	                 this.account2 = new SavingsProAccount(accountNumber, initialamount);
	                 System.out.println("Savings Pro Account Creation Successful\nCurrent Balance: "+(this.account2).currentBalance+"\n");
	                 return true;
	             }
	             else{
	            	 
	                 System.out.println("Account Creation Unsuccessfull");
	                 System.out.println("Minimum Balance for Savings Account Pro is 2000");
	                 return false;
	             }
	         case 3:
	             if (initialamount >= 0){
	            	 
	                 System.out.println("Enter company name:");
	                 String companyName = sc.next();
	                 System.out.println("Enter Employee Id:");
	                 String empId = sc.next();
	                 this.account3 = new SalaryAccount(accountNumber, initialamount, companyName, empId);
	                 System.out.println("Salary Account Creation Successful\nCurrent Balance: "+(this.account3).currentBalance+"\n");
	                 return true;
	             }
	             else{
	            	 
	                 System.out.println("Account Creation Unsuccessfull");
	                 System.out.println("Amount must be not Negative");
	                 return false;
	            }
	          default:
	        	  
	              System.out.println("**Please Enter Correct Account Type**");
	              return false;
	         }
	        }
		 else{
			System.out.println("**Entered Account Type already Exists for the user**");
	        System.out.println("**Please Select Other Account Type to Create**");
	        return false;
	     }
	 }

	public void getData() {
		 
		 System.out.println("---------------Customer Identification Number(CIN): "+this.cin+"-----------------");
		 System.out.println("1.Customer Name: "+this.fullName+"\n2.Father Name: "+this.fatherName+"\n3.Date of Birth: "+this.dob+"\n4.Occupation: "+this.occupation+"\n5.Phone Number: "+this.phoneNumber+"\n6.Email Id: "+this.emailId+"\n7.Address: "+this.address+"\n8.City: "+this.city+"\n9.PAN-Number: "+this.panNumber+"\n10.Aadhar-Number: "+this.aadharNumber+"\n");
		 System.out.println("Customer have following Accounts with us");
	     if (this.account1 != null) {
	    	 
	    	 System.out.println("Account No: "+(account1.accountNo));
	    	 System.out.println("Type: "+(this.account1.type));
	        }
	     if (this.account2 != null) {
	    	 
	    	 System.out.println("Account No: "+(account2.accountNo));
	    	 System.out.println("Type: "+(this.account2.type));
	     }
	     if (this.account3 != null) {
	    	 
	    	 System.out.println("Account No: "+(account3.accountNo));
	    	 System.out.println("Type: "+(this.account3.type));
	    	 System.out.println("Company Name: "+(this.account3.companyName));
	    	 System.out.println("Employee Id: "+(this.account3.empId));
	      }
	 }
	
	public boolean getUserAccounts() {
		int count = 0;
		if (this.account1 != null || this.account2 != null || this.account3 != null){
			
			System.out.println("\nCustomer have Following Accounts with us");
		    if (this.account1 != null) {
		    	
		    	System.out.println("1."+(this.account1.type));
		        count += 1;
		    }
		    if (this.account2 != null) {
		    	
		    	System.out.println("2."+(this.account2.type));
		        count += 1;
		     }
		    
		    if (this.account3 != null) {
		    	
		    	System.out.println("3."+(this.account3.type));
		        count += 1;
		    }
		    return true;
		    
		}
		else {
			
			System.out.println("Customer have No accounts Created");
		    return false;
		}
		
	}
	
	public Account getAccount(int type) {
		switch (type) {
		case 1:
            if (this.account1 != null){
                return this.account1;
            }
            else {
                return null;
            }
        case 2:
            if (this.account2 != null){
                return this.account2;
            }
            else {
                return null;
            }
        case 3:
            if (this.account3 != null){
                return this.account3;
            }
            else {
                return null;
            }
        default:
            System.out.println("**Please Enter Correct Account type to Proceed**");
            return null;
		}
	}
	
	public void checkBalance(int type) {
		Account account = getAccount(type);
		 if (account != null) { 
			 System.out.println("Account Balance is: "+(account.currentBalance));
		 }
		 else{
			 System.out.println("**Customer Doesn't have selected Account**");
		 }
	}
	
	public boolean withdrawMoney(int from,double amount) {
		Account account = getAccount(from);
		if (account != null){
		    if (account.withDraw(amount)) {
		        System.out.println("Amount withdrawal successfull");
		        return true;
		    }
		    else {
		        return false;
		    }
		}
		else{
		    System.out.println("Please Enter Correct Account Type");
		    return false;
		}
	}
	
	public boolean depositMoney(int to,double amount) {
		Account account = getAccount(to);
		if (account != null) {	
		    if (account.deposit(amount)) {
		    	System.out.println("Amount deposit successfull");
		        return true;
		    }
		    else {
		        return false;
		    }
		}
		else{
			System.out.println("Please Enter Correct Account Type");
		    return false;
		}
	}
	
	public boolean transfermoney(int from,int to,double amount) {
		boolean check = true;
		
	    Account wAccount = getAccount(from);
	    Account dAccount = getAccount(to);
	    if (wAccount != null){
	        if (dAccount != null){
	            if (amount <= wAccount.currentBalance){
	                wAccount.currentBalance -= amount;
	                System.out.println("Current Balance in "+(wAccount.type)+": "+(wAccount.currentBalance)+"\n");
	                check = true;
	            }
	            else{
	            	System.out.println("Balance Insufficient in "+(wAccount.type)+": "+(wAccount.currentBalance)+"\n");
	                check = false;
	            } 
	            if (check == true){
	                //Account dAccount = getAccount(to);
	                if (dAccount != null){
	                    dAccount.currentBalance += amount;
	                    System.out.println("Current Balance in "+(dAccount.type)+": "+(dAccount.currentBalance)+"\n");
	                 }
	                
	            }
	        }
	        else{
	        	System.out.println("Beneficiary Account Doesn't Exists");
	        }
	    }
	    else{
	    	System.out.println("Sender Account Doesn't Exists");
	    }        
	    return check;
	}
	
	public String writeToFile() {
		return cin+","+fullName +","+fatherName+","+dob+","+occupation+","+phoneNumber+","+emailId+","+address+","+city+","+panNumber+","+aadharNumber;
				
	}

	@Override
	public String toString() {
		return "Customer [cin=" + cin + ", fullName=" + fullName + ", fatherName=" + fatherName + ", dob=" + dob
				+ ", occupation=" + occupation + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", address="
				+ address + ", city=" + city + ", panNumber=" + panNumber + ", aadharNumber=" + aadharNumber + "]";
	}
	
	
	

}
