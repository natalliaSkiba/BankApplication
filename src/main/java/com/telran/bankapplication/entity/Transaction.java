package com.telran.bankapplication.entity;

import com.telran.bankapplication.entity.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
@Entity
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    private double amount;
    private String description;
    @Column(name = "created_at")
    private LocalDateTime dataTransactionCreated;
    @ManyToOne()
    @JoinColumn(name = "debit_account_id", referencedColumnName = "id")
    private Account debitAccount;
    @ManyToOne()
    @JoinColumn(name = "credit_account_id", referencedColumnName = "id")
    private Account creditAccount;
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transaction that = (Transaction) o;
        return Objects.equals(this.id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
