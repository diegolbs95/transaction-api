package com.transaction.infra.persistence.repository;

import com.transaction.infra.persistence.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByCpfCnpj(String cpfCnpj);
}
