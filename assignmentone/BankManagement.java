package assignmentone;

class Bank{

    int balance = 0;
    int accNumber;
    String accHolder;

    Bank(int accNumber, String accHolder){

        this.accNumber = accNumber;
        this.accHolder = accHolder;
    }
    

    void deposit(int amount, int accNumber, String accHolder){
        
        if(this.accNumber == accNumber && this.accHolder.equals(accHolder)){
            balance += amount;
        }
        else{
            System.out.println("Wrong account detail ");
        }

    }

    void withdrawal(int amount){
        if(balance > 0 && balance >= amount){
            balance -= amount;
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }

    void balanceEnquiry(){
        System.out.println("Current balance is : " + balance);
    }

    void accountDetail(){
        System.out.println("Account holder name : " + accHolder);
        System.out.println("Account number : " + accNumber);
        System.out.println("Current balance : " + balance);
    }

}

public class BankManagement {

    public static void main(String[] args) {

       Bank b = new Bank(123, "Anki");
        
       b.deposit(100, 123, "Anki");
       System.out.println(b.balance);
       b.deposit(200, 123, "Anki");
       System.out.println(b.balance);

       b.withdrawal(100);
       System.out.println(b.balance);

       b.accountDetail();

        
    }
    
}
