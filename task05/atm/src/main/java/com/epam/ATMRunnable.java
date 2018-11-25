package com.epam;

/**
 * This class creates a process that deposits 500 funds on the account and then tries to withdraw 100 funds 10 times.
 * Finally, there are enough funds in the ATM, but not enough on the Account.
 */
public final class ATMRunnable implements Runnable {
    private final ATMImpl atm = new ATMImpl();
    private final Account account = Account.getInstance();

    @Override
    public void run() {
        atm.deposit(500, account);
        for (int i = 0; i < 10; i++) {
            atm.withdraw(100, account);
        }
    }
}