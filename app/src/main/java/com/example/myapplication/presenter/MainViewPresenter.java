package com.example.myapplication.presenter;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.contract.IMainViewContract;
import com.example.myapplication.model.IUserModel;
import com.example.myapplication.model.User;
import com.example.myapplication.model.UserModel;

public class MainViewPresenter implements IMainViewContract.Presenter {
    private IMainViewContract.View view;
    private IUserModel userModel;

    public MainViewPresenter(IMainViewContract.View view)
    {
        this.view = view;
        userModel = new UserModel();
    }
    @Override
    public void checkLogin(User user) {
        userModel.checkLogin(user,((isSuccess, errorMessage) -> {
            if(isSuccess)
                view.loginSuccess(user);
            else
                view.loginFailed(errorMessage);
        }));
    }
}
