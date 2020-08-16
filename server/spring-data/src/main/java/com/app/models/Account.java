package com.app.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Account extends AbstractEntity implements Serializable {
    @Column(name = "number", unique = true, nullable = false, updatable = false)
    private String number;
    @Column(name= "currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Column(name = "balance")
    private Double balance;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name ="customer_id",
            referencedColumnName = "id",
            nullable = false,
            updatable = false)
    private Customer customer;
}
