package com.transaction.infra.persistence.domain;


import com.transaction.infra.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    @Getter
    @Enumerated(EnumType.ORDINAL)
    private UserType userType;
    @Column(name = "cpf_cnpj",unique = true, length = 14)
    @Getter
    private String cpfCnpj;
    @Getter
    @Setter
    @OneToOne
    private Account account;
}
