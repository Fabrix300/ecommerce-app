package dev.fabrix.backend.auth.dto;

public record LoginRequest(
        String email,
        String password) {
}
