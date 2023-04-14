package org.backend.kappastoneletsgo.models.usermodels;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.backend.kappastoneletsgo.models.IdGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User extends IdGenerator {

    @NotNull
    private String userName;

    @NotNull
    private String pwHash;

    @NotNull
    private Role role = Role.UNDEFINED;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.pwHash = encoder.encode(password);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
