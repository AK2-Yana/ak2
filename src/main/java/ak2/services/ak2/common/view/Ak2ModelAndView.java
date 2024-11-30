package ak2.services.ak2.common.view;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

public class Ak2ModelAndView extends ModelAndView {
  public Ak2ModelAndView(String htmlPage) {
    super(htmlPage, HttpStatus.OK);
  }

  public Ak2ModelAndView(String htmlPage, Object model) {
    super(htmlPage, "page", model);
    setStatus(HttpStatus.OK);
  }
}
