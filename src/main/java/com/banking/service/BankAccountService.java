package com.banking.service;

import com.banking.dao.BankAccountRepository;
import com.banking.dto.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public BankAccount addOrUpdateBankAccount(BankAccount bankAccount) {
        BankAccount newBankAccount = null;
        if (bankAccount != null)
        {newBankAccount = bankAccountRepository.save(bankAccount);}

        return newBankAccount;
    }

    public List<BankAccount> getAllAccounts(){return bankAccountRepository.findAll();}

    public void deleteAccountById(int accNumber) {bankAccountRepository.deleteById(accNumber);}

    public BankAccount findAccountById(int accNumber) {
        return bankAccountRepository.findById(accNumber).orElse(new BankAccount(999, "test", 0));
    }

    public List<BankAccount> fetchAccBalanceGreaterOrEqual(int balance) {
        return bankAccountRepository.findByActBalanceGreaterThanEqual(balance);
    }

}
