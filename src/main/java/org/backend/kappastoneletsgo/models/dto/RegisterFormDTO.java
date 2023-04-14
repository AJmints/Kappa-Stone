package org.backend.kappastoneletsgo.models.dto;

import jakarta.validation.constraints.NotNull;

public class RegisterFormDTO extends LoginFormDTO {

    @NotNull
    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}
