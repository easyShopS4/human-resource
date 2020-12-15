package com.hr.ssm.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hr.api.base.CommonResult;
import com.hr.api.base.DataGridView;
import com.hr.ssm.entity.EngageInterview;
import com.hr.ssm.entity.EngageResume;
import com.hr.ssm.entity.Users;
import com.hr.ssm.mapper.EngageResumeMapper;
import com.hr.ssm.mapper.UsersMapper;
import com.hr.ssm.service.EngageInterviewService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/ssm/engage-interview")
public class EngageInterviewController {

    @Resource
    EngageInterviewService interviewService;

    @Resource
    UsersMapper userMapper;

    @Resource
    EngageResumeMapper resumeMapper;

    @PostMapping("/add")
    public CommonResult<Integer> addInterview(EngageInterview interview, HttpServletRequest request) {

        // i need...
        Object uid = request.getAttribute("uId");

        if (uid != null) {
            Users user = userMapper.selectById(uid.toString());
            interview.setRegister(user.getUName());
        }
        interview.setRegisterTime(new Date(System.currentTimeMillis()));
        interview.setInterviewStatus(1); // 已经面试

        EngageResume resume = new EngageResume();
        resume.setResId(interview.getResumeId());
        resume.setInterviewStatus(1);// 简历表 已经面试
        resumeMapper.updateById(resume);

        interview.setCheckStatus(0); // 未被筛选
        boolean b = interviewService.save(interview);

        if (b)
            return new CommonResult<>(200, "ok", 1);

        return new CommonResult<>(444, "bad", -1);
    }

    @GetMapping("/one/{id}")
    public CommonResult<EngageInterview> getInterviewById(@PathVariable("id") Integer id) {

        return new CommonResult<>(200, "ok", interviewService.getById(id));
    }


    // upd
    @RequestMapping(value = "/upd", method = RequestMethod.PUT)
    CommonResult<Object> updateInterview(EngageInterview interview, HttpServletRequest request) {

        Object uId = request.getAttribute("uId");
        if (uId != null) {
            Users user = userMapper.selectById(uId.toString());
            interview.setChecker(user.getUName());
        }

        interview.setCheckTime(new Date(System.currentTimeMillis()));

        return interviewService.updateInterview(interview);
    }

    // paging ..
    @GetMapping(value = "/paging")
    DataGridView getInterviewByPageAndCondition(Integer page, Integer limit, EngageInterview interview) {

        Page<EngageInterview> pageInfo = new Page<>(page, limit);

        return interviewService.getInterviewByPageAndCondition(pageInfo, interview);
    }


}

