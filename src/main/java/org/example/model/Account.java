package org.example.model;

public class Account {
        private String accountNumber;
        private String type = "PA";
        private double balance = 0;
        private boolean isRed;
        private long userId;

        public Account() {
        }

        public Account(String accountNumber, long userId) {
            this.accountNumber = accountNumber;
            this.userId = userId;
        }

        // Deposit cash.
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                isRed = false;
                System.out.println("Deposited £" + amount + " to " + getType() + " account (" + getAccountNumber() + ")");
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        // Withdraw cash.
        public void withdraw(double amount) {
            if (amount > 0) {
                if (balance >= amount) {
                    balance -= amount;
                    isRed = false;
                    System.out.println("Withdrawn £" + amount + " from " + getType() + " account (" + getAccountNumber() + ")");
                } else {
                    isRed = true;
                    System.out.println("Insufficient balance. Account is now in the red.");
                }
            } else {
                System.out.println("Invalid withdrawal amount.");
            }
        }

        public void getDescription() {
            System.out.println("This are the general rules of the accounts.");
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public boolean isRed() {
            return isRed;
        }

        public void setRed(boolean red) {
            isRed = red;
        }

        public long getUserId() {
            return userId;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "user=" + userId +
                    ", accountNumber='" + accountNumber + '\'' +
                    ", type='" + type + '\'' +
                    ", balance=" + balance +
                    '}';
        }
    }
