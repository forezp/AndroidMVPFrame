package com.example.androidmvpframe.model.handler;

public interface LoginHandler extends NetworkHandler {
    public void onLoginSuccess();       // ��¼�ɹ�

    public void onLoginError(String msg);         // ��¼ʧ��
}

