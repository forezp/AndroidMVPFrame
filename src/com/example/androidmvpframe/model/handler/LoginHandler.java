package com.example.androidmvpframe.model.handler;

import com.example.androidmvpframe.model.bean.User;

public interface LoginHandler extends NetworkHandler {
    public void onLoginSuccess(User user);       // ��¼�ɹ�

    public void onLoginError(String msg);         // ��¼ʧ��
}

