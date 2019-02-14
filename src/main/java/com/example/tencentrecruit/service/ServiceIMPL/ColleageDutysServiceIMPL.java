package com.example.tencentrecruit.service.ServiceIMPL;

import com.example.tencentrecruit.dto.ColleageDutys;
import com.example.tencentrecruit.mapper.ColleageDutysMapper;
import com.example.tencentrecruit.service.ServiceINF.ColleageDutysServiceINF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2018/10/16 下午9:07
 * @since JDK 1.8
 */

@Service("ColleageDutysServiceIMPL")
public class ColleageDutysServiceIMPL implements ColleageDutysServiceINF{
    @Autowired
    private ColleageDutysMapper colleageDutysMapper;

    /**
     * 添加一条校园招聘信息
     * @param colleageDutys
     * @return
     */
    @Override
    public boolean addColleageInfo(ColleageDutys colleageDutys) {
        Date date = new Date();
        colleageDutys.setDayInfo(date.getDay());
        colleageDutys.setYearInfo(date.getYear());
        colleageDutys.setMonthInfo(date.getMonth());
        return colleageDutysMapper.addColleageInfo(colleageDutys);
    }
    /**
     * 删除一条校园招聘信息
     * @param cId
     * @return
     */
    @Override
    public boolean delColleageInfoById(Integer cId) {
        return colleageDutysMapper.delColleageInfoById(cId);
    }
    /**
     * 更新一条校园招聘信息
     * @param colleageDutys
     * @return
     */
    @Override
    public boolean updateColleageInfoById(ColleageDutys colleageDutys) {
        return colleageDutysMapper.updateColleageInfoById(colleageDutys);
    }
    /**
     * 根据id查找校园招聘信息
     * @param cId
     * @return
     */
    @Override
    public ColleageDutys findById(Integer cId) {
        return colleageDutysMapper.findById(cId);
    }
    /**
     * 查询所有的校园招聘信息
     * @return
     */
    @Override
    public List<ColleageDutys> findAll() {
        return colleageDutysMapper.findAll();
    }
    /**
     * 根据日期查找校园招聘信息
     * @param year
     * @param month
     * @param day
     * @return
     */
    @Override
    public List<ColleageDutys> findByDate(Integer year, Integer month, Integer day) {
        return colleageDutysMapper.findByDate(year, month, day);
    }
    /**
     * 根据类型模糊查找校园招聘信息
     * @param type
     * @return
     */
    @Override
    public List<ColleageDutys> findByType(String type) {
        return colleageDutysMapper.findByType(type);
    }
    /**
     * 根据地址模糊查找校园招聘信息
     * @param address
     * @return
     */
    @Override
    public List<ColleageDutys> findByAddress(String address) {
        return colleageDutysMapper.findByAddress(address);
    }
}
