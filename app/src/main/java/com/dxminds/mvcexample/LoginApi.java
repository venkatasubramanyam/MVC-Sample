package com.dxminds.mvcexample;

import android.os.Handler;

class LoginApi {

    private Handler handler;
    private UserModel userModel;
    private String name;
    private String password;
    private LoginResultInterface mLoginResultInterface;

    LoginApi(String userName, String password, LoginResultInterface loginResultInterface){
        userModel = new UserModel(userName, password);

        handler= new Handler();
        this.name = userName;
        this.password = password;
        this.mLoginResultInterface = loginResultInterface;
    }


    void doLogin() {
        boolean isLoginSuccess = true;
        final int code = userModel.checkUserValidity(name,password);
        if (code!=0)
            isLoginSuccess = false;

        final boolean result = isLoginSuccess;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mLoginResultInterface.onLoginResult(result, code);
            }
        }, 5000);

    }



}
