package com.banking.bms.repository;

import com.banking.bms.enumerations.Status;
import com.banking.bms.model.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    List<Account> findByUserUserId(String userId);

    Optional<Account> findByAccountNumber(Long accountNumber);

    List<Account> findByAccountStatusAndNextInterestDate(Status accountStatus, LocalDate nextInterestDate);

    List<Account> findByUserUserIdAndAccountStatusNot(String userId, Status accountStatus);
}
