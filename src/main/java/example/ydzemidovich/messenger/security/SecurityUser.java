package example.ydzemidovich.messenger.security;

import example.ydzemidovich.messenger.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * Implementation of UserDetails interface for the Messenger application.
 * Only one role - user role - is supported at this moment.
 */
public class SecurityUser implements UserDetails {

    private final Collection<? extends GrantedAuthority> authorities;
    private final String password;
    private final String username;
    private final boolean isLocked;

    public SecurityUser(User user) {
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        this.password = user.getPassword();
        this.username = user.getLogin();
        this.isLocked = user.isBlocked();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !isLocked;
    }
}
