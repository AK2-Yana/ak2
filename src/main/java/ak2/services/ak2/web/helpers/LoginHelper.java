package ak2.services.ak2.web.helpers;

import ak2.services.ak2.common.Ak2Helper;
import ak2.services.ak2.common.Ak2ModelAndView;
import ak2.services.ak2.common.Ak2RedirectView;
import org.springframework.stereotype.Component;

@Component
public class LoginHelper extends Ak2Helper {

    public Ak2RedirectView redirectToLoginPage() {
        return super.redirectToSecurePageWithSeeOther("/ak2/login");
    }

    public Ak2RedirectView redirectToNewUser() {
        return super.redirectToSecurePageWithSeeOther("/ak2/login/new");
    }
}
