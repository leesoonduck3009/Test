package com.example.myapplication.model;

public class UserModel implements IUserModel{
    @Override
    public void checkLogin(User user, OnCheckLoginListener listener) {
        if(user.getUserName().equals("binh") )
        {
            listener.OnFinishCheckLogin(true,null);
        }
        else
            listener.OnFinishCheckLogin(false, "Thong tin sai");
    }
}
