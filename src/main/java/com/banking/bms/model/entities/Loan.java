package com.banking.bms.model.entities;

import com.banking.bms.enumerations.LoanStatus;
import com.banking.bms.enumerations.LoanType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.Random;

@Entity
@Table(name = "loan")
@Data
public class Loan {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "loan_id")
    private String loanId;

    @Column(name = "loan_number", unique = true)
    private Long loanNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "loan_type")
    private LoanType loanType;

    @Column(name = "loan_amount")
    private double loanAmount;

    @Column(name = "interest_rate")
    private double interestRate;

    @Column(name = "loan_term")
    private Integer loanTerm;

    @Enumerated(EnumType.STRING)
    @Column(name = "loan_status")
    private LoanStatus loanStatus = LoanStatus.PENDING;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    private Long accountNumber;

    @ManyToOne
    @JoinColumn(name = "approved_by")
    private User approvedBy;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "emi_paid_count")
    private Integer emiPaidCount = 0;


    @PrePersist
    protected void onCreate() {
        this.loanNumber = generateLoanNumber();
    }

    private Long generateLoanNumber() {
        Random random = new Random();
        long min = 1000L;
        long max = 9999L;
        return min + ((long) (random.nextDouble() * (max - min)));
    }
}
