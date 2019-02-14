package com.example.tencentrecruit.service.ServiceIMPL;

import com.example.tencentrecruit.dto.SocialDutys;
import com.example.tencentrecruit.mapper.SocialDutysMapper;
import com.example.tencentrecruit.service.ServiceINF.SocialDutysServiceINF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2018/10/16 下午9:11
 * @since JDK 1.8
 */

@Service("SocialDutysServiceIMPL")
public class SocialDutysServiceIMPL implements SocialDutysServiceINF{

    @Autowired
    private SocialDutysMapper socialDutysMapper;
    /**
     * 添加社招信息
     * @param socialDutys
     * @return
     */
    @Override
    public boolean addSocialInfo(SocialDutys socialDutys) {
        return socialDutysMapper.addSocialInfo(socialDutys);
    }
    /**
     * 根据id删除社招信息
     * @param sId
     * @return
     */
    @Override
    public boolean delSocialInfoById(Integer sId) {
        return socialDutysMapper.delSocialInfoById(sId);
    }
    /**
     * 根据id更新社招信息
     * @param socialDutys
     * @return
     */
    @Override
    public boolean updateSocialInfoById(SocialDutys socialDutys) {
        return socialDutysMapper.updateSocialInfoById(socialDutys);
    }
    /**
     * 查找所有的社招信息
     * @return
     */
    @Override
    public List<SocialDutys> findAll() {
        return socialDutysMapper.findAll();
    }
    /**
     * 根据地址查询社招信息
     * @return
     */
    @Override
    public List<SocialDutys> findByAddress(String address) {
        return socialDutysMapper.findByAddress(address);
    }
    /**
     * 根据类型查找社招信息
     * @return
     */
    @Override
    public List<SocialDutys> findByType(String type) {
        return socialDutysMapper.findByType(type);
    }
    /**
     * 根据发布日期查找社招信息
     * @return
     */
    @Override
    public List<SocialDutys> findByDate(String date) {
        return socialDutysMapper.findByDate(date);
    }
    /**
     * 根据时间查找社招信息
     * @return
     */
    @Override
    public List<SocialDutys> findByTime(int year, int month, int day) {
        return socialDutysMapper.findByTime(year, month, day);
    }

    @Override
    public SocialDutys findById(Integer sId) {
        return socialDutysMapper.findById(sId);
    }

}
