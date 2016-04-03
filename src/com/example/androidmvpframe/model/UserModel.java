package com.example.androidmvpframe.model;

import org.json.JSONObject;

import com.example.androidmvpframe.model.handler.LoginHandler;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;



public class UserModel implements IUserModel{
    
    private static UserModel instance = null;
    private UserModel(){}
    public static UserModel getInstance() {
        if (instance == null) {
            instance = new UserModel();
        }
        return instance;
    }

    @Override
    public void login(String phone, String passwdMd5, final LoginHandler handler) {
        
        String url = "www.login.com";
        AjaxParams params = new AjaxParams();
        params.put("mobile", phone);
        params.put("password",  passwdMd5);
        
        FinalHttp fh = new FinalHttp();
        fh.post(url, params, new AjaxCallBack<String>() {

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                handler.onlinkError("服务器连接失败");
                
            }

            @Override
            public void onLoading(long count, long current) {
               
                super.onLoading(count, current);
            }

            @Override
            public void onStart() {
              
            }

            @Override
            public void onSuccess(String t) {
                
                
               
                try {
                    JSONObject response=new JSONObject(t);
                    boolean loginSuccess = response.getBoolean("success");
                    String msg = response.getString("msg");
                    if (!loginSuccess) {                                                            // 登录失败
                        if (handler != null) {
                            if (!msg.equals("null")) {
                                handler.onLoginError(msg);
                            } else {
                                handler.onLoginError("登录失败！");
                            }
                        }
                    } else {                                                                        // 登录成功
                        JSONObject msgBody = response.getJSONObject("body");
                        //在这里可以调用SharedPrefernce存储在本地。
                                                                                 // 本地化用户数据
                        if (handler != null)
                            handler.onLoginSuccess();

                    }
                       
                    
                } catch (Exception e) {
                   if(handler!=null)
                       handler.onLoginError("服务器失败");
                    e.printStackTrace();
                }
            }
            
        });
    
    }
}
