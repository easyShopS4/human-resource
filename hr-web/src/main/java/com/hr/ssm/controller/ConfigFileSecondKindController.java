package com.hr.ssm.controller;


import com.hr.api.base.CommonResult;
import com.hr.ssm.service.ConfigFileSecondKindService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/ssm/config-file-second-kind")
public class ConfigFileSecondKindController {

    @Resource
    private ConfigFileSecondKindService secondKindService;

    @GetMapping("/all")
    public CommonResult<Object> getAllSecondKind() {
        return secondKindService.getAllSecondKind();
    }

    @GetMapping("/getBySecondId/{id}")
    public CommonResult<Object> getSecondKindBySecondKindId(@PathVariable("id") Integer secondId) {

        return secondKindService.getSecondKindBySecondKindId(secondId);
    }

}

