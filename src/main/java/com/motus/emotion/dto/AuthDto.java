package com.motus.emotion.dto;

import javax.validation.constraints.NotNull;

public class AuthDto {
    @NotNull(message = "username must be set")
    private String username;

    @NotNull(message = "password must be set")
    private String password;


    /**
     * Default constructor
     */
    protected AuthDto() {
    }

    /**
     * Full constructor
     * @param username The user email
     * @param password The user password
     */
    public AuthDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
