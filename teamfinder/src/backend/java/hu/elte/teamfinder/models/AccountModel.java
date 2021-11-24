package hu.elte.teamfinder.models;

import hu.elte.teamfinder.security.AccountRole;
import hu.elte.teamfinder.utils.StringSetConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class AccountModel implements Serializable {
    // TODO: join with ProfileModel
    // TODO: Make accountId auto-generated
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = AUTO)
    private final Integer accountId;

    @Column(unique = true)
    private final String email;

    private final String password;

    @Convert(converter = StringSetConverter.class)
    @Column
    private final Set<AccountRole> roles;
    // TODO: add Access modifiers field and update constructor
    private final boolean isAccountNonExpired;
    private final boolean isAccountNonLocked;
    private final boolean isCredentialsNonExpired;
    private final boolean isEnabled;

    public AccountModel() {
        this.accountId = -1;
        this.email = null;
        this.password = null;
        this.roles = new HashSet<>();
        roles.add(AccountRole.STANDARD);
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
        this.isCredentialsNonExpired = true;
        this.isEnabled = true;
    }

    public AccountModel(
            Integer accountId,
            String email,
            String password,
            Set<AccountRole> roles,
            boolean isAccountNonExpired,
            boolean isAccountNonLocked,
            boolean isCredentialsNonExpired,
            boolean isEnabled) {
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }

    public AccountModel(Integer accountId, String email, String password) {
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.roles = new HashSet<>();
        roles.add(AccountRole.STANDARD);
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
        this.isCredentialsNonExpired = true;
        this.isEnabled = true;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<AccountRole> getRoles() {
        return roles;
    }

    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}
