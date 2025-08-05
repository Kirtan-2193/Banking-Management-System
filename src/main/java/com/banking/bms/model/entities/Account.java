package com.banking.bms.model.entities;

import com.banking.bms.enumerations.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Random;

@Entity
@Table(name = "accounts")
@Data
public class Account {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid")
    @Column(name = "account_id")
    private String accountId;

    @Column(name = "account_number", unique = true)
    private Long accountNumber;

    @Column(name = "account_branch")
    private String accountBranch;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "account_balance")
    private double accountBalance;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status")
    private Status status = Status.ACTIVE;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Passbook> passbook;



    @PrePersist
    protected void onCreate() {
        this.accountNumber = generateAccountNumber();
    }

    private Long generateAccountNumber() {
        Random random = new Random();
        long min = 800000000000L;
        long max = 899999999999L;
        return min + ((long) (random.nextDouble() * (max - min)));
    }
}
