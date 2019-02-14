package com.example.tencentrecruit.dto;


import lombok.Data;

/**
 * Function:用户的实体类
 *
 * @author liubing
 * Date: 2018/9/30 下午2:15
 * @since JDK 1.8
 */


@Data
public class User {
    /**
     * 用户昵称也是用户的账号
     */
    private String uName;
    /**
     * 用户密码
     */
    private String uPassword;
    /**
     * 用户性别
     */
    private String uSex;
    /**
     * 用户电话
     */
    private String uPhone;
    /**
     * 用户邮箱
     */
    private String uMail;

    public User(String uName, String uPassword, String uSex, String uPhone, String uMail) {
        this.uName = uName;
        this.uPassword = uPassword;
        this.uSex = uSex;
        this.uPhone = uPhone;
        this.uMail = uMail;
    }
}
