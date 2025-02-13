package com.testcontainers.examples.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Default API error response")
public record ErrorResponseDto(
        @Schema(description = "Code error", example = "500") int status,
        @Schema(description = "Message error", example = "Default error message") String message) {
}
