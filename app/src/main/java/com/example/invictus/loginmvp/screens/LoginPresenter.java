package com.example.invictus.loginmvp.screens;

import android.util.Patterns;

import com.example.invictus.loginmvp.screens.LoginInterfaces.LoginViews;

/**
 * Created by invictus on 4/17/2016.
 */
public class LoginPresenter implements LoginInterfaces.IteratorInterface {
    //take in model
    private LoginModel model;
    //take in view interface in the constructor
    private LoginViews views;

    //init iterator
    //@params @iterator interface
    private LoginIterator iterator;


    private boolean email_oky = false;
    private boolean password_oky = false;


    public LoginPresenter(LoginViews views) {
        this.views = views;
        model = new LoginModel();
        iterator = new LoginIterator(this);
    }

    public void updateEmail(String email) {
        model.setEmail(email);

        if (!model.getEmail().isEmpty() && Patterns.EMAIL_ADDRESS.matcher(model.getEmail()).matches()) {
            email_oky = true;
        } else {
            email_oky = false;
        }

        if (email_oky && password_oky) {
            views.enableLogin(true);
        } else {
            views.enableLogin(false);
        }
    }

    public void updatePassword(String password) {
        model.setPassword(password);

        if (!model.getPassword().isEmpty()) {
            password_oky = true;
        } else {
            password_oky = false;
        }

        if (email_oky && password_oky) {
            views.enableLogin(true);
        } else {
            views.enableLogin(false);
        }
    }


    public void initLogin() {
        views.showLoading(true);
        iterator.Login(model.getEmail(), model.getPassword());
    }

    @Override
    public void loginSuccess() {
        views.showLoading(false);
        views.loginSuccess();

    }

    @Override
    public void loginError(LoginErrors errors, String message) {
        views.showLoading(false);
        switch (errors) {
            case EMAIL:
                views.emailError(message);
                break;

            case PASSWORD:
                views.passwordError(message);
                break;
        }
    }
}
