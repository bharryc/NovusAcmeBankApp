package org.example.dao;

import org.example.model.*;

import java.io.*;
import java.util.*;

public class AccountDaoImpl implements AccountDao {

    private final Map<String, Account> accounts; // Store accounts in memory

    public AccountDaoImpl() {
        // Initialize the accounts map
        accounts = new HashMap<>();
        loadAllAccountsFromFiles();

    }

    @Override
    public void addAccount(Account acc) {
        // Add the account to the in-memory map
        accounts.put(acc.getAccountNumber(), acc);

        saveAccountToFile(acc);


    }

    // Saves account to file based on the type.
    private void saveAccountToFile(Account acc) {
        if (acc instanceof ISAAccount) {
            saveAccountToFile(acc, "AccountNumber,AccountType,AccountBalance,UserID,LastInterestCalculationDate");
        } else if (acc instanceof BusinessAccount) {
            saveAccountToFile(acc, "AccountNumber,AccountType,AccountBalance,UserID,businessName,businessAddress,hasBusinessChequeBook,hasDebitCard,hasCreditCard,hasOverdraft,canAccessInternationalTrading,canAccessLoans");
        } else {
            saveAccountToFile(acc, "AccountNumber,AccountType,AccountBalance,UserID");
        }
    }

    // Saves account to file.
    private void saveAccountToFile(Account acc, String header) {
        String directoryPath = "src/accounts/"; // Specify the directory path
        String filename = directoryPath + acc.getType() + "_" + acc.getAccountNumber();

        try {
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs(); // Create the directory if it doesn't exist
            }

            File file = new File(filename);
            boolean fileExists = file.exists();

            FileOutputStream fos = new FileOutputStream(file, true);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

            if (!fileExists) {
                writer.write(header);
                writer.newLine();
            }

            String accountLine = acc.getAccountNumber() + ","
                    + acc.getType() + ","
                    + acc.getBalance() + ","
                    + acc.getUserId();

            if (acc instanceof ISAAccount) {
                ISAAccount isaAccount = (ISAAccount) acc;
                accountLine += "," + isaAccount.getLastInterestCalculationDate();
            } else if (acc instanceof BusinessAccount) {
                BusinessAccount businessAccount = (BusinessAccount) acc;
                accountLine += ","
                        + businessAccount.getBusinessName() + ","
                        + businessAccount.getBusinessAddress() + ","
                        + businessAccount.isHasBusinessChequeBook() + ","
                        + businessAccount.isHasDebitCard() + ","
                        + businessAccount.isHasCreditCard() + ","
                        + businessAccount.isHasOverdraft() + ","
                        + businessAccount.canAccessInternationalTrading() + ","
                        + businessAccount.canAccessLoans();
            }

            writer.write(accountLine);
            writer.newLine();

            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Account getAccountByAccountNumber(String id) {
        return accounts.get(id); // Retrieve the account from the in-memory map

    }

    @Override
    public List<Account> getAllUserAccounts(Long userId) {
        List<Account> userAccounts = new ArrayList<>();

        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            Account account = entry.getValue();
            if (account.getUserId() == userId) {
                userAccounts.add(account);
            }
        }
        return userAccounts;
    }

    public void loadAllAccountsFromFiles() {
        String directoryPath = "src/accounts/";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] accountFiles = directory.listFiles();

            if (accountFiles != null) {
                for (File file : accountFiles) {
                    if (file.isFile()) {
                        String filename = file.getName();
                        String[] parts = filename.split("_");

                        if (parts.length == 2) {
                            String accountType = parts[0];
                            String accountNumber = parts[1];

                            // Read the account file and add it to the map
                            Account account = readAccountFromFile(file, accountType, accountNumber);
                            if (account != null) {
                                accounts.put(account.getAccountNumber(), account);
                            }
                        }
                    }
                }
            }
        }
    }

    private Account readAccountFromFile(File file, String accountType, String accountNumber) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            reader.readLine(); // Skip the header line

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    double accountBalance = Double.parseDouble(parts[2]);
                    Long userId = Long.parseLong(parts[3]);

                    // Create an account object based on accountType
                    Account account;
                    if ("PA".equals(accountType)) {
                        account = new PersonalAccount(accountNumber, userId);
                    } else if ("ISA".equals(accountType)) {
                        account = new ISAAccount(accountNumber, userId);
                    } else if ("BA".equals(accountType)) {
                        account = new BusinessAccount(accountNumber, userId);
                    } else {
                        // Unsupported account type
                        continue;
                    }

                    account.setType(accountType);
                    account.setBalance(accountBalance);

                    return account;
                }
            }

            reader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

}
