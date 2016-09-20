package com.freemvc.datacontract.request;

/**
 * Created by yangliangbin on 2016/9/12.
 */
public class GetUserListRequest extends BaseRequest {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
