package com.hr.ssm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hr.api.base.CommonResult;
import com.hr.api.base.DataGridView;
import com.hr.ssm.entity.EngageResume;
import com.hr.ssm.service.EngageResumeService;
import org.springframework.web.bind.annotation.*;

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

        resume.setCheckStatus(0); // 默认未复核~
        boolean b = resumeService.save(resume);

        if (b) {
            return new CommonResult<>(200, "ok", 1);
        }

        return new CommonResult<>(500, "新增失败", 0);
    }

    @GetMapping("/paging")
    public DataGridView getResumeByPageAndCondition(EngageResume resume, Integer page, Integer limit) {

        IPage<EngageResume> iPage = new Page<>(page, limit);

        return resumeService.getResumeByPageAndCondition(resume, iPage);
    }

    @GetMapping("/one/{id}")
    public CommonResult<EngageResume> getEngageResumeByPkId(@PathVariable("id") Integer id) {

        return new CommonResult<>(200, "ok", resumeService.getById(id));
    }

}

