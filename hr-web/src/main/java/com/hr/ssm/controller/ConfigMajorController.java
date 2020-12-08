package com.hr.ssm.controller;


import com.hr.api.base.CommonResult;
import com.hr.ssm.service.ConfigMajorService;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/ssm/config-major")
public class ConfigMajorController {

    @Resource
    private ConfigMajorService majorService;

    @GetMapping("/all")
    CommonResult<Object> getAllConfigMajor() {

        return majorService.getAllConfigMajor();
    }

}

