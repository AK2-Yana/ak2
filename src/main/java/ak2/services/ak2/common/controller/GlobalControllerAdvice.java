package ak2.services.ak2.common.controller;

import ak2.services.ak2.common.exceptions.PageNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerAdvice {

  private Logger log = LoggerFactory.getLogger(getClass());

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(PageNotFoundException.class)
  public String pageNotFound(PageNotFoundException e) {
    log.error(e.getMessage());
    return "/errors/404";
  }
}
