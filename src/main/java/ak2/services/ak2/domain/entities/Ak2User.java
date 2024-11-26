package ak2.services.ak2.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static ak2.services.ak2.domain.constraint.UserConstants.ACTIVE_USER;

@Entity
@Table(name = "users")
@Data
public class Ak2User implements Serializable {
    @Id
    private String userId = "";

    private String password = "";

    private String enabled = ACTIVE_USER;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<UserAuthority> roles = new HashSet<>();
}
