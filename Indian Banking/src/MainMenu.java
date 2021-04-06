import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

public class MainMenu {
	static ArrayList<Customer> customers = new ArrayList<>(); // Array list consists of all customers data 
	static Scanner sc =new Scanner(System.in); // used to scan data from keyboard
	static int users = 1000;
	static int accountNos = 100000;
	
	//readFromFile(customers);
	//printList(customers);

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		File file = new File("CustomerData.txt");
		if(file.exists()) { // if function is used to check does file already exits or not
			
			//if file exits then data present in the file is stored into array list
			
			
			FileInputStream cusfile=new FileInputStream("CustomerData.txt");
			BufferedReader br=new BufferedReader(new InputStreamReader(cusfile));
			Customer c = null;
			String line;
			while((line=br.readLine())!=null) {
				String fields[]=line.split(",");
				
				String cin = fields[0];
			    String fullName = fields[1];
			    String fatherName = fields[2];
			    String dob = fields[3];
			    String occupation = fields[4];
			    long phoneNumber = Long.parseLong(fields[5]);
			    String emailId = fields[6];
			    String address = fields[7];
			    String city = fields[8];
			    String panNumber = fields[9];
			    String aadharNumber = fields[10]; 
			    
			    if (fields.length == 11) {
				    c = new Customer(cin,fullName,fatherName,dob,occupation,phoneNumber,emailId,address,city,panNumber,aadharNumber);
				    
			    }
			    else if(fields.length >= 12 && fields.length < 23) {
			    	
						if (fields[11].equalsIgnoreCase("Savings Account")) {
							if(fields.length == 14){
								
							    c = new Customer(cin,fullName,fatherName,dob,occupation,phoneNumber,emailId,address,city,panNumber,aadharNumber);
							    c.account1 = new SavingsAccount(fields[12],Double.parseDouble(fields[13]));
							   
							}
							else if(fields.length == 17) {
								c = new Customer(cin,fullName,fatherName,dob,occupation,phoneNumber,emailId,address,city,panNumber,aadharNumber);
							    c.account1 = new SavingsAccount(fields[12],Double.parseDouble(fields[13]));
							    c.account2 = new SavingsProAccount(fields[15],Double.parseDouble(fields[16]));
							  
							}
							else if(fields.length == 19) {
								c = new Customer(cin,fullName,fatherName,dob,occupation,phoneNumber,emailId,address,city,panNumber,aadharNumber);
							    c.account1 = new SavingsAccount(fields[12],Double.parseDouble(fields[13]));
							    c.account3 = new SalaryAccount(fields[15],Double.parseDouble(fields[16]),fields[17],fields[18]);
							   
							}
							else if(fields.length == 22) {
								c = new Customer(cin,fullName,fatherName,dob,occupation,phoneNumber,emailId,address,city,panNumber,aadharNumber);
							    c.account1 = new SavingsAccount(fields[12],Double.parseDouble(fields[13]));
							    c.account2 = new SavingsProAccount(fields[15],Double.parseDouble(fields[16]));
							    c.account3 = new SalaryAccount(fields[18],Double.parseDouble(fields[19]),fields[20],fields[21]);
							 
							}
						}
						else if(fields[11].equalsIgnoreCase("Savings Pro Account")) {
							if(fields.length == 14){
								c = new Customer(cin,fullName,fatherName,dob,occupation,phoneNumber,emailId,address,city,panNumber,aadharNumber);
							    c.account2 = new SavingsProAccount(fields[12],Double.parseDouble(fields[13]));
							    
								
							}
							else if(fields.length == 19) {
								c = new Customer(cin,fullName,fatherName,dob,occupation,phoneNumber,emailId,address,city,panNumber,aadharNumber);
							    c.account2 = new SavingsProAccount(fields[12],Double.parseDouble(fields[13]));
							    c.account3 = new SalaryAccount(fields[15],Double.parseDouble(fields[16]),fields[17],fields[18]);
							  
							}
							
						}
						else if(fields[11].equalsIgnoreCase("Salary Account")) {
							if(fields.length == 16){
								c = new Customer(cin,fullName,fatherName,dob,occupation,phoneNumber,emailId,address,city,panNumber,aadharNumber);
								c.account3 = new SalaryAccount(fields[12],Double.parseDouble(fields[13]),fields[14],fields[15]);
								
							}
							
						}		
				}
			    
			    customers.add(c);
				users = Integer.valueOf(cin);
				
			}
		}
		//---------------------------------------------Program Starts from Here-----------------------------------
		
		
		int powerOff;
		do{
		    powerOff = 1;
		    System.out.println("***************--------   Helloo User Welcome to Indian Bank  ---------**************");
		    System.out.println("Choose anyone from below\n 1:New Customer\n 2:Existing Customer\n 3:Exit Bank Application\nSelect 1 or 2 or 3 only");
		    int choice = sc.nextInt();
		    if (choice == 1){
		    	
		    	//Registering new customers
		    	
		    	System.out.println("--------------------------------------------------------------------------");
		    	System.out.println("Please enter your Basic Details to create an Account with us");
		        adddetails();
		    }
		    else if (choice == 2){
		    	
		    	// Existing Customer
		    	
		    	System.out.println("--------------------------------------------------------------------------");
		    	System.out.println("                    Welcome               ");
		    	System.out.println("Enter Your Customer Identification Number(CIN)");
		        String cin = sc.next();
		        Customer cus = getCustomer(cin);
		        if (cus != null){
		        	System.out.println("Hi "+(cus.fullName));
		            mainMenu(cus);
		        }
		        else{
		        	System.out.println("No Customer Exists with Given CIN");
		        }
		    }
		    else if (choice == 3){
		    	
		    	// Exit from bank
		    	
		    	System.out.println("Getting Out of Application...\nHave a good day...");
		        powerOff = 0;
		    }
		    else {
		    	System.out.println("**Please enter correct Choice**");
		    }
		}while (powerOff == 1);
		
		writingToFile(customers); // Calling method to write data into file
		
		
	}
	
	// this method is used to check whether customer registered with bank or not using cin
	public static Customer getCustomer(String cin) {
		for(Customer cus:customers){
	        if (cus.cin.equalsIgnoreCase(cin)) {
	            return cus;
	        }
	    }
	    return null;
	}
	
	// Bank Main Menu
	
	public static void mainMenu(Customer cus) {
		System.out.println("\nPlease Select from below to continue\n 1:Create another Account type for same User\n 2:Banking\n 3:Edit your Details\n 4:Logout\nSelect 1 or 2 or 3 or 4 only");
	    int choice = sc.nextInt();
	    switch (choice){
	        case 1:
	        	// create another account type for same user
	        	
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
	                                    "\t\t -> Maximum withdrawl and deposit limit of 100000 Rupees.\n"+
	                        "2.Savings Pro Account:\n"+
	                            "\tFeatues: -> Pro Account with minimum Balalce of 2000 Rupees.\n"+
	                                     "\t\t -> Maximum withdrawl and deposit limit of 200000 Rupees.\n"+
	                        "3.Salary Account:\n"+
	                           "\t Features: -> For Salaried people no minimum balance\n"+
	                                      "\t\t -> Maximum withdrawl and deposit limit of 150000 Rupees.\n"+
	                       "Reply with 1 or 2 or 3 only.");
	                    int account = sc.nextInt();
	                    System.out.println("Enter Initial Deposit Amount");
	                    double amount = sc.nextDouble();
	                    accountNos += 1;
	                    String accountNo = String.valueOf(accountNos);
	                    if (cus.createAccount(account,accountNo, amount) == false ){ //calling creating account method
	                        rep = 1;
	                    }
	                }while (rep == 1);
	                cus.getData();
	            }
	            mainMenu(cus);
	            break;
	        case 2:
	        	//calling banking menu method
	            banking(cus);
	            
	            break;
	            
	        case 3:
	        	//calling edit details method of a customer
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
	
	//method to Read basic details from customers and add data to array list
	
	public static void adddetails() throws IOException {
		users += 1;
		
		String cin = String.valueOf(users);
		sc.nextLine();	    
		System.out.println("Enter the Full Name");
		String fullname = sc.nextLine();
			    
		System.out.println("Enter the Father Name");
		String fname = sc.nextLine();
			    
		System.out.println("Enter the Date of Birth(DD-MM-YYYY)");
		String Dob = sc.next();
		
		sc.nextLine();	    
		System.out.println("Enter the occupation");
		String occupation = sc.nextLine();
		long phNo = 1234567890;
		boolean flag;
		do {
			Scanner input = new Scanner(System.in);
			try {
				System.out.println("Enter the phone number");
				phNo = input.nextLong();
				flag = true;
			}
			catch(InputMismatchException e){
				System.out.println("Please enter only numbers");
				flag = false;
			}
			
		}while(!flag);
		
		System.out.println("Enter the Email ID");
		String email = sc.next();
		sc.nextLine();	    
		System.out.println("Enter the address");
		String address = sc.nextLine();
		
		System.out.println("Enter the City Name");
		String city = sc.nextLine();
		
		System.out.println("Enter the Pan Number");
		String panNo = sc.next();
			    
		System.out.println("Enter the aadharNumber");
		String aadhar = sc.next();
		Customer c = new Customer(cin,fullname,fname,Dob,occupation,phNo,email,address,city,panNo,aadhar);
			    
		customers.add(c);
			    
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
			            
			        }
			        mainMenu(cus);
			    }
	}
	
	//Method for bank transactions
	
	public static void banking(Customer cus) {
		int more = 1;
		
		System.out.println("--------------------***************--------------------------");
		System.out.println("\nPlease Select from below Transactions:\n 1:Check Balance\n 2.Deposit Money \n 3.Withdraw Money \n 4.Transfer Money\n 5.Pay Bills\n 6.Bookings\n 7.Exit\n");
		int transaction = sc.nextInt();
		switch (transaction){
		
		case 1:
			//Check Balance
			
			if (cus.getUserAccounts()){
				
				System.out.println("Please Select Account type to Proceed");
			    int account = sc.nextInt();
			    cus.checkBalance(account);
			 }
			break;
			            
		case 2:
			//Deposit Money
			
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
			//Withdraw money
			
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
				//transferring money
			  
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
			//Pay Bills
			
			if (cus.getUserAccounts()){
				
			    int rep;
			    System.out.println("Please Select Account type to Proceed");
			    int account = sc.nextInt();
			    do{			    	
			        rep = 0;
			       if (cus.paybills(account) == false){
			        	
			            rep = 1;
			        }
			        
			        System.out.println("\nDo you want to pay more Bills\n 1:Yes\n 2:No\nSelect 1 or 2");
			        rep = sc.nextInt();
			      }while (rep == 1);
			    }
			break;
			case 6:
				
				//Bookings
				
			    if (cus.getUserAccounts()){
			    	
			        int rep;
			        System.out.println("Please Select Account type to Proceed");
			        int account = sc.nextInt();
			        do{
			        	
			            rep = 0;
			            if (cus.bookings(account) == false){
			            	
			                rep = 1;
			             }
			            System.out.println("\nDo you want to do Book more\n 1:Yes\n 2:No\nSelect 1 or 2");
			             rep = sc.nextInt();
			          }while (rep == 1);
			       }
			    break;
			   case 7:
				   //Exit from banking menu
				   
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
	
	//Method to edit details of customer
	
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
	
	//Method to write customers data into text file
	
	public static void writingToFile(ArrayList<Customer> customers) throws IOException {
		File file = new File("CustomerData.txt");
		
		//Here if condition checks whether text file exits or not
		
		if(file.exists()) {
			
			//if text file already exits then new data will overwrite the text file
			
			Writer data = new FileWriter("CustomerData.txt",false);
			PrintWriter pw=new PrintWriter(data);
			for(Customer c:customers) {
				pw.println(c.writeToFile());
			}
			pw.close();
		}
		else {
			
			// else new text file will be created and data will add to new text file
			
			FileWriter data = new FileWriter("CustomerData.txt",true);
			PrintWriter pw=new PrintWriter(data);
			for(Customer c:customers) {
				pw.println(c.writeToFile());
			}
			pw.close();
		}
		
		
	}
	

}
