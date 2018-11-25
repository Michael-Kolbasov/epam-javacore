package com.epam;
import java.math.BigDecimal;

/**
 * ATMImpl class provides overridden from ATMBehavior interface methods for billing on Account class.
 * ATMImpl starts with 1000 standard funds units in it.
 * All operations are done with BigDecimal values: scale = 2, round = down.
 */
public final class ATMImpl implements ATMBehavior {
    private volatile BigDecimal fundsAvailable = BigDecimal.valueOf(1000).setScale(2, BigDecimal.ROUND_DOWN);
    private final Object key = new Object();

    /**
     * This overridden version of depositing adds deposited funds to ATMImpl's {@code fundsAvailable}.
     * @param amount    funds to deposit
     * @param account   account to deposit
     */
    @Override
    public void deposit(double amount, Account account) {
        if (amount <= 0) {
            System.out.println("Incorrect input. Amount must be more than 0. Your input: " + amount);
        } else {
            final BigDecimal amountToDeposit = BigDecimal.valueOf(amount).setScale(2, BigDecimal.ROUND_DOWN);
            synchronized (key) {
                fundsAvailable = fundsAvailable.add(amountToDeposit);
                account.deposit(amount);
            }
        }
    }

    /**
     * This overridden version of withdrawing checks if there is enough {@code fundsAvailable} in current ATMImpl to withdraw.
     * @param amount    funds to withdraw.
     * @param account   account from which funds are withdrawing.
     * @return true     if ATMImpl has enough {@code fundsAvailable}
     *         false    if ATMImpl has not enough {@code fundsAvailable}
     */
    @Override
    public boolean withdraw(double amount, Account account) {
        if (amount <= 0) {
            System.out.println("Incorrect input. Amount must be more than 0. Your input: " + amount);
            return false;
        }
        final BigDecimal amountToWithdraw = BigDecimal.valueOf(amount).setScale(2, BigDecimal.ROUND_DOWN);
        if (fundsAvailable.compareTo(amountToWithdraw) < 0) {
            System.out.println("Sorry, withdrawing funds is not available right now. Please, try again later.");
            return false;
        } else {
            synchronized (key) {
                if (account.withdraw(amount)) {
                    fundsAvailable = fundsAvailable.subtract(amountToWithdraw);
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}