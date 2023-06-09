package com.telran.bankapplication.entity;

import com.telran.bankapplication.enums.AccountStatus;
import com.telran.bankapplication.enums.AccountType;
import com.telran.bankapplication.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private AccountType type;
    @Enumerated(EnumType.ORDINAL)
    private AccountStatus status;
     private double balance;
   @Enumerated(EnumType.ORDINAL)
   @Column(name = "currency_code")
    private  CurrencyType currencyCode;
    @Column(name = "created_at")
    private LocalDateTime dataCreated;
    @Column(name = "updated_at")
    private LocalDateTime dataUpdated;

    @ManyToOne(cascade = {MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
    @OneToMany(mappedBy = "debitAccount")
    private List<Transaction> transactionDebit;
    @OneToMany(mappedBy = "creditAccount")
    private List<Transaction> transactionCredit;
    @OneToOne(cascade = {MERGE, PERSIST, REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "agreement_id", referencedColumnName = "id")
    private Agreement agreement;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account that = (Account) o;
        return Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}


