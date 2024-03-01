package com.transaction.infra.persistence.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Builder
@Entity
@Table(name = "tb_accounts")
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String accountNumber;
    @Column(name = "cpf_cnpj_holder",unique = true, length = 14)
    private String cpfCnpjHolder;
    @Getter
    @Setter
    private BigDecimal balance;
    @Column(length = 19)
    private String openDate;
    @Column(length = 19)
    private String closingDate;

}
