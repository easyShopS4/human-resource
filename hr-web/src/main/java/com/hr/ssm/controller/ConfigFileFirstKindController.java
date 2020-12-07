package com.hr.ssm.controller;


import com.hr.api.base.CommonResult;
import com.hr.ssm.entity.ConfigFileFirstKind;
import com.hr.ssm.service.ConfigFileFirstKindService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
@RestController
@RequestMapping("/ssm/config-file-first-kind")
public class ConfigFileFirstKindController {

    @Resource
    private ConfigFileFirstKindService fileFirstKindService;

    @RequestMapping("/all")
    public CommonResult<Object> getAllFistKind() {

        List<ConfigFileFirstKind> list = fileFirstKindService.getAllFistKind();

        return new CommonResult<>(200, "ok", list);
    }

    @RequestMapping("/getByFistKindId/{id}")
    public CommonResult<Object> getAllFistKindById(@PathVariable("id") Integer firstKindId) {

        return new CommonResult<>(200, "ok",
                fileFirstKindService.getAllFistKindById(firstKindId));
    }

}

