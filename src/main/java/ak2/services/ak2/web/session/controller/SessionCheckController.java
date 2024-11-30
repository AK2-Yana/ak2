package ak2.services.ak2.web.session.controller;

import ak2.services.ak2.common.SessionService;
import ak2.services.ak2.common.view.Ak2ModelAndView;
import ak2.services.ak2.common.view.Ak2RedirectView;
import ak2.services.ak2.web.login.services.NewUserService;
import ak2.services.ak2.web.session.dto.SessionForm;
import ak2.services.ak2.web.session.enums.SessionEnum;
import ak2.services.ak2.web.session.helper.SessionHelper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/session")
public class SessionCheckController {
  @Autowired
  SessionService<SessionForm> sessionService;

  @Autowired
  NewUserService newUserService;

  @Autowired
  SessionHelper sessionHelper;

  @GetMapping
  public Ak2ModelAndView index(
      HttpSession httpSession
  ) {
    Optional<SessionForm> sessionInfo = sessionService.getSession(SessionEnum.SESSION_ENUM.getKey(), httpSession);
    return sessionInfo.map(sessionForm -> new Ak2ModelAndView("/functions/session", sessionForm))
        .orElseGet(() -> new Ak2ModelAndView("/functions/session"));
  }

  @PostMapping
  public Ak2RedirectView setSession(
      @ModelAttribute SessionForm session,
      HttpSession httpSession
  ) {
    sessionService.setSession(SessionEnum.SESSION_ENUM.getKey(), session, httpSession);
    return sessionHelper.redirectToSession();
  }
}
