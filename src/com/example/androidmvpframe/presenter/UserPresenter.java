package com.example.androidmvpframe.presenter;

import android.support.annotation.Nullable;

import com.example.androidmvpframe.model.IUserModel;
import com.example.androidmvpframe.model.UserModel;
import com.example.androidmvpframe.model.bean.User;
import com.example.androidmvpframe.model.handler.LoginHandler;
import com.example.androidmvpframe.view.IUserLoginView;
import com.example.androidmvpframe.view.IUserView;

public class UserPresenter {
    private static final String TAG="UserPresenter";
    
    private IUserModel mUser;      
    private IUserView mView;       


    /**
     * �����û�ģ�͵�������
     *
     * @param view �������Ҫ���н���չʾ��View����null
     */
    public UserPresenter(@Nullable IUserView view) {
        mUser = UserModel.getInstance();
        mView = view;
    }
    
    
    public void login(String mobile,String password){
        mUser.login(mobile, password, new LoginHandler() {
            
            @Override
            public void onlinkError(String msg) {
                if(mView!=null&&mView instanceof IUserLoginView)
                 ( (IUserLoginView) mView).onUserLoginError(msg);
                
            }
            
            @Override
            public void onLoginSuccess(User user) {
                if (mView != null && mView instanceof IUserLoginView)
                    ((IUserLoginView) mView).onUserLoginSuccess(user);
                
            }
            
            @Override
            public void onLoginError(String msg) {
               if(mView!=null&&mView instanceof IUserLoginView)
                   ((IUserLoginView)mView).onUserLoginError(msg);
                
            }
        });
    }

}
