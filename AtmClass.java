
import java.util.*;

public class AtmClass {
	
   Scanner sc= new Scanner(System.in);
   String user;
   String pwd;
   String a;
   String b;
   double balance=0;
   ArrayList <String> TransactionHistory= new ArrayList<String>();

   public void createAccount() {
	   System.out.println("Enter new user ID:");
	   user=sc.nextLine();
	   System.out.println("Enter new password");
	   pwd=sc.nextLine();
	   System.out.println("Account created!");
   }
   
   public void login() {
	   System.out.println("Enter user ID:");
	   a=sc.nextLine();
	   System.out.println("Enter password");
	   b=sc.nextLine();
	   if(a.equals(user) && b.equals(pwd)) {
		   while(true) {
			   System.out.println();
			   System.out.println("  M E N U  ");
			   System.out.println("1. Transaction History");
			   System.out.println("2. Withdraw");
			   System.out.println("3. Deposit");
			   System.out.println("4. Transfer");
			   System.out.println("5. Quit");
			   System.out.println();
			   System.out.print("Option: ");
			   int k= sc.nextInt();
			   switch(k) {
			   case 1: 
				     TransHistory t= new TransHistory();
				     t.printTransactionHistory(TransactionHistory,balance,sc);
				     break;
			   case 2:
				    balance=Withdraw.withdraw(TransactionHistory,balance,sc);
				    break;
			   case 3:
			
				    balance=Deposit.deposit(TransactionHistory,balance,sc);
				    break;
			   case 4:
				    balance=Transfer.transfer(TransactionHistory,balance,sc);
				    break;
			   case 5:
				   System.out.println("Thank you!");
				   return;
			   default:
				   System.out.println("Incorrect choice!");
		   }
		   }
	   }
       else{
        System.out.println("Incorrect login credentials!");
        return;
       }
   }
   public static void main(String args[]) {
	   
	   AtmClass obj= new AtmClass();
       Scanner scan= new Scanner(System.in);

	  while(true) {
          
		  System.out.println();
		  System.out.println("1. Create Account");
		  System.out.println("2. Login if existing user");
		  System.out.println("3. Exit");
		  
		  int option=scan.nextInt();
		  
		  switch(option) {
		    case 1: obj.createAccount();
		    		break;
		    case 2: obj.login();
		    		break;
		    case 3: System.exit(0);
		    		break;
		    default: System.out.println("Incorrect choice!");
		  }
		 
		  
	  }
	  
	  
   }
}
class TransHistory {
    
	public void printTransactionHistory(ArrayList<String> TransactionHistory, double balance, Scanner sc) {
       
       if(TransactionHistory.isEmpty()){
        System.out.println("No Transaction History yet");
		System.out.println();

       }
       else{
        System.out.println("Transaction History");
		System.out.println("--------------------");
		System.out.println();
        for(String i: TransactionHistory) {
            System.out.println(i);
        }
		System.out.println();
       }
	   
	}
	
}
class Withdraw {
     
	public static double withdraw(ArrayList<String> TransactionHistory, double balance, Scanner sc) {
		System.out.println("Enter amount to withdraw: ");
		double withAmount= sc.nextDouble();
		if(balance<withAmount) {
			System.out.println("Insufficient balance!");
            System.out.println("Current balance: "+balance);
			System.out.println();

		}
		else {
			balance-=withAmount;
			TransactionHistory.add(withAmount+ " -Debited");
			System.out.println("Current balance: "+balance);
			System.out.println();
		}
		
		return balance;
	}
}
class Deposit {
	
	public static double deposit(ArrayList<String> TransactionHistory, double balance, Scanner sc) {
		System.out.println("Enter amount to deposit: ");
	    double depAmount= sc.nextDouble();
	    
	    balance+=depAmount;
        System.out.println("Current balance: "+balance);
		System.out.println();
	    TransactionHistory.add(depAmount+ " -Credited");

		return balance;
	}

}
class Transfer {
	
	public static double transfer(ArrayList<String> TransactionHistory, double balance, Scanner sc) {
		System.out.println("Enter account number to transfer to: ");
		String acc= sc.next();
		
		System.out.println("Enter the amount to transfer: ");
		double transferAmount= sc.nextDouble();
		
		balance-=transferAmount;
		TransactionHistory.add(transferAmount+ " -Debited for transfer to account number: "+acc);

		System.out.println("Current balance: "+balance);
		System.out.println();
		return balance;
	}
}

