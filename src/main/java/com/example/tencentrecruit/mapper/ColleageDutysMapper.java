package com.example.tencentrecruit.mapper;

import com.example.tencentrecruit.dto.ColleageDutys;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2018/10/16 下午9:07
 * @since JDK 1.8
 */
@Repository
@Mapper
public interface ColleageDutysMapper {

    /**
     * 添加一条校园招聘信息
     * @param colleageDutys
     * @return
     */
    @Insert("INSERT INTO colleage_dutys(c_name,c_type,c_address,c_request,c_describe,year_info,month_info,day_info) " +
            "values(#{cName},#{cType},#{cAddress},#{cRequest},#{cDescribe},#{yearInfo},#{monthInfo},#{dayInfo})")
    boolean addColleageInfo(ColleageDutys colleageDutys);

    /**
     * 删除一条校园招聘信息
     * @param cId
     * @return
     */
    @Delete("Delete from colleage_dutys where c_id = #{cId}")
    boolean delColleageInfoById(Integer cId);

    /**
     * 更新一条校园招聘信息
     * @param colleageDutys
     * @return
     */
    @Update("Update colleage_dutys set c_name = #{cName},c_type = #{cType},c_address = #{cAddress},c_request = #{cRequest}" +
            ",c_describe = #{cDescribe},year_info = #{yearInfo},month_info = #{monthInfo},day_info = #{dayInfo} where c_id = #{cId}")
    boolean updateColleageInfoById(ColleageDutys colleageDutys);

    /**
     * 根据id查找校园招聘信息
     * @param cId
     * @return
     */
    @Select("select c_id,c_name,c_type,c_address,c_request,c_describe,year_info,month_info,day_info from colleage_dutys where c_id = #{cId}")
    ColleageDutys findById(Integer cId);

    /**
     * 查询所有的校园招聘信息
     * @return
     */
    @Select("select c_id,c_name,c_type,c_address,c_request,c_describe,year_info,month_info,day_info from colleage_dutys")
    List<ColleageDutys> findAll();

    /**
     * 根据日期查找校园招聘信息
     * @param yearInfo
     * @param monthInfo
     * @param dayInfo
     * @return
     */
    @Select("select c_id,c_name,c_type,c_address,c_request,c_describe,year_info,month_info,day_info from colleage_dutys " +
            "where year_info=#{yearInfo} and month_info = #{monthInfo} and day_info = #{dayInfo}")
    List<ColleageDutys> findByDate(Integer yearInfo,Integer monthInfo,Integer dayInfo);

    /**
     * 根据类型模糊查找校园招聘信息
     * @param cType
     * @return
     */
    @Select("select c_id,c_name,c_type,c_address,c_request,c_describe,year_info,month_info,day_info from colleage_dutys where c_type like concat(#{cType},'%')")
    List<ColleageDutys> findByType(String cType);

    /**
     * 根据地址模糊查找校园招聘信息
     * @param cAddress
     * @return
     */
    @Select("select c_id,c_name,c_type,c_address,c_request,c_describe,year_info,month_info,day_info from colleage_dutys where c_address like concat(#{cAddress},'%')")
    List<ColleageDutys> findByAddress(String cAddress);


}
