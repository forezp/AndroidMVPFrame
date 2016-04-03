package com.example.androidmvpframe.model.handler;

public interface LoginHandler extends NetworkHandler {
    public void onLoginSuccess();       // µÇÂ¼³É¹¦

    public void onLoginError(String msg);         // µÇÂ¼Ê§°Ü
}

