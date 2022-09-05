package com.example.validation;

import com.example.validation.domain.SignUpCommand;
import com.example.validation.domain.ValidationResult;

public interface SignUpValidationService {

    ValidationResult validate(SignUpCommand command);
}
