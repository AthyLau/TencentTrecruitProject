package com.example.tencentrecruit.controller;

import com.example.tencentrecruit.CommonBox.Result;
import com.example.tencentrecruit.CommonBox.ResultGenerator;
import com.example.tencentrecruit.dto.User;
import com.example.tencentrecruit.service.ServiceINF.UserServiceINF;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Function:操作用户的controller
 *
 * @author liubing
 * Date: 2018/9/30 下午2:24
 * @since JDK 1.8
 */


/**
 * Function:操作用户的controller
 *
 * @author liubing
 * Date: 2018/9/30 下午2:24
 * @since JDK 1.8
 */

@Api(value = "User", description = "用户模块")//加一个swagger的注解
@RequestMapping(value="/user")
@RestController
public class UserController {

    @Autowired
    @Qualifier("UserServiceIMPL")
    private UserServiceINF userServiceIMPL;

    /**
     * 添加一个用户
     * @param user
     * @return
     */
    @ApiOperation(value = "添加一个用户", httpMethod = "POST")//加一个swagger的注解
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public Result addUser(@RequestBody User user){
        String message = userServiceIMPL.addUserStr(user);
        if(message.equals("注册成功")){
            return ResultGenerator.genSuccessResult(true);
        } else{
            message = "添加用户失败,"+message;
            return ResultGenerator.genFailResult(message);
        }
    }
    /**
     * 删除一个用户
     * @param uName
     * @return
     */
    @ApiOperation(value = "删除一个用户返回值为删除的User对象", httpMethod = "GET", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/del/ByName",method = RequestMethod.GET)
    public Result deleteUserByUName(@RequestParam String uName){
        if(!userServiceIMPL.deleteUserByUName(uName)){
            return ResultGenerator.genFailResult("删除一个用户失败");
        }
        return ResultGenerator.genSuccessResult(true);
    }
    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @ApiOperation(value = "更新用户信息", httpMethod = "POST")//加一个swagger的注解
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Result updateUser(@RequestBody User user){
        if(!userServiceIMPL.updateUser(user)){
            return ResultGenerator.genFailResult("更新用户信息");
        }
        return ResultGenerator.genSuccessResult(true);
    }
    /**
     * 查出所有的用户
     * @return
     */
    @ApiOperation(value = "查出所有的用户", httpMethod = "GET", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/find/all",method = RequestMethod.GET)
    public Result findAllUsers(){
        List<User> users = userServiceIMPL.findAllUsers();
        if(users==null){
            return ResultGenerator.genFailResult("查出所有的用户失败");
        }
        return ResultGenerator.genSuccessResult(users);
    }
    /**
     * 根据名字查出用户（模糊查找）
     * @param halfName
     * @return
     */
    @ApiOperation(value = "添加一个产品", httpMethod = "GET", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/find/byHalfName",method = RequestMethod.GET)
    public Result findUsersByHalfName(@RequestParam String halfName){
        return ResultGenerator.genSuccessResult(userServiceIMPL.findUsersByHalfName(halfName));
    }

    /**
     * 根据名字查出单个用户
     * @param uName
     * @return
     */
    @ApiOperation(value = "根据名字查出单个用户", httpMethod = "GET", response = ResponseEntity.class)//加一个swagger的注解
    @RequestMapping(value="/find/byName",method = RequestMethod.GET)
    public Result findUserByUName(@RequestParam String uName){
        return ResultGenerator.genSuccessResult(userServiceIMPL.findUserByUName(uName));
    }

}
