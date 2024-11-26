package ak2.services.ak2.web.enums;

public enum SessionEnum {
    SESSION_ENUM("session_key");

    private final String key;

    SessionEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
