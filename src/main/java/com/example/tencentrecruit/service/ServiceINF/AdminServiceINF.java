package com.example.tencentrecruit.service.ServiceINF;


import com.example.tencentrecruit.dto.Admin;


/**
 * Function:管理员的service接口
 *
 * @author liubing
 * Date: 2018/10/2 下午6:37
 * @since JDK 1.8
 */


public interface AdminServiceINF {

    /**
     * 根据管理员的名字查找管理员
     * @param aName
     * @return
     */
    Admin findAdminByAName(String aName);

}
