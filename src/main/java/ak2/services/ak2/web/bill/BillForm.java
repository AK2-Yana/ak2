package ak2.services.ak2.web.bill;

import ak2.services.ak2.common.view.Ak2ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bill")
public class BillForm {

  @GetMapping
  public Ak2ModelAndView index() {
    return new Ak2ModelAndView("/bill/bill_form");
  }

  
}
