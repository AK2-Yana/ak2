package ak2.services.ak2.web.session.page;

import ak2.services.ak2.web.session.dto.SessionForm;

public record SessionFormPage(
    SessionForm sessionForm,
    String csrf
) {
  public SessionFormPage(String csrf) {
    this(null, csrf);
  }

  public SessionFormPage(SessionForm sessionForm) {
    this(sessionForm, "");
  }
}
