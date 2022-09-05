package com.example.validation.handlers;

import com.example.validation.domain.SignUpCommand;
import com.example.validation.domain.ValidationResult;

public  class UsernameDuplicationValidationStep extends ValidationStep<SignUpCommand> {

    private final UserRepository userRepository;

    @Override
    public ValidationResult validate(SignUpCommand command) {
        if (userRepository.findByUsername(command.getUsername()).isPresent()) {
            return ValidationResult.invalid(String.format("Username [%s] is already taken", command.getUsername()));
        }
        return checkNext(command);
    }
}
