
package BankAccount;

public class runAccount {
    
    public static void main(String[] args) {
        Account ac = new Account(300);
        ac.creditAmout(50000);
        ac.debitAmout(1000);
        System.out.println("Account bal: " +ac.accountBalance());
        
    }
    
}
