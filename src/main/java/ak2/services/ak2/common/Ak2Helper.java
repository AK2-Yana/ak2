package ak2.services.ak2.common;

import org.springframework.stereotype.Component;

import java.text.MessageFormat;

public abstract class Ak2Helper {

    //TODO: To transfer Error Page


    public Ak2RedirectView redirectToSecurePageWithSeeOther(String path) {
        return new Ak2RedirectView(path);
    }
}
