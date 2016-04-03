package com.example.androidmvpframe.view;


public interface IUserLoginView extends IUserView {
    public void onUserLoginSuccess();

    public void onUserLoginError(String msg);
}
