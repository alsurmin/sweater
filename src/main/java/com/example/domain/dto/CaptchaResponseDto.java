package com.example.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CaptchaResponseDto {
    private boolean success;
    @JsonAlias("error-codes")
    Set<String> errorCodes;
}
