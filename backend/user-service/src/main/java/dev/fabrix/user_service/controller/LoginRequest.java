package dev.fabrix.user_service.controller;

public record LoginRequest(
        String email,
        String password) {
}
