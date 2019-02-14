package com.example.tencentrecruit.mapper;

import com.example.tencentrecruit.dto.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * Function:管理员的Mapper
 *
 * @author liubing
 * Date: 2018/10/9 下午4:04
 * @since JDK 1.8
 */

@Repository
@Mapper
public interface AdminMapper {

    /**
     * 根据管理员的名字查找管理员
     * @param aName
     * @return
     */
    @Select("SELECT a_name,a_password FROM admins WHERE a_name = #{aName}")
    Admin findAdminByAName(String aName);

}
