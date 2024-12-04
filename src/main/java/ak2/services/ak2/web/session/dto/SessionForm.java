package ak2.services.ak2.web.session.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

public record SessionForm(
    String sessionValue
) implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  public SessionForm(Map<String, String> allRequestParams) {
    this(allRequestParams.getOrDefault("sessionValue", ""));
  }
}
