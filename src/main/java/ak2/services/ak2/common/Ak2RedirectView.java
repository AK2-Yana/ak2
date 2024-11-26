package ak2.services.ak2.common;

import org.springframework.web.servlet.view.RedirectView;

public class Ak2RedirectView extends RedirectView {

    public Ak2RedirectView(String path){
        super("http://ak2.prod.jp.local" + path);
    }

}
