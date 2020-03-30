package com.dxminds.mvcexample;

public interface LoginResultInterface {
     void onLoginResult(Boolean result, int code);
     void onError(Error error);
}
