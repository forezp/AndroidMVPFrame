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
                handler.onlinkError("����������ʧ��");
                
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
                    if (!loginSuccess) {                                                            // ��¼ʧ��
                        if (handler != null) {
                            if (!msg.equals("null")) {
                                handler.onLoginError(msg);
                            } else {
                                handler.onLoginError("��¼ʧ�ܣ�");
                            }
                        }
                    } else {                                                                        // ��¼�ɹ�
                        JSONObject msgBody = response.getJSONObject("body");
                        //��������Ե���SharedPrefernce�洢�ڱ��ء�
                                                                                 // ���ػ��û�����
                        if (handler != null)
                            handler.onLoginSuccess();

                    }
                       
                    
                } catch (Exception e) {
                   if(handler!=null)
                       handler.onLoginError("������ʧ��");
                    e.printStackTrace();
                }
            }
            
        });
    
    }
}
