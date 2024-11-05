package dev.fabrix.backend.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserResponse(
        @JsonProperty("name") String name,
        @JsonProperty("email") String email) {
}
