package com.example.invictus.loginmvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.invictus.loginmvp.screens.LoginInterfaces;
import com.example.invictus.loginmvp.screens.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginInterfaces.LoginViews {

    private EditText _email;
    private EditText _password;
    private Button _btn_login;
    private ProgressBar _progress;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _email = (EditText) findViewById(R.id.input_email);
        _password = (EditText) findViewById(R.id.input_password);
        _btn_login = (Button) findViewById(R.id.btn_login);
        _progress = (ProgressBar) findViewById(R.id.login_progress);

        presenter = new LoginPresenter(this);

        _email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.updateEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        _password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.updatePassword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        _btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.initLogin();
            }
        });

        _btn_login.setEnabled(false);
        _btn_login.setAlpha(.4f);

    }

    @Override
    public void showLoading(boolean show) {
        if (show) {
            _progress.setVisibility(View.VISIBLE);
        } else {
            _progress.setVisibility(View.GONE);
        }
    }

    @Override
    public void enableLogin(boolean enable) {
        if (enable) {
            _btn_login.setAlpha(1f);
            _btn_login.setEnabled(true);
        } else {
            _btn_login.setAlpha(0.4f);
            _btn_login.setEnabled(false);
        }
    }

    @Override
    public void emailError(String error) {
        _email.setError(error);
    }

    @Override
    public void passwordError(String error) {
        _password.setError(error);
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
}
