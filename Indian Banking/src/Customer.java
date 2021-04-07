import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

//Customer class consists of all basic data of customers
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
	 
	 //Constructor
	    
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
	 
	 //Method to create account based on account type
	 
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
	 
	 //method to get data of customer

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
	
	//method to get number of accounts user have
	
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
	
	//method to get account
	
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
            return null;
		}
	}
	
	//method to check balance 
	
	public void checkBalance(int type) {
		Account account = getAccount(type);
		 if (account != null) { 
			 System.out.println("Account Balance is: "+(account.currentBalance));
		 }
		 else{
			 System.out.println("**Customer Doesn't have selected Account**");
		 }
	}
	
	//method to withdraw money 
	
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
	
	//method to deposit money
	
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
	
	// method to transfer money from one account to other of same customer
	
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
	
	//Pays bills method
	
	public boolean paybills(int from) {
		int s=0;
		boolean flag;
		do {
			Scanner input = new Scanner(System.in);
			try {
				System.out.println("\nChoose anyone from below:\n 1:Electricity Bill\n 2.BroadBand Bill \n 3.PostPaid Bill\n 4.Credit Bill\n 5.DTH Bill");
				s = input.nextInt();
				flag = true;
			}
			catch(InputMismatchException e){
				System.out.println("Wrong input,Please enter only numbers");
				flag = false;
			}
			
		}while(!flag);
		
        Random r = new Random();
        int low =0;
        int high = 100;
        int result = 0;
        int ans = 0;
		switch(s) {
        case 1:
        	System.out.println("Please enter Electricity Bill Id");
            String eBill = sc.next();
            
        	low = 100;
        	high = 1000;
        	result = r.nextInt(high-low) + low;
            double bill = Double.valueOf(result);
            System.out.println("Your Electricity Bill is : "+bill);
            
            do {
    			Scanner input = new Scanner(System.in);
    			try {
    				System.out.println("Do you want to pay\n 1:Yes\n 2:No\nSelect 1 or 2 only");
    	            ans = input.nextInt();
    				flag = true;
    			}
    			catch(InputMismatchException e){
    				System.out.println("Wrong input,Please enter only numbers");
    				flag = false;
    			}
    			
    		}while(!flag);
            
            if (ans == 1){
                Account account = getAccount(from);
                if (account != null) {
                    if (account.withDraw(bill)) {
                    	System.out.println("Electricity Bill Payment Succesfull");
                        return true;
                    }else {
                        return false;
                    }
                }else{
                    return false;
                }
            }else {
                return false;
            }
            
        case 2:
        	System.out.println("Please enter Broadband Bill Id");
        	String bBill = sc.next();
        	
        	low = 500;
        	high= 1000;
        	result = r.nextInt(high-low) + low;
            double bill1 = Double.valueOf(result);
            System.out.println("Your BroadBand Bill is : "+bill1);
            do {
    			Scanner input = new Scanner(System.in);
    			try {
    				System.out.println("Do you want to pay\n 1:Yes\n 2:No\nSelect 1 or 2 only");
    	            ans = input.nextInt();
    				flag = true;
    			}
    			catch(InputMismatchException e){
    				System.out.println("Wrong input,Please enter only numbers");
    				flag = false;
    			}
    			
    		}while(!flag);
            
            if (ans == 1){
            	Account account = getAccount(from);
                if (account != null) {
                    if (account.withDraw(bill1)) {
                    	System.out.println("BroadBandBill Payment Succesfull");
                        return true;
                    }else {
                        return false;
                    }
                }else{
                    return false;
                }
            }else {
                return false;
            }
            
        case 3:
        	System.out.println("Please enter Pospaid Bill Id");
        	String pBill = sc.next();
        	
        	low = 500;
        	high= 1000;
        	result = r.nextInt(high-low) + low;
            double bill2 = Double.valueOf(result);
            System.out.println("Your Postpaid Bill is : "+bill2);
            do {
    			Scanner input = new Scanner(System.in);
    			try {
    				System.out.println("Do you want to pay\n 1:Yes\n 2:No\nSelect 1 or 2 only");
    	            ans = input.nextInt();
    				flag = true;
    			}
    			catch(InputMismatchException e){
    				System.out.println("Wrong input,Please enter only numbers");
    				flag = false;
    			}
    			
    		}while(!flag);
            
            if (ans == 1){
            	Account account = getAccount(from);
                    if (account != null) {
                        if (account.withDraw(bill2)) {
                        	System.out.println("BroadBandBill Payment Succesfull");
                            return true;
                        }else {
                            return false;
                        }
                    }else{
                        return false;
                    }
                
            }else {
                return false;
            }
            
            
        case 4:
        	
        	low = 0;
        	high= 2000;
        	result = r.nextInt(high-low);
            double bill3 = Double.valueOf(result);
            
            System.out.println("Your Credit Bill is : "+bill3);
            do {
    			Scanner input = new Scanner(System.in);
    			try {
    				System.out.println("Do you want to pay\n 1:Yes\n 2:No\nSelect 1 or 2 only");
    	            ans = input.nextInt();
    				flag = true;
    			}
    			catch(InputMismatchException e){
    				System.out.println("Wrong input,Please enter only numbers");
    				flag = false;
    			}
    			
    		}while(!flag);
            
            if (ans == 1){
            	Account account = getAccount(from);
                if (account != null) {
                    if (account.withDraw(bill3)) {
                    	System.out.println("Credit Bill Payment Succesfull");
                        return true;
                    }else {
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }
            
        case 5:
        	System.out.println("Please enter DTH Bill Id");
        	String dthBill = sc.next();
        	
        	low = 250;
        	high= 700;
        	result = r.nextInt(high-low) + low;
            double bill4 = Double.valueOf(result);
            
            System.out.println("Your DTH Bill is : "+bill4);
            do {
    			Scanner input = new Scanner(System.in);
    			try {
    				System.out.println("Do you want to pay\n 1:Yes\n 2:No\nSelect 1 or 2 only");
    	            ans = input.nextInt();
    				flag = true;
    			}
    			catch(InputMismatchException e){
    				System.out.println("Wrong input,Please enter only numbers");
    				flag = false;
    			}
    			
    		}while(!flag);
            
            if (ans == 1){
            	Account account = getAccount(from);
                if (account != null) {
                    if (account.withDraw(bill4)) {
                    	System.out.println("DTH Bill Payment Succesfull");
                        return true;
                    }else {
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }
            
        default:
        	System.out.println("Incorrect Selection");
            return false;

        }
	}
	
	//Bookings Method
	
	public boolean bookings(int from) {
		int ans=0;
		int option=0;
		int c=0;
		boolean flag;
		do {
			Scanner input = new Scanner(System.in);
			try {
				System.out.println("Choose anyone from below:\n 1:Movie Tickets \n 2.Travel Booking\n 3.Event Booking \n 4.Hotel Booking\n");
	            option = input.nextInt();
				flag = true;
			}
			catch(InputMismatchException e){
				System.out.println("Wrong input,Please enter only numbers");
				flag = false;
			}
			
		}while(!flag);
        switch(option) {
        case 1:
        	int num =1;
        	int choice =0;
        	
        	do {
        	do {
    			Scanner input = new Scanner(System.in);
    			try {
    				System.out.println("Select Movie:\n 1.Avengers End Game\n 2.Tenet\n 3.Wonder Woman\n 4.Joker");
    	            choice = input.nextInt();
    				flag = true;
    			}
    			catch(InputMismatchException e){
    				System.out.println("Wrong input,Please enter only numbers");
    				flag = false;
    			}
    			
    		}while(!flag);
        	if(choice == 1||choice == 2||choice == 3||choice == 4) {
        		c =1;
        	do {
    			Scanner input = new Scanner(System.in);
    			try {
    				System.out.println("Enter No of Tickets");
    	            num = input.nextInt();
    				flag = true;
    			}
    			catch(InputMismatchException e){
    				System.out.println("Wrong input,Please enter only numbers");
    				flag = false;
    			}
    			
    		}while(!flag);
            
            System.out.println("Each Ticket Fare is : 250 ");
            System.out.println("Total Fare: "+(250*num));
            do {
    			Scanner input = new Scanner(System.in);
    			try {
    				System.out.println("Do you want to pay\n 1:Yes\n 2:No\nSelect 1 or 2 only");
    	            ans = input.nextInt();
    				flag = true;
    			}
    			catch(InputMismatchException e){
    				System.out.println("Wrong input,Please enter only numbers");
    				flag = false;
    			}
    			
    		}while(!flag);
            
            if (ans == 1){
            	System.out.println("Booking Ticket...");
            	Account account = getAccount(from);
                if (account != null) {
                    if (account.withDraw(250.0*num)) {
                    	Random r = new Random();
                    	int low = 11111;
                    	int high = 99999;
                    	int result = r.nextInt(high-low) + low;
                        
                    	System.out.println("Booking Succesfull \n Booking ID: "+result);
                        return true;
                    }else {
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }
        	}
        	else {
        		System.out.println("Please enter correct choice");
        	}
        }while(c==0);
            
        case 2:
        	int choice1=0;
        	c=0;
        	do {
        	do {
    			Scanner input = new Scanner(System.in);
    			try {
    				System.out.println("\nSelect Mode of Travel: \n1.Flight \n2.Bus \n3.Train");
    	        	choice1 = input.nextInt();
    				flag = true;
    			}
    			catch(InputMismatchException e){
    				System.out.println("Wrong input,Please enter only numbers");
    				flag = false;
    			}
    			
    		}while(!flag);
        	if(choice1==1||choice1==2||choice1==3) {
        		c=1;
            System.out.println("Enter Source City:");
            String sCity = sc.next();
            System.out.println("Enter Destination City:");
            String dCity = sc.next();
            System.out.println("Enter Date of Travel");
            String date = sc.next();
            Random r = new Random();
        	int low = 1000;
        	int high = 5000;
        	int result = r.nextInt(high-low) + low;
        	double fare = Double.valueOf(result);
            System.out.println("Your Ticket Fare is : "+fare);
            do {
    			Scanner input = new Scanner(System.in);
    			try {
    				System.out.println("Do you want to pay\n 1:Yes\n 2:No\nSelect 1 or 2 only");
    	            ans = input.nextInt();
    				flag = true;
    			}
    			catch(InputMismatchException e){
    				System.out.println("Wrong input,Please enter only numbers");
    				flag = false;
    			}
    			
    		}while(!flag);
            
            if (ans == 1){
            	System.out.println("Booking Ticket...");
            	Account account = getAccount(from);
                if (account != null) {
                    if (account.withDraw(fare)) {
                    	Random id = new Random();
                    	int low1 = 11111;
                    	int high1 = 99999;
                    	int result1 = id.nextInt(high1-low1) + low1;
                    	System.out.println("Booking Succesfull \n Booking ID: "+result1);
                        return true;
                    }else {
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }
        	}
        	else {
        		System.out.println("Please enter correct choice");
        	}
        	}while(c==1);
            
        case 3:
        	int select=0;
        	c=0;
        	do {
            do {
    			Scanner input = new Scanner(System.in);
    			try {
    				System.out.println("\nSelect an Event: \n1.Chainsmokers Live Concert \n2.AUS vs IND ODI-1 \n3.The Grand Carnival Exhibition");
    	            select = input.nextInt();
    				flag = true;
    			}
    			catch(InputMismatchException e){
    				System.out.println("Wrong input,Please enter only numbers");
    				flag = false;
    			}
    			
    		}while(!flag);
            if(select==1||select==2||select==3) {
            	c=1;
        	Random m = new Random();
        	int low2 = 250;
        	int high2 = 700;
        	int result2 = m.nextInt(high2-low2) + low2;
        	double fare1 = Double.valueOf(result2);
            
            System.out.println("Your Ticket fare is : "+fare1);
            do {
    			Scanner input = new Scanner(System.in);
    			try {
    				System.out.println("Do you want to pay\n 1:Yes\n 2:No\nSelect 1 or 2 only");
    	            ans = input.nextInt();
    				flag = true;
    			}
    			catch(InputMismatchException e){
    				System.out.println("Wrong input,Please enter only numbers");
    				flag = false;
    			}
    			
    		}while(!flag);
            if (ans == 1){
            	System.out.println("Booking Ticket...");
            	Account account = getAccount(from);
                if (account != null) {
                    if (account.withDraw(fare1)) {
                    	Random con = new Random();
                    	int low3 = 111;
                    	int high3 = 999;
                    	int result3 = con.nextInt(high3-low3) + low3;
                    	System.out.println("Booking Succesfull \n Booking Id: "+result3);
                        return true;
                    }else {
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }
            }
            else {
        		System.out.println("Please enter correct choice");
        	}
        	}while(c==1);
            
        case 4:
        	System.out.println("Enter City Name");
            String city = sc.next();
            c=0;
            int opt =0;
            do {
            do {
    			Scanner input = new Scanner(System.in);
    			try {
    				System.out.println("Select Hotel: \n1.Novotel \n2.Taj \n3.ITC Kakatiya");
    	            opt = input.nextInt();
    				flag = true;
    			}
    			catch(InputMismatchException e){
    				System.out.println("Wrong input,Please enter only numbers");
    				flag = false;
    			}
    			
    		}while(!flag);
            if(opt==1||opt==2||opt==3) {
            	c=1;
            System.out.println("Enter Checkin Date");
            String data = sc.next();
            int days =0;
            do {
    			Scanner input = new Scanner(System.in);
    			try {
    				System.out.println("Number of Days");
    	            days = input.nextInt();
    				flag = true;
    			}
    			catch(InputMismatchException e){
    				System.out.println("Wrong input,Please enter only numbers");
    				flag = false;
    			}
    			
    		}while(!flag);
            
            Random h = new Random();
        	int low4 = 3500;
        	int high4 = 4500;
        	int result4 = h.nextInt(high4-low4) + low4;
        	double cost = Double.valueOf(result4);
            
            double tot = days * cost;
            System.out.println("Your Booking Fare: "+tot);
            do {
    			Scanner input = new Scanner(System.in);
    			try {
    				System.out.println("Do you want to pay\n 1:Yes\n 2:No\nSelect 1 or 2 only");
    	            ans = input.nextInt();
    				flag = true;
    			}
    			catch(InputMismatchException e){
    				System.out.println("Wrong input,Please enter only numbers");
    				flag = false;
    			}
    			
    		}while(!flag);
            
            if (ans == 1){
            	System.out.println("Booking Hotel.....");
            	Account account = getAccount(from);
                if (account != null) {
                    if (account.withDraw(tot)) {
                    	Random hb = new Random();
                    	int low5 = 1111;
                    	int high5 = 9999;
                    	int result5 = hb.nextInt(high5-low5) + low5;
                    	System.out.println("Booking Succesfull \n Booking Id: "+result5);
                        return true;
                    }else {
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }
            }
            else {
        		System.out.println("Please enter correct choice");
        	}
            }while(c==1);
        
        default:
        	System.out.println("**Incorrect Selection**");
            return false;
        
        }
	}
	
	
	// method to return customer data based on customer account to write into file
	
	public String writeToFile() {
		
		//If no account is created
		
		if (account1 == null && account2 == null && account3 == null) {
			return cin+","+fullName +","+fatherName+","+dob+","+occupation+","+phoneNumber+","+emailId+","+address+","+city+","+panNumber+","+aadharNumber;
		}
		
		//if Savings account is created
		
		else if(account2 == null && account3 == null) {
			return cin+","+fullName +","+fatherName+","+dob+","+occupation+","+phoneNumber+","+emailId+","+address+","+city+","+panNumber+","+aadharNumber+","+account1.type+","+account1.accountNo+","+account1.currentBalance;

		}
		
		//if Saving Pro Account is created
		
		else if (account1 == null && account3 == null) {
			return cin+","+fullName +","+fatherName+","+dob+","+occupation+","+phoneNumber+","+emailId+","+address+","+city+","+panNumber+","+aadharNumber+","+account2.type+","+account2.accountNo+","+account2.currentBalance;

		}
		
		//if Salary Account is created
		
		else if (account2 == null && account1 == null) {
			return cin+","+fullName +","+fatherName+","+dob+","+occupation+","+phoneNumber+","+emailId+","+address+","+city+","+panNumber+","+aadharNumber+","+account3.type+","+account3.accountNo+","+account3.currentBalance+","+account3.companyName+","+account3.empId;

		}
		
		//if Both savings and savings pro account is created
		
		else if (account3 == null) {
			return cin+","+fullName +","+fatherName+","+dob+","+occupation+","+phoneNumber+","+emailId+","+address+","+city+","+panNumber+","+aadharNumber+","+account1.type+","+account1.accountNo+","+account1.currentBalance+","+account2.type+","+account2.accountNo+","+account2.currentBalance;

		}
		
		//if Both savings and salary accounts are created
		
		else if (account2 == null) {
			return cin+","+fullName +","+fatherName+","+dob+","+occupation+","+phoneNumber+","+emailId+","+address+","+city+","+panNumber+","+aadharNumber+","+account1.type+","+account1.accountNo+","+account1.currentBalance+","+account3.type+","+account3.accountNo+","+account3.currentBalance+","+account3.companyName+","+account3.empId;

		}
		
		//if both savings pro and salary account is created
		
		else if (account1 == null) {
			return cin+","+fullName +","+fatherName+","+dob+","+occupation+","+phoneNumber+","+emailId+","+address+","+city+","+panNumber+","+aadharNumber+","+account2.type+","+account2.accountNo+","+account2.currentBalance+","+account3.type+","+account3.accountNo+","+account3.currentBalance+","+account3.companyName+","+account3.empId;

		}
		
		//if all three accounts are created
		
		else {
			return cin+","+fullName +","+fatherName+","+dob+","+occupation+","+phoneNumber+","+emailId+","+address+","+city+","+panNumber+","+aadharNumber+","+account1.type+","+account1.accountNo+","+account1.currentBalance+","+account2.type+","+account2.accountNo+","+account2.currentBalance+","+account3.type+","+account3.accountNo+","+account3.currentBalance+","+account3.companyName+","+account3.empId;

		}
		
						
	}
	


}
