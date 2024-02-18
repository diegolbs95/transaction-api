package com.transaction.infra.persistence.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Builder
@Entity
@Table(name = "tb_accout")
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String accountNumber;
    @Column(name = "cpf_cnpj_titular")
    private String cpfCnpjHolder;
    @Getter
    @Setter
    private BigDecimal balance;
    private String openDate;
    private String closingDate;

}
