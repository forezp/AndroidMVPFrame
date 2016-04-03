package com.example.androidmvpframe;

import java.security.MessageDigest;

import com.example.androidmvpframe.model.bean.User;
import com.example.androidmvpframe.presenter.UserPresenter;
import com.example.androidmvpframe.view.IUserLoginView;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements IUserLoginView{
    
    @ViewInject(id=R.id.btn_login,click="login") Button btn_login;
    @ViewInject(id=R.id.et_login_name)EditText et_login_name;
    @ViewInject(id=R.id.et_login_password) EditText et_login_password;
    private Context mContext;
    private UserPresenter userPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FinalActivity.initInjectedView(this);
        mContext=this;
        userPresenter=new UserPresenter(this);
    }
    
    public void login(View v){
        String mobile=et_login_name.getText().toString();
        String password=et_login_password.getText().toString();
        String md5Pwd=MD5(password);
        userPresenter.login(mobile, md5Pwd);
        
    }
    
    @Override
    public void onUserLoginSuccess(User user) {
        
        Toast.makeText(mContext, "µÇÂ¼³É¹¦:"+user.toString(), Toast.LENGTH_SHORT).show();
        
    }
    @Override
    public void onUserLoginError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
        
    } 
    
    public final static String MD5(String plain) {  
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(plain.getBytes("UTF-8"));
            byte[] m = md5.digest();//¼ÓÃÜ
            StringBuilder hex = new StringBuilder(m.length * 2);
            for (byte b : m) {
                if ((b & 0xFF) < 0x10) hex.append("0");
                hex.append(Integer.toHexString(b & 0xFF));
            }
            return hex.toString();
        } catch (Exception e) {
           e.printStackTrace();
            return null;
        }
    }  
}
