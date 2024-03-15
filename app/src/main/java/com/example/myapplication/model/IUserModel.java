package com.example.myapplication.model;

public interface IUserModel {
    void checkLogin(User user, OnCheckLoginListener listener);
    interface OnCheckLoginListener{
        void  OnFinishCheckLogin(boolean isSuccess, String errorMessage);
    }
}
