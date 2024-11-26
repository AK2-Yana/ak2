package ak2.services.ak2.web.controller;

import ak2.services.ak2.common.Ak2ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {
    public Ak2ModelAndView getError() {
        return new Ak2ModelAndView("/common/error");
    }
}
