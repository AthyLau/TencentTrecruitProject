package com.example.tencentrecruit.mapper;

import com.example.tencentrecruit.dto.User;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    /**
     * 添加一个用户
     * @param user
     * @return
     */
    @Insert("INSERT INTO users(u_name,u_password, u_sex, u_phone, u_mail) " +
            "VALUES(#{uName},#{uPassword},#{uSex},#{uPhone},#{uMail})")
    boolean addUser(User user);

    /**
     * 删除一个用户返回值为删除的User对象
     * @param uName
     * @return
     */
    @Delete("DELETE FROM users WHERE u_name=#{uName}")
    boolean deleteUserByUName(String uName);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Update("UPDATE users SET   u_password = #{uPassword},u_sex=#{uSex}, u_phone=#{uPhone}, " +
            "u_mail=#{uMail}  WHERE u_name=#{uName}")
    boolean updateUser(User user);

    /**
     * 查出所有的用户
     * @return
     */
    @Select("SELECT u_name, u_password, u_sex, u_phone,  u_mail FROM users;")
    List<User> findAllUsers();


    /**
     * 根据名字查出用户（模糊查找）
     * @param halfName
     * @return
     */
    @Select("SELECT u_name, u_password, u_sex, u_phone,  u_mail FROM users where u_name like concat(#{halfName},'%')")
    List<User> findUsersByHalfName(String halfName);

    /**
     * 根据名字查出单个用户
     * @param uName
     * @return
     */
    @Select("SELECT u_name, u_password, u_sex, u_phone,  u_mail FROM users where u_name = #{uName}")
    User findUserByUName(String uName);

    /**
     * 根据邮箱查出用户（模糊查找）
     * @param halfUMail
     * @return
     */
    @Select("SELECT u_name, u_password, u_sex, u_phone,  u_mail FROM users where u_mail like concat(#{halfUMail},'%')")
    List<User> findUsersByHalfUMail(String halfUMail);

    /**
     * 根据邮箱查出单个用户
     * @param uMail
     * @return
     */
    @Select("SELECT u_name, u_password, u_sex, u_phone,  u_mail FROM users where u_mail = #{uMail}")
    User findUserByUMail(String uMail);


    /**
     * 根据用户电话查出单个用户
     * @param uPhone
     * @return
     */
    @Select("SELECT u_name, u_password, u_sex, u_phone,  u_mail FROM users where u_phone = #{uPhone}")
    User findUserByUPhone(String uPhone);

    /**
     * 根据uid找user对象
     * @param uId
     * @return
     */
    @Select("SELECT u_name, u_password, u_sex, u_phone,  u_mail FROM users where u_id = #{uId};")
    User findUserByUId(Integer uId);
}