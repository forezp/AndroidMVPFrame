package com.example.androidmvpframe.model;

import com.example.androidmvpframe.model.handler.LoginHandler;

public interface IUserModel {
    
    // �û���¼�ӿ�
    public void login(String phone, String passwdMd5, final LoginHandler handler);

}
