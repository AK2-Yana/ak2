package ak2.services.ak2.common.services;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class CsrfService {

  public boolean compareCsrfToken(String currentCsrf, String sessionCsrf) {
    return currentCsrf.equals(sessionCsrf);
  }

  public String generateCsrf() {
    SecureRandom secureRandom = new SecureRandom();
    byte[] token = new byte[32];
    secureRandom.nextBytes(token);
    return Base64.getUrlEncoder().encodeToString(token);
  }
}
