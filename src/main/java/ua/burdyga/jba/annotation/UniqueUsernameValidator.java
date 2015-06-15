package ua.burdyga.jba.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import ua.burdyga.jba.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (userRepository == null) {       // called only during InitDbService.init() method
            return true;
        }
        return userRepository.findByName(username) == null;
    }
}
