package com.example.myapplication.contract;

import com.example.myapplication.model.User;

public interface IMainViewContract {
    interface Presenter{
        void checkLogin(User user);
    }
    interface View{
        void loginSuccess(User user);
        void loginFailed(String message);
    }
}
