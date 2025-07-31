package com.banking.bms.repository;

import com.banking.bms.enumerations.LoanStatus;
import com.banking.bms.model.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, String> {

    @Query(value = "SELECT DISTINCT l.* " +
            "FROM loan l " +
            "WHERE (:search IS NULL OR CAST(l.loan_number AS TEXT) ILIKE CONCAT('%', :search, '%'))",
            nativeQuery = true)
    List<Loan> findAllLoan(@Param("search") Long search);

    Loan findByLoanNumber(Long loanNumber);

    List<Loan> findByLoanStatusInAndNextEmiDueDate(List<LoanStatus> loanStatus, LocalDate currentDate);
}
