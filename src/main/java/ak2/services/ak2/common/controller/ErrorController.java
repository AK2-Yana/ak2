package ak2.services.ak2.common.controller;

import ak2.services.ak2.common.view.Ak2ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {
  //TODO: To transfer Error Page
  public Ak2ModelAndView getError() {
    return new Ak2ModelAndView("/common/error");
  }
}
