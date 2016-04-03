package com.example.androidmvpframe.view;

import com.example.androidmvpframe.model.bean.User;


public interface IUserLoginView extends IUserView {
    public void onUserLoginSuccess(User user);

    public void onUserLoginError(String msg);
}
