package com.banking.controller;

import com.banking.dto.BankAccount;
import com.banking.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bankaccount")
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping
    public List<BankAccount> getAllAccounts() {return bankAccountService.getAllAccounts();};
    @PostMapping
    public BankAccount addRecord(@RequestBody BankAccount bankAccount) {return bankAccountService.addOrUpdateBankAccount(bankAccount);}

    @PutMapping
    public BankAccount updateRecord(@RequestBody BankAccount bankAccount) {return bankAccountService.addOrUpdateBankAccount(bankAccount);}

    @DeleteMapping("/{actNumber}")
    public void deleteRecord(@PathVariable int actNumber) {bankAccountService.deleteAccountById(actNumber);}

    @GetMapping("/{actNumber}")
    public BankAccount findAccount(@PathVariable int actNumber) {return bankAccountService.findAccountById(actNumber);}

    @GetMapping("balance/{actNumber}")
    public int fetchBalance(@PathVariable int actNumber) {
        return bankAccountService.findAccountById(actNumber).getActBalance();
    }

    @GetMapping("filter/{actBalance}")
    public List<BankAccount> fetchAccountBalanceGreaterOrEqual(@PathVariable int actBalance) {
        return bankAccountService.fetchAccBalanceGreaterOrEqual(actBalance);
    }

}
