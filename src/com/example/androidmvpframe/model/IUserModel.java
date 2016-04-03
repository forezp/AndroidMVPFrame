package com.example.androidmvpframe.model;

import com.example.androidmvpframe.model.handler.LoginHandler;

public interface IUserModel {
    
    // 用户登录接口
    public void login(String phone, String passwdMd5, final LoginHandler handler);

}
