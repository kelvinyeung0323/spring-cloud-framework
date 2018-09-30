package com.taurus.cloud.producer.vo;

/**
 * @author: Kelvin Yeung
 * @createdAt: 2018/9/27
 * @description:
 */
public class UserVO  {

    private static final long serialVersionUID = 6269836931884903736L;

    private String userName;
    private String mobile;

    public UserVO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
