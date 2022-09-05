package com.example.validation;

import com.example.validation.domain.SignUpCommand;
import com.example.validation.domain.ValidationResult;
import com.example.validation.handlers.CommandConstraintsValidationStep;
import com.example.validation.handlers.EmailDuplicationValidationStep;
import com.example.validation.handlers.UsernameDuplicationValidationStep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultSignUpValidationService implements SignUpValidationService {

    private final UserRepository userRepository;

    @Override
    public ValidationResult validate(SignUpCommand command) {
        return new CommandConstraintsValidationStep()
                .linkWith(new UsernameDuplicationValidationStep(userRepository))
                .linkWith(new EmailDuplicationValidationStep(userRepository))
                .validate(command);
    }
}