package ak2.services.ak2.web.login.services;

import ak2.services.ak2.domain.entities.Ak2User;
import ak2.services.ak2.domain.repos.Ak2UserRepository;
import ak2.services.ak2.web.login.dto.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class NewUserService {

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  Ak2UserRepository akUserRepository;

  public Ak2User mapToAkUser(UserForm userForm) {
    // userForm から AkUser を生成
    Ak2User akUser = new Ak2User();
    akUser.setUserId(userForm.username());
    akUser.setPassword(encoder(userForm.password())); // パスワードをエンコード
    akUser.setEnabled("Y"); // ACTIVE_USER として設定 (ACTIVE_USER が "Y" の場合)
    return akUser;
  }

  public void registerUser(Ak2User akUser) {
    akUserRepository.save(akUser);
  }

  private String encoder(String password) {
    return passwordEncoder.encode(password);
  }
}

