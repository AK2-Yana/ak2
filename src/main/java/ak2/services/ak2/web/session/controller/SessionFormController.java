package ak2.services.ak2.web.session.controller;

import ak2.services.ak2.common.enums.CsrfEnum;
import ak2.services.ak2.common.services.CsrfService;
import ak2.services.ak2.common.services.SessionService;
import ak2.services.ak2.common.view.Ak2ModelAndView;
import ak2.services.ak2.common.view.Ak2RedirectView;
import ak2.services.ak2.web.session.dto.SessionForm;
import ak2.services.ak2.web.session.enums.SessionEnum;
import ak2.services.ak2.web.session.helper.SessionHelper;
import ak2.services.ak2.web.session.page.SessionFormPage;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/session")
public class SessionFormController {
  @Autowired
  SessionService<SessionForm> sessionService;

  @Autowired
  SessionHelper sessionHelper;

  @Autowired
  CsrfService csrfService;

  @Autowired
  SessionService<String> csrfSessionService;

  private Logger log = LoggerFactory.getLogger(getClass());

  @GetMapping
  public Ak2ModelAndView index(
      HttpSession httpSession
  ) {
    Optional<SessionForm> sessionInfo = sessionService.getSession(SessionEnum.SESSION_ENUM.getKey(), httpSession);

    String csrf = csrfService.generateCsrf();
    csrfSessionService.setSession(CsrfEnum.CSRF_KEY.getKey(), csrf, httpSession);

    return sessionInfo.map(sessionForm -> new Ak2ModelAndView("/functions/session/sessionForm", new SessionFormPage(sessionForm, csrf)))
        .orElseGet(() -> new Ak2ModelAndView("/functions/session/sessionForm", new SessionFormPage(csrf)));
  }

  @PostMapping
  public Ak2RedirectView setSession(
      @RequestParam Map<String, String> allRequestParams,
      @RequestParam("csrf") String customCsrf,
      HttpSession httpSession
  ) {
    Optional<String> csrfFromSession = csrfSessionService.getSession(CsrfEnum.CSRF_KEY.getKey(), httpSession);

    if (csrfFromSession.isPresent()) {
      if (!csrfService.compareCsrfToken(csrfFromSession.get(), customCsrf)) {
        log.info("csrf does not match");
        return sessionHelper.redirectToSessionForm(); // TODO: actually redirect to page to describe session expired
      }
      var session = new SessionForm(allRequestParams);
      sessionService.setSession(SessionEnum.SESSION_ENUM.getKey(), session, httpSession);
      return sessionHelper.redirectToConfirmPage();
    }
    return sessionHelper.redirectToSessionForm();
  }
}
