package ak2.services.ak2.web.login.helper;

import ak2.services.ak2.common.view.Ak2RedirectView;
import org.springframework.stereotype.Component;

@Component
public class LoginHelper {

  public Ak2RedirectView redirectToLoginPage() {
    return new Ak2RedirectView("/ak2/login");
  }

  public Ak2RedirectView redirectToNewUser() {
    return new Ak2RedirectView("/ak2/login/new");
  }
}
