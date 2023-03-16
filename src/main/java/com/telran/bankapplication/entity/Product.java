package com.telran.bankapplication.entity;

import com.telran.bankapplication.enums.CurrencyType;
import com.telran.bankapplication.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private ProductStatus status;
    @Column(name = "currency_code")
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyCode;
    @Column(name = "interest_rate")
    private Double interestRate;
    private Integer limit;
    @Column(name = "created_at")
    private LocalDateTime dataProductCreated;
    @Column(name = "updated_at")
    private LocalDateTime dataProductUpdated;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "manager_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "manager_id"))
    private Set<Manager> managerSet = new HashSet<>();
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,
            orphanRemoval = true, cascade = {MERGE, PERSIST, REFRESH})
    private List<Agreement> agreementList;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product that = (Product) o;
        return Objects.equals(this.id, that.id);
                }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
