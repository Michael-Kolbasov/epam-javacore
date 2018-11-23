package main.java;
import java.math.BigDecimal;

/**
 * The Account is a lazy-init singleton class that ATMs are working with.
 * It provides methods to deposit and withdraw the funds.
 * All operations are done with BigDecimal values: scale = 2, round = down.
 */
public final class Account {
    private static Account instance;
    private volatile BigDecimal funds = BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_DOWN);
    private static final Object key = new Object();

    private Account() {}

    /**
     * Lazy initialization.
     * @return  Account instance if it's the first appeal.
     */
    public static Account getInstance() {
        if (instance == null) {
            synchronized (key) {
                if (instance == null) {
                    instance = new Account();
                }
            }
        }
        return instance;
    }

    /**
     * Deposit method allows to increase funds.
     * @param amount    amount to deposit.
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Incorrect input. Amount must be more than 0. Your input: " + amount);
        } else {
            final BigDecimal amountToDeposit = BigDecimal.valueOf(amount).setScale(2, BigDecimal.ROUND_DOWN);
            synchronized (key) {
                funds = funds.add(amountToDeposit);
            }
        }
    }

    /**
     * Withdraw method allows to withdraw funds.
     * @param amount    amount to withdraw.
     * @return true     if operation is successful.
     *         false    if {@code amount} is more than {@code funds}.
     */
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Incorrect input. Amount must be more than 0. Your input: " + amount);
            return false;
        }
        final BigDecimal amountToWithdraw = BigDecimal.valueOf(amount).setScale(2, BigDecimal.ROUND_DOWN);
        if (funds.compareTo(amountToWithdraw) < 0) {
            System.out.println("Insufficient funds in the account.");
            return false;
        } else {
            synchronized (key) {
                funds = funds.subtract(amountToWithdraw);
                return true;
            }
        }
    }
}