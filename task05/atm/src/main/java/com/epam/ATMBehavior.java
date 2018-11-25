package com.epam;

/**
 * This interface provides basic billing methods for ATMImpl class.
 */
public interface ATMBehavior {
    default void deposit(double amount, Account account) {
        account.deposit(amount);
    }

    default boolean withdraw(double amount, Account account) {
        return account.withdraw(amount);
    }
}