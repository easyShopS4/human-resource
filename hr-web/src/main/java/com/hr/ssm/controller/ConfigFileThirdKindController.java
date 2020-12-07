package com.hr.ssm.controller;


import com.hr.api.base.CommonResult;
import com.hr.ssm.service.ConfigFileThirdKindService;
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
@RequestMapping("/ssm/config-file-third-kind")
public class ConfigFileThirdKindController {


    @Resource
    private ConfigFileThirdKindService thirdKindService;

    @RequestMapping("/all")
    public CommonResult<Object> getAllThirdKind() {
        return thirdKindService.getAllThirdKind();
    }

    @RequestMapping("/getByThirdId/{id}")
    public CommonResult<Object> getAllThirdKindByThirdId(@PathVariable("id") Integer thirdId) {
        return thirdKindService.getAllThirdKindByThirdId(thirdId);
    }

}

