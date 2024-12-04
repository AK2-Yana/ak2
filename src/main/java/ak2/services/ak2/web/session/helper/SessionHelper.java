package ak2.services.ak2.web.session.helper;

import ak2.services.ak2.common.view.Ak2RedirectView;
import org.springframework.stereotype.Component;

@Component
public class SessionHelper {

  public Ak2RedirectView redirectToSessionForm() {
    return new Ak2RedirectView("/ak2/session");
  }

  public Ak2RedirectView redirectToConfirmPage() {
    return new Ak2RedirectView("/ak2/session/check");
  }

  public Ak2RedirectView redirectToCompletePage() {

    return new Ak2RedirectView("/ak2/session/complete");
  }
}
