package com.example.validation.domain;

import lombok.Value;

import javax.validation.constraints.*;

@Value
public class SignUpCommand {

    @Min(2)
    @Max(40)
    @NotBlank
    String firstName;

    @Min(2)
    @Max(40)
    @NotBlank
    String lastName;

    @Min(2)
    @Max(40)
    @NotBlank
    String username;

    @NotBlank
    @Size(max = 60)
    @Email
    String email;

    @NotBlank
    @Size(min = 6, max = 20)
    String rawPassword;
}