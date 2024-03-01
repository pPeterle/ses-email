package com.peterle.emailservice.core.dto;

public record EmailRequestDTO(String to, String subject, String body) {
}
