public class CheckingAccount {
    private double balance;
    private String name;

    public CheckingAccount() {
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void displayAccount() {
        System.out.println("Name : " + name);
        System.out.println("Balance : " + balance);
    }

    void deposit(double x) {
        setBalance(getBalance() + x);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Warning: Withdrawal amount cannot be negative.");
        } else if (balance - amount <= 0) {
            System.out.println("Warning: Insufficient balance to make the withdrawal.");
        } else {
            balance -= amount;
            System.out.println("New balance: " + String.format("%.2f", balance));
        }
    }
}