package com.hr.ssm.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hr.api.annotation.AuthCheck;
import com.hr.api.base.CommonResult;
import com.hr.api.base.DataGridView;
import com.hr.ssm.entity.Users;
import com.hr.ssm.service.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    /**
     * 使用jwt验证用户是否登录~ 请求发送到这里
     * @return 返回msg
     */
    @PostMapping("/check")
    @AuthCheck // 此注解必加，拦截器会读取此注解
    public void checkAuth() {

    }


    /**
     * 用户登录
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public CommonResult<Object> doLogin(Users user) throws Exception {
        return userService.doLogin(user);
    }


    /**
     * 用户分页
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/paging")
    public DataGridView getUserByPage(Integer page, Integer limit) {

        // 页数，每页多少行~
        Page<Users> p = new Page<>();
        p.setCurrent(page);
        p.setSize(limit);

        // 分页，不带条件~
        return userService.getUserByPage(p, null);
    }

    /**
     * 查询所有用户
     */


}

