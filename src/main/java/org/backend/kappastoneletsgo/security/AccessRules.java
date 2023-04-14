package org.backend.kappastoneletsgo.security;

public class AccessRules {

    protected static final String[] FOR_EVERYONE = {
            "/error",
            "/users/**",
            "/forums/**",
            "/loginkappa/**",
            "/register/**",
            "/myprofile/**"};

    protected static final String[] FOR_AUTHORIZED_USERS = {
            "/user/**",
            "/users/**",
            "/forums/**",
            "/loginkappa/**",
            "/register/**",
            "/myprofile/**"};

    protected static final String[] FOR_ADMINS = {"/admin/**",
            "/users/**",
            "/section/new"};

    protected static final String[] ADMINS_ROLES = {"HEAD_ADMIN",
            "ADMIN"};

}