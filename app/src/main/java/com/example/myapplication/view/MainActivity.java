package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.contract.IMainViewContract;
import com.example.myapplication.model.User;
import com.example.myapplication.presenter.MainViewPresenter;

public class MainActivity extends AppCompatActivity implements IMainViewContract.View {
    private Button loginButton;
    private EditText loginEditText;
    private TextView textView;
    private IMainViewContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton = findViewById(R.id.loginButton);
        loginEditText = findViewById(R.id.textBox);
        textView = findViewById(R.id.textOutput);
        presenter = new MainViewPresenter(this);
        setListener();
    }
    void setListener()
    {
        loginButton.setOnClickListener(v->{
            User user = new User();
            user.setUserName(loginEditText.getText().toString());
           presenter.checkLogin(user);
        });
    }

    @Override
    public void loginSuccess(User user) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginFailed(String message) {
        textView.setText(message);
    }
}