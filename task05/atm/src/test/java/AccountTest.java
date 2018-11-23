package test.java;
import main.java.Account;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountTest {
    private Account account;

    @Before
    public void setUp() {
        account = Account.getInstance();
        account.deposit(100);
    }

    @Test
    public void testWithdraw_InsufficientFunds() {
        Assert.assertFalse(account.withdraw(200));
        Assert.assertFalse(account.withdraw(-200));
        Assert.assertFalse(account.withdraw(100.01));
        Assert.assertFalse(account.withdraw(0));
    }

    @Test
    public void testWithdraw_AllOK() {
        Assert.assertTrue(account.withdraw(50));
        Assert.assertTrue(account.withdraw(50));
        Assert.assertFalse(account.withdraw(50));
    }
}