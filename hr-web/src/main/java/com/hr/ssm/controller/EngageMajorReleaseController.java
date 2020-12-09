package com.hr.ssm.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hr.api.base.CommonResult;
import com.hr.api.base.DataGridView;
import com.hr.ssm.entity.EngageMajorRelease;
import com.hr.ssm.service.EngageMajorReleaseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

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

    @PostMapping("/upd")
    public CommonResult<Boolean> updateEngageMajorReleaseByPkId(EngageMajorRelease majorRelease) {

        // tmp, after my jwt finish~
        majorRelease.setChanger("tmp changer");
        majorRelease.setChangeTime(new Date(System.currentTimeMillis()));
        boolean b = majorReleaseService.updateById(majorRelease);

        if (b) {
            return new CommonResult<>(200, "ok", b);
        }

        return new CommonResult<>(444, "update fail~", false);
    }

    @RequestMapping("del/{id}")
    public CommonResult<Boolean> delEngageMajorReleaseByPkId(@PathVariable("id") Integer id) {

        boolean b = majorReleaseService.removeById(id);

        if (b) {
            return new CommonResult<>(200, "ok", b);
        }

        return new CommonResult<>(444, "delete fail~", false);
    }

}

