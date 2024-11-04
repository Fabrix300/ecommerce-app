package dev.fabrix.user_service.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserResponse(
        @JsonProperty("name") String name,
        @JsonProperty("email") String email) {
}
