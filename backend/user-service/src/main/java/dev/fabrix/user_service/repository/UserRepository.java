package dev.fabrix.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.fabrix.user_service.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
