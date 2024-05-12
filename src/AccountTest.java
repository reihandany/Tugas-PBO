public class AccountTest {
    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount();

        checkingAccount.setName("Cahya");
        checkingAccount.setBalance(100000);
        checkingAccount.deposit(50000);
        checkingAccount.displayAccount();
        checkingAccount.withdraw(50000);
    }
}