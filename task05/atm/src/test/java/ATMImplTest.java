package test.java;
import main.java.ATMImpl;
import main.java.Account;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ATMImplTest {
    private ATMImpl atm;
    private Account account;

    /**
     * ATM has 1000 funds on init
     */
    @Before
    public void setUp() {
        atm = new ATMImpl();
        account = Account.getInstance();
        atm.deposit(100, account);
    }

    @Test
    public void testWithdraw_Unavailable() {
        Assert.assertFalse(atm.withdraw(1001, account));
        Assert.assertFalse(atm.withdraw(1000.01, account));
        Assert.assertFalse(atm.withdraw(2000, account));
        Assert.assertFalse(atm.withdraw(-100, account));
        Assert.assertFalse(atm.withdraw(0, account));
    }

    @Test
    public void testWithdraw_AllOK() {
        Assert.assertFalse(atm.withdraw(-1, account));
        Assert.assertFalse(atm.withdraw(1000, account));
        Assert.assertTrue(atm.withdraw(100, account));
        Assert.assertFalse(atm.withdraw(1, account));
    }
}