package ak2.services.ak2.web.session.controller;

import ak2.services.ak2.common.view.Ak2ModelAndView;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/session/complete")
public class SessionCompleteController {

  @GetMapping
  public Ak2ModelAndView index(HttpSession httpSession) {
    return new Ak2ModelAndView("/functions/session/sessionComplete");
  }
}
