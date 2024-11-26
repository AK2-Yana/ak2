package ak2.services.ak2.domain.services;

import ak2.services.ak2.domain.repos.Ak2UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ak2UserService {

    @Autowired
    Ak2UserRepository akUserRepository;

    public Boolean hasUserInfo(String id) {
        return akUserRepository.selectUserInfoById(id).isPresent();
    }
}
