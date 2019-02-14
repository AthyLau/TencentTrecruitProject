package com.example.tencentrecruit.expertController;

import com.example.tencentrecruit.CommonBox.Result;
import com.example.tencentrecruit.CommonBox.ResultGenerator;
import com.example.tencentrecruit.dto.User;
import com.example.tencentrecruit.service.ServiceINF.AdminServiceINF;
import com.example.tencentrecruit.service.ServiceINF.UserServiceINF;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Function:用户的综合接口controller
 *
 * @author liubing
 * Date: 2018/10/9 下午4:04
 * @since JDK 1.8
 */

@Api(value = "SYS/User", description = "SYS模块")//加一个swagger的注解
@RequestMapping(value="/sys/user")
@RestController
public class UserSYSController {
    @Autowired
    private AdminServiceINF adminServiceINF;
    @Autowired
    private UserServiceINF userServiceINF;

    /**
     * 用户登陆接口
     */
    @ApiOperation(value = "用户登陆接口", httpMethod = "POST")//加一个swagger的注解
    @RequestMapping(value="/userLogin",method = RequestMethod.POST)
    public Result userLogin(@RequestBody User user){
        String password = user.getUPassword();
        user = userServiceINF.findUserByUName(user.getUName());
        if(user!=null&&user.getUPassword().equals(password)){
            return ResultGenerator.genSuccessResult(true);
        }
        return ResultGenerator.genFailResult("用户名或者密码错误");
    }
}
