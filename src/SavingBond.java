public class SavingBond {
    private int term; // in months
    private double interestRate;
    private double balance;

    public SavingBond(int term) {
        if (term < 1 || term > 60) {
            throw new IllegalArgumentException("Term must be between 1 and 60 months");
        }
        this.term = term;
        setInterestRate();
        this.balance = 0.0; // initial balance is 0
    }

    private void setInterestRate() {
        switch (term / 12) {
            case 0:
                if (term <= 11 && term == 0) {
                    interestRate = 0.005;
                } else {
                    interestRate = 0.01;
                }
                break;
            case 1:
                if (term <= 23) {
                    interestRate = 0.01;
                }
                break;
            case 2:
                if (term <= 35) {
                    interestRate = 0.015;
                }
                break;
            case 3:
                if (term <= 47) {
                    interestRate = 0.02;
                }
                break;
            case 4:
                if (term >= 48 && term == 60) {
                    interestRate = 0.025;
                }
                break;
            default:
                throw new RuntimeException("Unexpected term value");
        }
    }

    public void depositBond(double amount) {
        balance += amount;
    }

    public void earnInterest() {
        if (term > 0) {
            balance += balance * interestRate;
            term--;
        }
    }

    public double getBalanceBond() {
        return balance;
    }

    public int getTerm() {
        return term;
    }

    public static void main(String[] args) {
        CheckingAccount account = new CheckingAccount();
        SavingBond bond = new SavingBond(0);
        account.displayAccount();
        for (int i = 0; i < 24; i++) {
            bond.earnInterest();
            System.out.println("Month " + (i + 1) + ": Balance = $" + account.getBalance() + ", Term = "
                    + bond.getTerm() + " months");
        }

    }
}