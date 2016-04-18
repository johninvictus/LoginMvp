package com.example.invictus.loginmvp.screens;

/**
 * Created by invictus on 4/17/2016.
 */
public class LoginInterfaces {

    public interface LoginViews{
        void showLoading(boolean show);
        void enableLogin(boolean enable);
        void emailError(String error);
        void passwordError(String error);
        void loginSuccess();
    }

    public interface IteratorInterface{
        void loginSuccess();
        void loginError(LoginErrors errors,String messsage);
    }
}
