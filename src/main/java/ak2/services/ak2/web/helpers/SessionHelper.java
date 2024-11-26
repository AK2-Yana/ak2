package ak2.services.ak2.web.helpers;

import ak2.services.ak2.common.Ak2Helper;
import ak2.services.ak2.common.Ak2ModelAndView;
import ak2.services.ak2.common.Ak2RedirectView;
import org.springframework.stereotype.Component;

@Component
public class SessionHelper  extends Ak2Helper {

    public Ak2RedirectView redirectToSession() {
        return super.redirectToSecurePageWithSeeOther("/ak2/session");
    }
}
