package com.example.tencentrecruit.service.ServiceIMPL;

import com.example.tencentrecruit.dto.User;
import com.example.tencentrecruit.mapper.UserMapper;
import com.example.tencentrecruit.service.ServiceINF.UserServiceINF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function:用户的Service层实现类
 *
 * @author liubing
 * Date: 2018/9/30 下午2:39
 * @since JDK 1.8
 */

@Service("UserServiceIMPL")
public class UserServiceIMPL implements UserServiceINF {

    @Autowired
    private UserMapper userMapper;
    /**
     * 添加一个用户
     * @param user
     * @return
     */
    public String addUserStr(User user) {
        if(user.getUMail()==null||user.getUName()==null||user.getUPassword()==null||user.getUSex()==null){
            return "注册信息必须全部填上";
        }
        if(user.getUMail().trim()!=user.getUMail()||user.getUName().trim()!=user.getUName()||user.getUPassword().trim()!=user.getUPassword()||user.getUSex().trim()!=user.getUSex()){
            return "注册信息不能包含空格";
        }
        if(user.getUMail().trim()==""||user.getUName().trim()==""||user.getUPassword().trim()==""||user.getUSex().trim()==""){
            return "注册信息不能为空";
        }
        //查一下是否已经存在相同用户名，用户身份证号，用户电话，用户邮箱的用户
        if(userMapper.findUserByUName(user.getUName())!=null){
            return "用户名已经被注册";
        }else if(userMapper.findUserByUMail(user.getUMail())!=null){
            return "邮箱已经被注册";
        }else if(userMapper.findUserByUPhone(user.getUPhone())!=null){
            return "电话号码已经绑定用户";
        }
        else if(userMapper.addUser(user)){
            return "注册成功";
        }
        return "注册失败";
    }


    /**
     * 删除一个用户返回值为删除的User对象
     * @param uName
     * @return
     */
    @Override
    public boolean deleteUserByUName(String uName) {
        return userMapper.deleteUserByUName(uName);
    }
    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }
    /**
     * 查出所有的用户
     * @return
     */
    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }
    /**
     * 根据名字查出用户（模糊查找）
     * @param halfName
     * @return
     */
    @Override
    public List<User> findUsersByHalfName(String halfName) {
        return userMapper.findUsersByHalfName(halfName);
    }
    /**
     * 根据名字查出单个用户
     * @param uName
     * @return
     */
    @Override
    public User findUserByUName(String uName) {
        return userMapper.findUserByUName(uName);
    }
}
