package dev.fabrix.backend.auth.dto;

public record RegisterRequest(
        String email,
        String password,
        String name) {
}
