package org.backend.kappastoneletsgo.models.usermodels;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.backend.kappastoneletsgo.models.IdGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User extends IdGenerator {

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    @NotNull
    private Role role = Role.UNDEFINED;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwHash() {
        return pwHash;
    }

    public void setPwHash(String pwHash) {
        this.pwHash = pwHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

}
