package com.example.validation.handlers;

import com.example.validation.domain.SignUpCommand;
import com.example.validation.domain.ValidationResult;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class CommandConstraintsValidationStep extends ValidationStep<SignUpCommand> {

    @Override
    public ValidationResult validate(SignUpCommand command) {
        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            final Validator validator = validatorFactory.getValidator();
            final Set<ConstraintViolation<SignUpCommand>> constraintsViolations = validator.validate(command);

            if (!constraintsViolations.isEmpty()) {
                return ValidationResult.invalid(constraintsViolations.iterator().next().getMessage());
            }
        }
        return checkNext(command);
    }
}