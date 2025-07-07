package com.banking.bms.repository;

import com.banking.bms.model.entities.Passbook;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassbookRepository extends JpaRepository<Passbook, String> {

    List<Passbook> findByAccountAccountId(String accountId, Sort sortDirection);
}
