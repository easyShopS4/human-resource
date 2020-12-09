package com.hr.ssm.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hr.api.base.CommonResult;
import com.hr.api.base.DataGridView;
import com.hr.ssm.entity.EngageMajorRelease;
import com.hr.ssm.service.EngageMajorReleaseService;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/ssm/engage-major-release")
public class EngageMajorReleaseController {

    @Resource
    private EngageMajorReleaseService majorReleaseService;

    @PostMapping("/add")
    public CommonResult<Object> addMajorRelease(EngageMajorRelease majorRelease) {

        return majorReleaseService.addMajorRelease(majorRelease);
    }

    @GetMapping("/paging")
    public DataGridView getMajorReleaseByPage(Integer page, Integer limit) {

        // 页数，每页多少行~
        Page<EngageMajorRelease> p = new Page<>();
        p.setCurrent(page);
        p.setSize(limit);

        // 分页，不带条件~
        return majorReleaseService.getMajorReleaseByPage(p, null);
    }

    @GetMapping("/one/{id}")
    public CommonResult<EngageMajorRelease> getEngageMajorReleaseByPkId(@PathVariable("id") Integer id) {

        return new CommonResult<>(200, "ok", majorReleaseService.getById(id));
    }


}

