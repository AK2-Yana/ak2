package ak2.services.ak2.security;

import ak2.services.ak2.domain.entities.Ak2User;
import ak2.services.ak2.domain.repos.Ak2UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private final Ak2User user;

    // コンストラクタでAkUserを受け取る
    public CustomUserDetails(Ak2User user) {
        this.user = user;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        // ユーザーの役割（roles）を GrantedAuthority に変換して返す
        return user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        // ユーザーのパスワードを返す
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        // ユーザー名を返す
        return user.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        // アカウントが期限切れかどうかを返す（ここでは常に有効として返す）
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // アカウントがロックされているかどうかを返す（ここでは常にロックされていないと返す）
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 資格情報（パスワード）の有効期限を返す（ここでは常に有効として返す）
        return true;
    }

    @Override
    public boolean isEnabled() {
        // ユーザーが有効かどうかを返す
        return "Y".equals(user.getEnabled());
    }
}
