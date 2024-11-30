package ak2.services.ak2.web.session.helper;

import ak2.services.ak2.common.view.Ak2RedirectView;
import org.springframework.stereotype.Component;

@Component
public class SessionHelper {

  public Ak2RedirectView redirectToSession() {
    return new Ak2RedirectView("/ak2/session");
  }
}
