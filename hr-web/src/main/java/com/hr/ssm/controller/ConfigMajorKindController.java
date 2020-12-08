package com.hr.ssm.controller;


import com.hr.api.base.CommonResult;
import com.hr.ssm.service.ConfigMajorKindService;
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
@RequestMapping("/ssm/config-major-kind")
public class ConfigMajorKindController {

    @Resource
    private ConfigMajorKindService majorKindService;

    // 获取所有的职位种类~
    @GetMapping("/all")
    public CommonResult<Object> getAllMajorKind() {

        return majorKindService.getAllMajorKind();
    }

}

