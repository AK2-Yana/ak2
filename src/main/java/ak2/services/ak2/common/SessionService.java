package ak2.services.ak2.common;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SessionService<T> {

    public void setSession(String key, Object value, HttpSession httpSession) {
        httpSession.setAttribute(key, value);
    }

    public Optional<T> getSession(String key, HttpSession httpSession) {
        return Optional.ofNullable((T) httpSession.getAttribute(key));
    }

    @SuppressWarnings("unchecked")
    public void removeSession(String key, HttpSession httpSession) {
        httpSession.removeAttribute(key);
    }

    public void invalidateSession(HttpSession httpSession) {
        httpSession.invalidate();
    }
}
