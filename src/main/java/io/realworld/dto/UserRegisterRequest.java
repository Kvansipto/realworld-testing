package io.realworld.dto;

import lombok.Builder;

@Builder
public record UserRegisterRequest(String email, String username, String password) {
}
