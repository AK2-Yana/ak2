package ak2.services.ak2.web.top.controller;

import ak2.services.ak2.common.view.Ak2ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class TopController {
  @GetMapping("/top")
  public Ak2ModelAndView getTop() {
    return new Ak2ModelAndView("/top/ak-top");
  }
}