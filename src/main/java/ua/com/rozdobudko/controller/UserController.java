package ua.com.rozdobudko.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.rozdobudko.model.User;
import ua.com.rozdobudko.service.SecurityService;
import ua.com.rozdobudko.service.UserService;
import ua.com.rozdobudko.validator.UserValidator;

/**
 * Controller for {@link ua.com.rozdobudko.model.User}'s pages.
 */

//Аннотация для маркировки java класса, как класса контроллера.
//Данный класс представляет собой компонент, похожий на обычный сервлет (HttpServlet)
//(работающий с объектами HttpServletRequest и HttpServletResponse),
// но с расширенными возможностями от Spring Framework.
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET) //Только получаем информацию
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        //заполняем форму регистрации
        userValidator.validate(userForm, bindingResult);
        //сверяем правильность валидатором, если ошибки - остаемся на странице
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        // если все ок - сохраняем пользователя
        userService.save(userForm);

        //затем автологин зарегистрированного пользователя с редиректом на нужную страницу,
        // с передачей имени пользователя и паролем подтверждения
        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/product2";
    }
    //метод для страницы входа
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) { //если есть ошибки при входе - указываем
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) { //если вышли - даем сообщение о выходе
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }
    //контроллер для главной и welcome
    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "product2";
    }

    //контроллер для страницы /admin
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }
}
