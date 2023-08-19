package BankAccount;

public class Account {
        int accountBalance;
        
        public Account(int amount){
            if(amount >= 0){
                accountBalance = amount;
                 System.out.println("Initial account balance: " + accountBalance);
            } 
            else{
                System.err.println("Invalid account balance");
                accountBalance = 0;
                 System.out.println("Initial account balance: " + accountBalance);
            }                   
        }
        
        void creditAmout(int amount){
            if(amount > 0){
                accountBalance += amount;
                System.out.println("Successfull");
            }       
         }
        
        void debitAmout(int amount){
            if (accountBalance < amount)
                System.err.println("Debit amount is more than the account balance");
            else{
                accountBalance -= amount;
                System.out.println("Successfull");
            }         
        }
        
        int accountBalance(){
            
            return accountBalance;
        }
}
