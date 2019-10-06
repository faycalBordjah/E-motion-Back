package com.motus.emotion.dto;

import javax.validation.constraints.NotNull;

public class AuthDto {
    @NotNull(message = "mail must be set")
    private String mail;

    @NotNull(message = "password must be set")
    private String password;


    /**
     * Default constructor
     */
    protected AuthDto() {
    }

    /**
     * Full constructor
     * @param mail The user email
     * @param password The user password
     */
    public AuthDto(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
