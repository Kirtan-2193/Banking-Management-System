package com.banking.bms.repository;

import com.banking.bms.model.entities.Passbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassbookRepository extends JpaRepository<Passbook, String> {
}
