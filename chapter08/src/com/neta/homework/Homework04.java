package com.neta.homework;

public class Homework04 {
    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount(1000);
        checkingAccount.deposit(1000);
        System.out.println(checkingAccount.getBalance());
        checkingAccount.withdraw(1000);
        System.out.println(checkingAccount.getBalance());
        System.out.println("=========================");
        SavingAccount savingAccount = new SavingAccount(2000);
        savingAccount.deposit(500);
        savingAccount.deposit(500);
        savingAccount.deposit(500);
        savingAccount.deposit(500);
        System.out.println(savingAccount.getBalance());
        savingAccount.setRate(1.5);
        savingAccount.earnMonthlyInterest();
        savingAccount.withdraw(1500);
        System.out.println(savingAccount.getBalance());
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class CheckingAccount extends BankAccount {
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        System.out.println("收取1元手续费");
        super.deposit(amount - 1);
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("收取1元手续费");
        super.withdraw(amount + 1);
    }
}

class SavingAccount extends CheckingAccount {
    private double rate;
    private int count;

    public SavingAccount(double initialBalance) {
        super(initialBalance);
    }

    public void earnMonthlyInterest() {
        setBalance(getBalance() + getBalance() * rate);
        System.out.println("产生利息，重置免息次数");
        count = 0;
    }

    @Override
    public void deposit(double amount) {
        if (count++ < 3) {
            System.out.println("本次免息，还剩" + (3 - count) + "次");
            super.deposit(amount + 1);
        } else {
            super.deposit(amount);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (count++ < 3) {
            System.out.println("本次免息，还剩" + (3 - count) + "次");
            super.withdraw(amount - 1);
        } else {
            super.withdraw(amount);
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
