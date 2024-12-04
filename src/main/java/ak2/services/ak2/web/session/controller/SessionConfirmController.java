package ak2.services.ak2.web.session.controller;

import ak2.services.ak2.common.exceptions.PageNotFoundException;
import ak2.services.ak2.common.services.CsrfService;
import ak2.services.ak2.common.services.SessionService;
import ak2.services.ak2.common.view.Ak2ModelAndView;
import ak2.services.ak2.common.view.Ak2RedirectView;
import ak2.services.ak2.web.session.dto.SessionForm;
import ak2.services.ak2.web.session.enums.SessionEnum;
import ak2.services.ak2.web.session.helper.SessionHelper;
import ak2.services.ak2.web.session.page.SessionFormPage;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/session/check")
public class SessionConfirmController {

  @Autowired
  SessionService<SessionForm> sessionService;

  @Autowired
  SessionService<String> csrfSessionService;

  @Autowired
  CsrfService csrfService;

  @Autowired
  SessionHelper sessionHelper;

  @GetMapping
  public Ak2ModelAndView index(HttpSession httpSession) {

    final var sessionInfo = sessionService.getSession(SessionEnum.SESSION_ENUM.getKey(), httpSession).orElseThrow(PageNotFoundException::new);

    return new Ak2ModelAndView("/functions/session/sessionConfirm", new SessionFormPage(sessionInfo));
  }

  @PostMapping
  public Ak2RedirectView check(HttpSession httpSession) {
    return sessionHelper.redirectToCompletePage();
  }
}
