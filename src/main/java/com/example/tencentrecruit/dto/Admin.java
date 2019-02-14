package com.example.tencentrecruit.dto;

import lombok.Data;


/**
 * Function:管理员的实体类
 *
 * @author liubing
 * Date: 2018/10/2 下午6:31
 * @since JDK 1.8
 */

@Data
public class Admin {
    /**
     * 管理员的名字也是账号
     */
    private String aName;
    /**
     * 管理员的密码
     */
    private String aPassword;

    public Admin(String aName, String aPassword) {
        this.aName = aName;
        this.aPassword = aPassword;
    }

    public Admin() {
    }
}
