package com.hr.ssm.controller;

import com.hr.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 不言语OvO
 * @Date 2020/12/8 16:07
 */
@RestController
@RequestMapping("/ssm/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

}
