package com.transaction.infra.persistence.domain;


import com.transaction.infra.enums.UserEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.intellij.lang.annotations.Pattern;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.ORDINAL)
    private UserEnum userEnum;
    @Column(name = "cpf_cnpj",unique = true)
    @Pattern("\\d{11}|\\d{14}")
    private String cpfCnpj;
}
