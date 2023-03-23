package com.telran.bankapplication.entity;

import com.telran.bankapplication.entity.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Objects;
import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "agreements")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Agreement {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "interest_rate")
    private Double interestRateAgreement;
    @Enumerated(EnumType.STRING )
    private AccountStatus status;
    private Double sum;
    @Column(name = "created_at")
    private LocalDateTime dataAgreementCreated;
    @Column(name = "updated_at")
    private LocalDateTime dataAgreementUpdated;
    @OneToOne(mappedBy = "agreement", fetch = FetchType.LAZY,
            orphanRemoval = true, cascade = {MERGE, PERSIST, REFRESH})
    private Account account;
    @ManyToOne(cascade = {MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Agreement that = (Agreement) o;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
