package org.backend.kappastoneletsgo.models.usermodels;

public enum Role {

    UNDEFINED("UNDEFINED"),
    USER("USER"),
    ADMIN("ADMIN");

    private String name;

    Role(String name) {
        this.name = name;
    }
}
