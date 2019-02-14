package com.example.tencentrecruit.controller;

import com.example.tencentrecruit.CommonBox.Result;
import com.example.tencentrecruit.CommonBox.ResultGenerator;
import com.example.tencentrecruit.dto.Admin;
import com.example.tencentrecruit.service.ServiceINF.AdminServiceINF;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Function:管理员的controller层
 * @author liubing
 * Date: 2018/10/2 下午6:34
 * @since JDK 1.8
 */

@Api(value = "Admin", description = "管理员模块")//加一个swagger的注解
@RequestMapping(value="/admin")
@RestController
public class AdminController {

    @Autowired
    @Qualifier("AdminServiceIMPL")
    private AdminServiceINF adminServiceIMPL;

    @ApiOperation(value = "根据名字查找管理员", httpMethod = "GET", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/find/byName",method = RequestMethod.GET)
    public Result findByAName(@RequestParam String aName){
        Admin admin = adminServiceIMPL.findAdminByAName(aName);
        if(admin==null){
            return ResultGenerator.genFailResult("查找管理员失败");
        }
        return ResultGenerator.genSuccessResult(admin);
    }

}
