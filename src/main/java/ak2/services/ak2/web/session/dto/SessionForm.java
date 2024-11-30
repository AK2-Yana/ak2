package ak2.services.ak2.web.session.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class SessionForm implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  public String sessionValue = "No Data was found";
}
