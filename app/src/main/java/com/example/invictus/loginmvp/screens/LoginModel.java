package com.example.invictus.loginmvp.screens;

/**
 * Created by invictus on 4/17/2016.
 */
public class LoginModel {
    private String email;
    private String password;


    public LoginModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*
    * it a good practice to always include toString method
    * */
    @Override
    public String toString() {
        return new StringBuilder().append(getEmail()).
                append(" ").append(getPassword()).toString();
    }
}
