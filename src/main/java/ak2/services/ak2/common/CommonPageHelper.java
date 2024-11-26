package ak2.services.ak2.common;

import java.text.MessageFormat;

abstract class CommonPageHelper {

    public String redirectToSecurePageWithSeeOther(String path) {
        final var domain = "";
        return MessageFormat.format("redirect:{0}{1}", domain, path);
    }
}
