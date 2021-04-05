import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class MainMenu {
	static ArrayList<Customer> customers = new ArrayList<>();
	static Scanner sc =new Scanner(System.in);
	static int users = 1000;
	static int accountNos = 100000;
	
	//readFromFile(customers);
	//printList(customers);

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		int powerOff;
		do{
		    powerOff = 1;
		    System.out.println("***************--------   Helloo User Welcome to Indian Bank  ---------**************");
		    System.out.println("Choose anyone from below\n 1:New Customer\n 2:Existing Customer\n 3:Exit Bank Application\nSelect 1 or 2 or 3 only");
		    int choice = sc.nextInt();
		    if (choice == 1){
		    	System.out.println("--------------------------------------------------------------------------");
		    	System.out.println("Please enter your Basic Details to create an Account with us");
		        adddetails();
		    }
		    else if (choice == 2){
		    	System.out.println("--------------------------------------------------------------------------");
		    	System.out.println("                    Welcome               ");
		    	System.out.println("Enter Your Customer Identification Number(CIN)");
		        String cin = sc.next();
		        Customer cus = getCustomer(cin);
		        if (cus != null){
		        	System.out.println("Hi"+(cus.fullName));
		            mainMenu(cus);
		        }
		        else{
		        	System.out.println("No Customer Exists with Given CIN");
		        }
		    }else if (choice == 3){
		    	System.out.println("Getting Out of Application...\nHave a good day...");
		        powerOff = 0;
		    }else {
		    	System.out.println("**Please enter correct Choice**");
		    }
		}while (powerOff == 1);
		//writingToData(customers);
		
	}
	
	public static Customer getCustomer(String cin) {
		for(Customer cus:customers){
	        if (cus.cin == cin) {
	            return cus;
	        }
	    }
	    return null;
	}
	
	public static void mainMenu(Customer cus) {
		System.out.println("\nPlease Select from below to continue\n 1:Create another Account type for same User\n 2:Banking\n 3:Edit your Details\n 4:Logout\nSelect 1 or 2 or 3 or 4 only");
	    int choice = sc.nextInt();
	    switch (choice){
	        case 1:
	            int rep;
	            if ((cus.getAccount(1) != null) && (cus.getAccount(2) != null) && (cus.getAccount(3) != null)){
	            	System.out.println("Customer already have all Account Types");
	            }
	            else{
	                do{
	                    rep = 0;
	                    System.out.println("Select Account Type\n"+
	                        "1.Savings:\n"+
	                            "\t Featues: -> Basic Account with minimum Balalce of 0 Rupees.\n"+
	                                    " -> Maximum withdrawl and deposit limit of 100000 Rupees.\n"+
	                        "2.Savings Pro Account:\n"+
	                            "\tFeatues: -> Pro Account with minimum Balalce of 2000 Rupees.\n"+
	                                     "-> Maximum withdrawl and deposit limit of 200000 Rupees.\n"+
	                        "3.Salary Account:\n"+
	                           "\t Features: -> For Salaried people no minimum balance\n"+
	                                      "-> Maximum withdrawl and deposit limit of 150000 Rupees.\n"+
	                       "Reply with 1 or 2 or 3 only.");
	                    int account = sc.nextInt();
	                    System.out.println("Enter Initial Deposit Amount");
	                    double amount = sc.nextDouble();
	                    accountNos += 1;
	                    String accountNo = String.valueOf(accountNos);
	                    if (cus.createAccount(account,accountNo, amount) == false ){
	                        rep = 1;
	                    }
	                }while (rep == 1);
	                cus.getData();
	            }
	            mainMenu(cus);
	            break;
	        case 2:
	            banking(cus);
	            
	            break;
	            
	        case 3:
	            editdetails(cus);
	            break;
	        case 4:
	        	System.out.println("\nLogging Out....\nThank you for Banking with Us\n");
	        	break;
	        default:
	        	System.out.println("\nPlease Enter Correct Choice");
	            mainMenu(cus);
	    }
		
	}
	
	public static void adddetails() throws IOException {
		FileWriter data = new FileWriter("CustomerData.txt",true);
		PrintWriter pw=new PrintWriter(data);
		
		users += 1;
		String cin = String.valueOf(users);
			    
		System.out.println("Enter the Full Name");
		String fullname = sc.next();
			    
		System.out.println("Enter the Father Name");
		String fname = sc.next();
			    
		System.out.println("Enter the Date of Birth(DD-MM-YYYY)");
		String Dob = sc.next();
			    
		System.out.println("Enter the occupation");
		String occupation = sc.next();
			    
		System.out.println("Enter the phone number");
		long phNo = sc.nextLong();
			    
		System.out.println("Enter the Email ID");
		String email = sc.next();
			    
		System.out.println("Enter the address");
		String address = sc.next();
			    
		System.out.println("Enter the City Name");
		String city = sc.next();
			    
		System.out.println("Enter the Pan Number");
		String panNo = sc.next();
			    
		System.out.println("Enter the aadharNumber");
		String aadhar = sc.next();
		Customer c = new Customer(cin,fullname,fname,Dob,occupation,phNo,email,address,city,panNo,aadhar);
			    
		customers.add(c);
		//pw.println(c.writeToFile());
		//pw.close();
			    
		Customer cus = getCustomer(cin);
		if (cus != null){
			
			int rep;
			if ((cus.getAccount(1) != null) && (cus.getAccount(2) != null) && (cus.getAccount(3) != null)){
				
				System.out.println("Customer already created all Account Types");
			}
			else{
				
			    do{
			    	
			        rep = 0;
			        System.out.println("Select Account Type\n"+
	                        "1.Savings:\n"+
	                            "\t Featues: -> Basic Account with minimum Balalce of 0 Rupees.\n"+
	                                    " -> Maximum withdrawl and deposit limit of 100000 Rupees.\n"+
	                        "2.Savings Pro Account:\n"+
	                            "\tFeatues: -> Pro Account with minimum Balalce of 2000 Rupees.\n"+
	                                     "-> Maximum withdrawl and deposit limit of 200000 Rupees.\n"+
	                        "3.Salary Account:\n"+
	                           "\t Features: -> For Salaried people no minimum balance\n"+
	                                      "-> Maximum withdrawl and deposit limit of 150000 Rupees.\n"+
	                       "Reply with 1 or 2 or 3 only.");
			                int account = sc.nextInt();
			                System.out.println("Enter Initial Deposit Amount");
			                double amount = sc.nextDouble();
			                accountNos += 1;
			                String accountNo = String.valueOf(accountNos);
			                if (cus.createAccount(account, accountNo, amount) == false) {
			                    rep = 1;
			                }
			             }while (rep == 1);
			            cus.getData();
			            //Account a;
			            
			            //pw.close();
			            
			        }
			        mainMenu(cus);
			    }
	}
	
	public static void banking(Customer cus) {
		int more = 1;
		
		System.out.println("--------------------***************--------------------------");
		System.out.println("\nPlease Select from below Transactions:\n 1:Check Balance\n 2.Deposit Money \n 3.Withdraw Money \n 4.Transfer Money\n 5.Pay Bills\n 6.Bookings\n 7.Exit\n");
		int transaction = sc.nextInt();
		switch (transaction){
		
		case 1:
			
			if (cus.getUserAccounts()){
				
				System.out.println("Please Select Account type to Proceed");
			    int account = sc.nextInt();
			    cus.checkBalance(account);
			 }
			break;
			            
		case 2:
			
			if (cus.getUserAccounts()){
				
				System.out.println("Please Select Account type to Proceed");
			    int account =sc.nextInt();
				System.out.println("Enter Amount");
			    double amount = sc.nextDouble();
			    if (cus.depositMoney(account,amount) == false){
			    	System.out.println("Money Deposit Unsuccessfull");
			    }
			 }
			break;
		case 3:
			   if (cus.getUserAccounts()){
				   
				   System.out.println("Please Select Account type to Proceed");
			       int account =sc.nextInt();
			       System.out.println("Enter Amount");
			       double amount =sc.nextDouble();
			       if (cus.withdrawMoney(account,amount) == false){
			    	   
			    	   System.out.println("Money Withdrawl Unsuccessfull");
			       }
			     }
			   break;
		  case 4:
				
			    if (cus.getUserAccounts()){
			    	
			    	System.out.println("Select From Account type");
			        int fromAccount = sc.nextInt();
			        System.out.println("Select To Account type");
			        int toAccount =sc.nextInt();
			        if (fromAccount != toAccount){
			        	
			        	System.out.println("Enter Amount");
			            double amount = sc.nextDouble();
			            if (cus.transfermoney(fromAccount,toAccount,amount) == false){
			            	
			            	System.out.println("Money Transfer Unsuccessfull");
			            }
			         }
			        else {
			        	
			        	System.out.println("**The Sender and Beneficiary Accounts are same**");
			        }
			                
			       }
			    break;
		case 5:
			
			if (cus.getUserAccounts()){
				
			    int rep;
			    System.out.println("Please Select Account type to Proceed");
			    int account = sc.nextInt();
			    do{
			    	
			        rep = 0;
			       /* if (cus.paybills(account) == false){
			        	
			            rep = 1;
			        }*/
			        
			        System.out.println("\nDo you want to pay more Bills\n 1:Yes\n 2:No\nSelect 1 or 2");
			        rep = sc.nextInt();
			      }while (rep == 1);
			    }
			break;
			case 6:
				
			    if (cus.getUserAccounts()){
			    	
			        int rep;
			        System.out.println("Please Select Account type to Proceed");
			        int account = sc.nextInt();
			        do{
			        	
			            rep = 0;
			            /*if (cus.bookings(account) == false){
			            	
			                rep = 1;
			             }*/
			            System.out.println("\nDo you want to do Book more\n 1:Yes\n 2:No\nSelect 1 or 2");
			             rep = sc.nextInt();
			          }while (rep == 1);
			       }
			    break;
			   case 7:
				   
			       more = 2;
			       break;
			   default:
				   
			       more = 2;
			       System.out.println("**Please enter correct Choice**");
			       banking(cus);
			    }
			    
			    if (more != 2) {
			    	System.out.println("\nDo you want to do more transactions\n 1.Yes\n 2.No\nReply with 1 or 2");
			        int repe = sc.nextInt();
			        if (repe == 1) {
			            banking(cus);
			        }else{
			            mainMenu(cus);
			        }
			    }
			    else{
			        mainMenu(cus);
			    }
			    
	}
	
	public static void editdetails(Customer cus) {
		cus.getData();
	    int rep;
	    
	    do {
	        rep = 0;
	        System.out.println("Please Select Data to Update\nReply with Numbers from 1 to 10 only");
	        int choice = sc.nextInt();
	        switch (choice) {
	        case 1:
	        	System.out.println("Please Enter Full Name to Update");
	            cus.fullName = sc.next();
	            System.out.println("\nDo you want to update more reply\n 1.Yes\n 2.No\nSelect 1 or 2 only");
	            rep = sc.nextInt();
	            break;
	            
	        case 2:
	        	System.out.println("Please Enter Father Name to Update");
	            cus.fatherName = sc.next();
	            System.out.println("\nDo you want to update more reply\n 1.Yes\n 2.No\nSelect 1 or 2 only");
	            rep = sc.nextInt();
	            break;
	            
	        case 3:
	        	System.out.println("Please Enter Date of Birth to Update");
	            cus.dob = sc.next();
	            System.out.println("\nDo you want to update more reply\n 1.Yes\n 2.No\nSelect 1 or 2 only");
	            rep = sc.nextInt();
	            break;
	            
	        case 4:
	        	System.out.println("Please Enter Occupation to Update");
	            cus.occupation = sc.next();
	            System.out.println("\nDo you want to update more reply\n 1.Yes\n 2.No\nSelect 1 or 2 only");
	            rep = sc.nextInt();
	            break;
	            
	        case 5:
	        	System.out.println("Please Enter Phone Number to Update");
	            cus.phoneNumber = sc.nextInt();
	            System.out.println("\nDo you want to update more reply\n 1.Yes\n 2.No\nSelect 1 or 2 only");
	            rep = sc.nextInt();
	            break;
	            
	        case 6:
	        	System.out.println("Please Enter Email Id to Update");
	            cus.emailId = sc.next();
	            System.out.println("\nDo you want to update more reply\n 1.Yes\n 2.No\nSelect 1 or 2 only");
	            rep = sc.nextInt();
	            break;
	            
	        case 7:
	        	System.out.println("Please Enter Address to Update");
	            cus.address = sc.next();
	            System.out.println("\nDo you want to update more reply\n 1.Yes\n 2.No\nSelect 1 or 2 only");
	            rep = sc.nextInt();
	            break;
	            
	        case 8:
	        	System.out.println("Please Enter City to Update");
	            cus.city = sc.next();
	            System.out.println("\nDo you want to update more reply\n 1.Yes\n 2.No\nSelect 1 or 2 only");
	            rep = sc.nextInt();
	            break;
	            
	        case 9:
	        	System.out.println("Please Enter PAN Number to Update");
	            cus.panNumber = sc.next();
	            System.out.println("\nDo you want to update more reply\n 1.Yes\n 2.No\nSelect 1 or 2 only");
	            rep = sc.nextInt();
	            break;
	            
	        case 10:
	        	System.out.println("Please Enter Aadhar-Number to Update");
	            cus.aadharNumber = sc.next();
	            System.out.println("\nDo you want to update more reply\n 1.Yes\n 2.No\nSelect 1 or 2 only");
	            rep = sc.nextInt();
	            break;

	        default:
	        	System.out.println("**Please enter correct Choice**");
	            rep = 1;
	        
	        }
		
	}while (rep == 1);
		    
	cus.getData();
		    
    mainMenu(cus);
    
	}
	
	public static void files() {
		
	}
	

}
