package dev.fabrix.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.fabrix.user_service.model.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {

}
