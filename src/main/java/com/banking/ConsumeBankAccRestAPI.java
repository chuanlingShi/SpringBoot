package com.banking;

import com.banking.dto.BankAccount;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConsumeBankAccRestAPI {
    public static RestTemplate template = new RestTemplate();
    public static String bankAccountAPIUrl = "http://localhost:8080/api/bankaccount";

    public static void main(String[] args) {
        getAllBankAccounts();
    }

    public static void addAccount(BankAccount account) {
        System.out.println("Adding account");
        BankAccount added = template.postForObject(bankAccountAPIUrl, account, BankAccount.class);
        System.out.println("Account added." + added);
    }

    public static void deleteAccount(int accNumber) {
        System.out.println("deleting account...");
        String accountdeleteAPIUrl ="http://localhost:8080/api/account/{accNumber}";

        Map<String,Integer> params = new HashMap<>();
        params.put("accNumber", accNumber);
        template.delete(accountdeleteAPIUrl,params);

        System.out.println("Account deleted...");
    }

    public static void getAllBankAccounts() {
        BankAccount accounts[] = template.getForObject(bankAccountAPIUrl, BankAccount[].class);
        Arrays.asList(accounts).stream().forEach(System.out::println);
    }
}
