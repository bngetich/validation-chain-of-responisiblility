package com.example.validation.handlers;

import com.example.validation.domain.SignUpCommand;
import com.example.validation.domain.ValidationResult;

public class EmailDuplicationValidationStep extends ValidationStep<SignUpCommand> {

    private final UserRepository userRepository;

    @Override
    public ValidationResult validate(SignUpCommand command) {
        if (userRepository.findByEmail(command.getEmail()).isPresent()) {
            return ValidationResult.invalid(String.format("Email [%s] is already taken", command.getEmail()));
        }
        return checkNext(command);
    }
}
