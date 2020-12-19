package com.hr.ssm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hr.api.base.CommonResult;
import com.hr.api.base.DataGridView;
import com.hr.ssm.entity.EngageResume;
import com.hr.ssm.service.EngageResumeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

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
        resume.setInterviewStatus(0); // 默认待面试
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

    // checkStatus 0. 待复核 1. 已复核, 下一个环节是面试
    @RequestMapping(value = "/updCheckStatus", method = RequestMethod.PUT)
    public CommonResult<String> updateResume(EngageResume resume) {

        System.out.println("============>" + resume);

        if (resume != null) {
            // 写死 lazy init..
            resume.setRegister("admin");
            resume.setRegisterTime(new Date(System.currentTimeMillis()));
            boolean b = resumeService.updateById(resume);
            if (b) {
                return new CommonResult<>(200, "ok", "ok");
            }
        }

        return new CommonResult<>(444, "bad", "bad");
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public CommonResult<String> delResumeByPkId(@PathVariable("id") Integer id) {

        resumeService.removeById(id);

        return new CommonResult<>(200, "ok", "ok");
    }

    // 录用管理
    @GetMapping("/paging/apply")
    public DataGridView getAllPassResume(Integer page, Integer limit, EngageResume resume) {

        Page<EngageResume> iPage = new Page<>(page, limit);

        if (resume == null) {
            resume.setInterviewStatus(1);
            resume.setInterviewCheckStatus(1);
        }

        return resumeService.getAllPassResume(iPage, resume);
    }

}

