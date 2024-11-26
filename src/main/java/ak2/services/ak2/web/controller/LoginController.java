package ak2.services.ak2.web.controller;

import ak2.services.ak2.common.Ak2Helper;
import ak2.services.ak2.common.Ak2ModelAndView;
import ak2.services.ak2.common.Ak2RedirectView;
import ak2.services.ak2.domain.entities.Ak2User;
import ak2.services.ak2.domain.services.Ak2UserService;
import ak2.services.ak2.web.dto.UserForm;
import ak2.services.ak2.web.helpers.LoginHelper;
import ak2.services.ak2.web.services.NewUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

//    private final Ak2Helper ak2Helper;
    @Autowired
    Ak2UserService ak2UserService;

    @Autowired
    NewUserService newUserService;

    @Autowired
    LoginHelper loginHelper;

    @GetMapping
    public Ak2ModelAndView login() {
        return new Ak2ModelAndView("/common/login");
    }

    @GetMapping("/new")
    public Ak2ModelAndView index(HttpSession httpSession) {
        return new Ak2ModelAndView("/common/new-user");
    }

    @PostMapping("/new")
    public Ak2RedirectView create(@Validated @ModelAttribute UserForm userForm, BindingResult bindingResult) throws IllegalAccessException {
        if (bindingResult.hasErrors()) {
            return loginHelper.redirectToNewUser();
        }

        if (ak2UserService.hasUserInfo(userForm.username())) {
            throw new IllegalAccessException();
        }

        Ak2User akUser = newUserService.mapToAkUser(userForm);
        newUserService.registerUser(akUser);
        return loginHelper.redirectToLoginPage();
    }
}
