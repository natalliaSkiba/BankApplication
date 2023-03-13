package com.telran.bankapplication.entity;

import com.telran.bankapplication.enums.ClientStatus;
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
@Table(name = "clients")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.ORDINAL)
    private ClientStatus status;
    @Column(name = "tax_code")
    private String taxCode;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String address;
    private String phone;
    @Column(name = "created_at")
    private LocalDateTime dataClientCreated;
    @Column(name = "updated_at")
    private LocalDateTime dataClientUpdated;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY,
    orphanRemoval = true, cascade = {MERGE, PERSIST, REFRESH})
    private List<Account> accountList;
    @ManyToOne(cascade = {MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private Manager manager;
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Client that = (Client) o;
        return Objects.equals(this.taxCode, that.taxCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxCode);
    }

}
