package dev.fabrix.user_service.controller;

public record RegisterRequest(
        String email,
        String password,
        String name) {
}
