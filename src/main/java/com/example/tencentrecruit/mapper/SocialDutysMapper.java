package com.example.tencentrecruit.mapper;

import com.example.tencentrecruit.dto.SocialDutys;
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
public interface SocialDutysMapper {
    /**
     * 添加社招信息
     * @param socialDutys
     * @return
     */
    @Insert("Insert into social_dutys(s_address,s_res,s_req,s_name,s_type,s_peo_num,s_date,year_info,month_info,day_info,s_link) " +
            "values(#{sAddress},#{sRes},#{sReq},#{sName},#{sType},#{sPeoNum},#{sDate},#{yearInfo},#{monthInfo},#{dayInfo},#{sLink})")
    boolean addSocialInfo(SocialDutys socialDutys);

    /**
     * 根据id删除社招信息
     * @param sId
     * @return
     */
    @Delete("Delete from social_dutys where s_id = #{sId}")
    boolean delSocialInfoById(Integer sId);

    /**
     * 根据id更新社招信息
     * @param socialDutys
     * @return
     */
    @Update("update social_dutys set s_address=#{sAddress},s_res=#{sRes},s_req=#{sReq},s_name=#{sName},s_type=#{sType},s_peo_num=#{sPeoNum}," +
            "s_date=#{sDate},year_info=#{yearInfo},month_info=#{monthInfo},day_info=#{dayInfo},s_link=#{sLink}")
    boolean updateSocialInfoById(SocialDutys socialDutys);

    /**
     * 查找所有的社招信息
     * @return
     */
    @Select("select s_id,s_address,s_res,s_req,s_name,s_type,s_peo_num,s_date,year_info,month_info,day_info,s_link from social_dutys")
    List<SocialDutys> findAll();

    /**
     * 根据地址查询社招信息
     * @return
     */
    @Select("select s_id,s_address,s_res,s_req,s_name,s_type,s_peo_num,s_date,year_info,month_info,day_info,s_link from social_dutys where s_address=#{sAddress}")
    List<SocialDutys> findByAddress(String sAddress);

    /**
     * 根据类型查找社招信息
     * @return
     */
    @Select("select s_id,s_address,s_res,s_req,s_name,s_type,s_peo_num,s_date,year_info,month_info,day_info,s_link from social_dutys where s_type like concat(#{sType},'%')")
    List<SocialDutys> findByType(String sType);

    /**
     * 根据发布日期查找社招信息
     * @return
     */
    @Select("select s_id,s_address,s_res,s_req,s_name,s_type,s_peo_num,s_date,year_info,month_info,day_info,s_link from social_dutys where s_date = #{sDate}")
    List<SocialDutys> findByDate(String sDate);

    /**
     * 根据时间查找社招信息
     * @return
     */
    @Select("select s_id,s_address,s_res,s_req,s_name,s_type,s_peo_num,s_date,year_info,month_info,day_info,s_link from social_dutys " +
            "where year_info = #{yearInfo} and month_info = #{monthInfo} and day_info = #{dayInfo}")
    List<SocialDutys> findByTime(@Param("yearInfo") int yearInfo,@Param("monthInfo") int monthInfo,@Param("dayInfo") int dayInfo);

    @Select("Select s_id,s_address,s_res,s_req,s_name,s_type,s_peo_num,s_date,year_info,month_info,day_info,s_link from social_dutys " +
            "where s_id = #{sId}")
    SocialDutys findById(Integer sId);
}
