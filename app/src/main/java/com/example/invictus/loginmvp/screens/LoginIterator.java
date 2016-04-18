package com.example.invictus.loginmvp.screens;

import android.os.Handler;

import com.example.invictus.loginmvp.screens.LoginInterfaces.IteratorInterface;

/**
 * Created by invictus on 4/18/2016.
 */
public class LoginIterator {
    private IteratorInterface iteratorInterface;

    public LoginIterator(IteratorInterface iteratorInterface) {
        this.iteratorInterface = iteratorInterface;
    }

    public void Login(final String email, final String password) {
        //now you can implement your business login
        //network calls etc

        //to demonstrate login error let put default correct password and email
        //correct email: invictusbytes@gmail.com
        //password :rootadmin
        Handler handler = new Handler();
        if (email.contentEquals("invictusbytes@gmail.com") && password.contentEquals("rootadmin")) {

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //success login
                    iteratorInterface.loginSuccess();
                }
            }, 1000);
        } else {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //success login


                    //check if email is correct
                    if(! email.contentEquals("invictusbytes@gmail.com")){
                        iteratorInterface.loginError(LoginErrors.EMAIL,"error: use invictusbytes@gmail.com");
                        return;
                    }

                   if(! password.contentEquals("rootadmin")){
                       iteratorInterface.loginError(LoginErrors.PASSWORD,"error: use rootadmin");
                       return;
                   }


                }
            }, 1000);

        }

    }
}
