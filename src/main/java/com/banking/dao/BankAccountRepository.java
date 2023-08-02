package com.banking.dao;

import com.banking.dto.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
    List<BankAccount> findByActBalanceGreaterThanEqual(int balance);

    BankAccount findByCustomerName(String name);
}
