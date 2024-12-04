package ak2.services.ak2.common.enums;

public enum CsrfEnum {
  CSRF_KEY("ak2_csrf_session");

  private final String key;

  CsrfEnum(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }
}
