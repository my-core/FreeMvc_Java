package com.freemvc.datacontract.request;

/**
 * Created by yangliangbin on 2016/9/12.
 */
public class UserLoginRequest {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
