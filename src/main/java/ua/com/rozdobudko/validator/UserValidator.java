package ua.com.rozdobudko.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.rozdobudko.model.User;
import ua.com.rozdobudko.service.UserService;

/**
 * Validator for {@link ua.com.rozdobudko.model.User} class,
 * implements {@link Validator} interface.
 */

@Component //просто так компонент: generic stereotype for any Spring-managed component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override //подтверждаем, что является экземпляром класса User
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        //ошибки для имени пользователя
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }

        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        //ошибки для пароля
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }

        //ошибки для имени
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");

        //ошибки для фамилии
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "Required");

        //ошибки для номера телефона
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tel", "Required");
        if (user.getTel().length() != 12) {
            errors.rejectValue("tel", "Incorrect.userForm.telephone");
        }

        //ошибки для электронной почты
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");
        if (user.getEmail().length() < 5 || !user.getEmail().contains("@")) {
            errors.rejectValue("email", "Incorrect.userForm.email");
        }
    }
}
