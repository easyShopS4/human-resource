package com.hr.ssm.controller;


import com.hr.api.base.CommonResult;
import com.hr.ssm.entity.EngageResume;
import com.hr.ssm.service.EngageResumeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 *  简历管理
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
@RestController
@RequestMapping("/ssm/engage-resume")
public class EngageResumeController {

    @Resource
    private EngageResumeService resumeService;

    @PostMapping("/add")
    public CommonResult<Integer> addResume(EngageResume resume) {

        boolean b = resumeService.save(resume);

        if (b) {
            return new CommonResult<>(200, "ok", 1);
        }

        return new CommonResult<>(500, "新增失败", 0);
    }

}

