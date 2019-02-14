package com.example.tencentrecruit.service.ServiceINF;

import com.example.tencentrecruit.dto.ColleageDutys;
import java.util.*;
/**
 * Function:
 *
 * @author liubing
 * Date: 2018/10/16 下午9:07
 * @since JDK 1.8
 */
public interface ColleageDutysServiceINF {

    /**
     * 添加一条校园招聘信息
     * @param colleageDutys
     * @return
     */
    boolean addColleageInfo(ColleageDutys colleageDutys);

    /**
     * 删除一条校园招聘信息
     * @param cId
     * @return
     */
    boolean delColleageInfoById(Integer cId);

    /**
     * 更新一条校园招聘信息
     * @param colleageDutys
     * @return
     */
    boolean updateColleageInfoById(ColleageDutys colleageDutys);

    /**
     * 根据id查找校园招聘信息
     * @param cId
     * @return
     */
    ColleageDutys findById(Integer cId);

    /**
     * 查询所有的校园招聘信息
     * @return
     */
    List<ColleageDutys> findAll();

    /**
     * 根据日期查找校园招聘信息
     * @param year
     * @param month
     * @param day
     * @return
     */
    List<ColleageDutys> findByDate(Integer year,Integer month,Integer day);

    /**
     * 根据类型模糊查找校园招聘信息
     * @param type
     * @return
     */
    List<ColleageDutys> findByType(String type);

    /**
     * 根据地址模糊查找校园招聘信息
     * @param address
     * @return
     */
    List<ColleageDutys> findByAddress(String address);
}
