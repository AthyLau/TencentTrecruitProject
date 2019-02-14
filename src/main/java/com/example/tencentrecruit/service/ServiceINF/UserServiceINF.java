package com.example.tencentrecruit.service.ServiceINF;

import com.example.tencentrecruit.dto.User;


import java.util.List;

/**
 * Function:操作用户的service层接口
 *
 * @author liubing
 * Date: 2018/9/30 下午2:24
 * @since JDK 1.8
 */

public interface UserServiceINF {
    /**
     * 添加一个用户
     * @param user
     * @return
     */
    String addUserStr(User user);
    /**
     * 删除一个用户返回值为删除的User对象
     * @param uName
     * @return
     */
    boolean deleteUserByUName(String uName);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 查出所有的用户
     * @return
     */
    List<User> findAllUsers();

    /**
     * 根据名字查出用户（模糊查找）
     * @param halfName
     * @return
     */
    List<User> findUsersByHalfName(String halfName);

    /**
     * 根据名字查出单个用户
     * @param uName
     * @return
     */
    User findUserByUName(String uName);

}
