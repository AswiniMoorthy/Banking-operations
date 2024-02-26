package Bankoperations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BankTest {
    @Test
    public void testDeposit() {
        Bank bank = new Bank(100.0);
        bank.deposit(50.0);
        Assert.assertEquals(bank.getBalance(), 150.0);
    }

    @Test
    public void testWithdrawSufficientFunds() {
        Bank bank = new Bank(100.0);
        bank.withdraw(50.0);
        Assert.assertEquals(bank.getBalance(), 50.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testWithdrawInsufficientFunds() {
        Bank bank = new Bank(100.0);
        bank.withdraw(150.0); // Attempting to withdraw more than balance
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeDeposit() {
        Bank bank = new Bank(100.0);
        bank.deposit(-50.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeWithdrawal() {
        Bank bank = new Bank(100.0);
        bank.withdraw(-50.0);
    }
}
