package com.example.androidmvpframe.model.handler;

import com.example.androidmvpframe.model.bean.User;

public interface LoginHandler extends NetworkHandler {
    public void onLoginSuccess(User user);       // µÇÂ¼³É¹¦

    public void onLoginError(String msg);         // µÇÂ¼Ê§°Ü
}

