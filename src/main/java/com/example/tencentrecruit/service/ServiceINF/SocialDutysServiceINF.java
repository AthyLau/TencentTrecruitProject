package com.example.tencentrecruit.service.ServiceINF;

import com.example.tencentrecruit.dto.SocialDutys;
import java.util.*;
/**
 * Function:
 *
 * @author liubing
 * Date: 2018/10/16 下午9:07
 * @since JDK 1.8
 */
public interface SocialDutysServiceINF {
    /**
     * 添加社招信息
     * @param socialDutys
     * @return
     */
    boolean addSocialInfo(SocialDutys socialDutys);

    /**
     * 根据id删除社招信息
     * @param sId
     * @return
     */
    boolean delSocialInfoById(Integer sId);

    /**
     * 根据id更新社招信息
     * @param socialDutys
     * @return
     */
    boolean updateSocialInfoById(SocialDutys socialDutys);

    /**
     * 查找所有的社招信息
     * @return
     */
    List<SocialDutys> findAll();

    /**
     * 根据地址查询社招信息
     * @return
     */
    List<SocialDutys> findByAddress(String address);

    /**
     * 根据类型查找社招信息
     * @return
     */
    List<SocialDutys> findByType(String type);

    /**
     * 根据发布日期查找社招信息
     * @return
     */
    List<SocialDutys> findByDate(String date);

    /**
     * 根据时间查找社招信息
     * @return
     */
    List<SocialDutys> findByTime(int year,int month,int day);

    /**
     * 根据id查找
     * @param sId
     * @return
     */
    SocialDutys findById(Integer sId);
}
