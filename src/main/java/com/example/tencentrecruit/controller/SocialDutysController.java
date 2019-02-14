package com.example.tencentrecruit.controller;

import com.example.tencentrecruit.CommonBox.Result;
import com.example.tencentrecruit.CommonBox.ResultGenerator;
import com.example.tencentrecruit.dto.SocialDutys;
import com.example.tencentrecruit.service.ServiceINF.SocialDutysServiceINF;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2018/10/16 下午9:08
 * @since JDK 1.8
 */

@Api(value = "Social", description = "社招模块")//加一个swagger的注解
@RequestMapping(value="/social")
@RestController
public class SocialDutysController {
    @Autowired
    @Qualifier("SocialDutysServiceIMPL")
    private SocialDutysServiceINF socialDutysServiceINF;
    /**
     * 添加社招信息
     * @param socialDutys
     * @return
     */
    @ApiOperation(value = "添加社招信息", httpMethod = "POST", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public Result addSocialInfo(@RequestBody SocialDutys socialDutys) {
        if(!socialDutysServiceINF.addSocialInfo(socialDutys)){
            return ResultGenerator.genFailResult("添加社招信息失败");
        }
        return ResultGenerator.genSuccessResult(true);
    }
    /**
     * 根据id删除社招信息
     * @param sId
     * @return
     */
    @ApiOperation(value = "根据id删除社招信息", httpMethod = "POST", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/del/byId",method = RequestMethod.POST)
    public Result delSocialInfoById(@RequestParam Integer sId) {
        if(!socialDutysServiceINF.delSocialInfoById(sId)){
            return ResultGenerator.genFailResult("删除社招信息失败");
        }
        return ResultGenerator.genSuccessResult(true);
    }
    /**
     * 根据id更新社招信息
     * @param socialDutys
     * @return
     */
    @ApiOperation(value = "根据id更新社招信息", httpMethod = "POST", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/update/byId",method = RequestMethod.POST)
    public Result updateSocialInfoById(@RequestBody SocialDutys socialDutys) {
        if(!socialDutysServiceINF.updateSocialInfoById(socialDutys)){
            return ResultGenerator.genFailResult("更新社招信息失败");
        }
        return ResultGenerator.genSuccessResult(true);
    }
    /**
     * 查找所有的社招信息
     * @return
     */
    @ApiOperation(value = "查找所有的社招信息", httpMethod = "GET", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/find/all",method = RequestMethod.GET)
    public Result findAll() {
        List<SocialDutys> socialDutys = socialDutysServiceINF.findAll();
        if(socialDutys==null){
            return ResultGenerator.genFailResult("查找所有的招聘信息失败");
        }
        return ResultGenerator.genSuccessResult(socialDutys);
    }
    /**
     * 根据地址查询社招信息
     * @return
     */
    @ApiOperation(value = "根据地址查询社招信息", httpMethod = "GET", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/find/byAdress",method = RequestMethod.GET)
    public Result findByAddress(@RequestParam String address) {
        List<SocialDutys> socialDutys = socialDutysServiceINF.findByAddress(address);
        if(socialDutys==null){
            return ResultGenerator.genFailResult("根据地址查找招聘信息失败");
        }
        return ResultGenerator.genSuccessResult(socialDutys);
    }
    /**
     * 根据类型查找社招信息
     * @return
     */
    @ApiOperation(value = "根据类型查找社招信息", httpMethod = "GET", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/find/byType",method = RequestMethod.GET)
    public Result findByType(@RequestParam String type) {
        List<SocialDutys> socialDutys = socialDutysServiceINF.findByType(type);
        if(socialDutys==null){
            return ResultGenerator.genFailResult("根据类型查找招聘信息失败");
        }
        return ResultGenerator.genSuccessResult(socialDutys);
    }
    /**
     * 根据发布日期查找社招信息
     * @return
     */
    @ApiOperation(value = "根据发布日期查找社招信息", httpMethod = "GET", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/find/byDate",method = RequestMethod.GET)
    public Result findByDate(@RequestParam String date) {
        List<SocialDutys> socialDutys = socialDutysServiceINF.findByDate(date);
        if(socialDutys==null){
            return ResultGenerator.genFailResult("根据发布日期查找招聘信息失败");
        }
        return ResultGenerator.genSuccessResult(socialDutys);
    }
    /**
     * 根据时间查找社招信息
     * @return
     */
    @ApiOperation(value = "根据时间查找社招信息", httpMethod = "GET", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/find/byTime",method = RequestMethod.GET)
    public Result findByTime(@RequestParam int year,@RequestParam int month ,@RequestParam int day) {
        List<SocialDutys> socialDutys = socialDutysServiceINF.findByTime(year, month, day);
        if(socialDutys==null){
            return ResultGenerator.genFailResult("根据发布日期查找招聘信息失败");
        }
        return ResultGenerator.genSuccessResult(socialDutys);
    }
    /**
     * 根据id查找社招信息
     * @return
     */
    @ApiOperation(value = "根据id查找社招信息", httpMethod = "GET", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/find/byId",method = RequestMethod.GET)
    public Result findById(@RequestParam Integer sId) {
        SocialDutys socialDuty = socialDutysServiceINF.findById(sId);
        if(socialDuty==null){
            return ResultGenerator.genFailResult("根据id查找社招信息");
        }
        return ResultGenerator.genSuccessResult(socialDuty);
    }
}
