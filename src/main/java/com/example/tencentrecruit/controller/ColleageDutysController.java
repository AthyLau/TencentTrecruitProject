package com.example.tencentrecruit.controller;

import com.example.tencentrecruit.CommonBox.Result;
import com.example.tencentrecruit.CommonBox.ResultGenerator;
import com.example.tencentrecruit.dto.ColleageDutys;
import com.example.tencentrecruit.service.ServiceINF.ColleageDutysServiceINF;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2018/10/16 下午9:05
 * @since JDK 1.8
 */

@Api(value = "Colleage", description = "校招模块")//加一个swagger的注解
@RequestMapping(value="/colleage")
@RestController
public class ColleageDutysController {
    @Autowired
    @Qualifier("ColleageDutysServiceIMPL")
    private ColleageDutysServiceINF colleageDutysServiceINF;
    /**
     * 添加一条校园招聘信息
     * @param colleageDutys
     * @return
     */
    @ApiOperation(value = "添加一条校园招聘信息", httpMethod = "POST", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public Result addColleageInfo(@RequestBody ColleageDutys colleageDutys) {
        if(!colleageDutysServiceINF.addColleageInfo(colleageDutys)){
           return ResultGenerator.genFailResult("添加一条校园招聘信息失败");
        }
        return ResultGenerator.genSuccessResult(true);
    }
    /**
     * 删除一条校园招聘信息
     * @param cId
     * @return
     */
    @ApiOperation(value = "删除一条校园招聘信息", httpMethod = "POST", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/del/byId",method = RequestMethod.POST)
    public Result delColleageInfoById(@RequestParam Integer cId) {
        if(!colleageDutysServiceINF.delColleageInfoById(cId)){
            return ResultGenerator.genFailResult("删除一条校园招聘信息失败");
        }
        return ResultGenerator.genSuccessResult(true);
    }
    /**
     * 更新一条校园招聘信息
     * @param colleageDutys
     * @return
     */
    @ApiOperation(value = "更新一条校园招聘信息", httpMethod = "POST", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/update/byId",method = RequestMethod.POST)
    public Result updateColleageInfoById(@RequestBody ColleageDutys colleageDutys) {
        if(!colleageDutysServiceINF.updateColleageInfoById(colleageDutys)){
            return ResultGenerator.genFailResult("更新一条校园招聘信息失败");
        }
        return ResultGenerator.genSuccessResult(true);
    }
    /**
     * 根据id查找校园招聘信息
     * @param cId
     * @return
     */
    @ApiOperation(value = "根据id查找校园招聘信息", httpMethod = "GET", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/find/byId",method = RequestMethod.GET)
    public Result findById(@RequestParam Integer cId) {
        ColleageDutys colleageDutys = colleageDutysServiceINF.findById(cId);
        if(colleageDutys==null){
            return ResultGenerator.genFailResult("查询一条校园招聘信息失败");
        }
        return ResultGenerator.genSuccessResult(colleageDutys);
    }
    /**
     * 查询所有的校园招聘信息
     * @return
     */
    @ApiOperation(value = "查询所有的校园招聘信息", httpMethod = "GET", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/find/all",method = RequestMethod.GET)
    public Result findAll() {
        List<ColleageDutys> colleageDutys = colleageDutysServiceINF.findAll();
        if(colleageDutys==null){
            return ResultGenerator.genFailResult("查询所有的校园招聘信息失败");
        }
        return ResultGenerator.genSuccessResult(colleageDutys);
    }
    /**
     * 根据日期查找校园招聘信息
     * @param year
     * @param month
     * @param day
     * @return
     */
    @ApiOperation(value = "根据日期查找校园招聘信息", httpMethod = "GET", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/find/byDate",method = RequestMethod.GET)
    public Result findByDate(@RequestParam Integer year,@RequestParam Integer month,@RequestParam Integer day) {
        List<ColleageDutys> colleageDutys = colleageDutysServiceINF.findByDate(year,month,day);
        if(colleageDutys==null){
            return ResultGenerator.genFailResult("根据时间查询校园招聘信息失败");
        }
        return ResultGenerator.genSuccessResult(colleageDutys);
    }
    /**
     * 根据类型模糊查找校园招聘信息
     * @param type
     * @return
     */
    @ApiOperation(value = "根据类型模糊查找校园招聘信息", httpMethod = "GET", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/find/byTyoe",method = RequestMethod.GET)
    public Result findByType(@RequestParam String type) {

        List<ColleageDutys> colleageDutys = colleageDutysServiceINF.findByType(type);
        if(colleageDutys==null){
            return ResultGenerator.genFailResult("根据类型查询校园招聘信息失败");
        }
        return ResultGenerator.genSuccessResult(colleageDutys);
    }
    /**
     * 根据地址模糊查找校园招聘信息
     * @param address
     * @return
     */
    @ApiOperation(value = "根据地址模糊查找校园招聘信息", httpMethod = "GET", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/find/byAddress",method = RequestMethod.GET)
    public Result findByAddress(@RequestParam String address) {

        List<ColleageDutys> colleageDutys = colleageDutysServiceINF.findByAddress(address);
        if(colleageDutys==null){
            return ResultGenerator.genFailResult("根据工作地址查询校园招聘信息失败");
        }
        return ResultGenerator.genSuccessResult(colleageDutys);
    }
}
