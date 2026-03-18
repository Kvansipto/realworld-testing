package io.realworld.dto;

import lombok.Builder;

@Builder
public record UserRegisterResponse(String email, String username, String token) {
}
