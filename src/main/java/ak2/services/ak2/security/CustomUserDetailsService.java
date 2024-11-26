package ak2.services.ak2.security;

import ak2.services.ak2.domain.entities.Ak2User;
import ak2.services.ak2.domain.repos.Ak2UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    Ak2UserRepository akUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Ak2User> user = getUserWithLazyLoading(username);
        if (user.isPresent()) {
            return new CustomUserDetails(user.get());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    @Transactional
    public Optional<Ak2User> getUserWithLazyLoading(String userId) {
        Optional<Ak2User> user = akUserRepository.findById(userId);
        if (user.isPresent() && user.get().getRoles() != null) {
            user.get().getRoles().forEach(System.out::println);
        }
        return user;
    }
}
