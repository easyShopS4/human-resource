package com.hr.ssm.controller;


import com.hr.api.base.CommonResult;
import com.hr.ssm.entity.Users;
import com.hr.ssm.service.UsersService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
@RestController
@RequestMapping("/ssm/users")
public class UsersController {

    @Resource
    private UsersService userService;

    @RequestMapping("/login")
    public CommonResult<Users> doLogin(Users user) {

        return userService.doLogin(user);
    }

}

