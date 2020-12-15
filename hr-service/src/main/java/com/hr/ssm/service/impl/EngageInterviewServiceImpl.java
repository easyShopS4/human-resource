package com.hr.ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hr.api.base.CommonResult;
import com.hr.api.base.DataGridView;
import com.hr.ssm.entity.EngageInterview;
import com.hr.ssm.entity.EngageResume;
import com.hr.ssm.mapper.EngageInterviewMapper;
import com.hr.ssm.mapper.EngageResumeMapper;
import com.hr.ssm.service.EngageInterviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
@Service
public class EngageInterviewServiceImpl extends ServiceImpl<EngageInterviewMapper, EngageInterview> implements EngageInterviewService {

    @Resource
    private EngageInterviewMapper interviewMapper;

    @Resource
    private EngageResumeMapper resumeMapper;

    @Override
    public CommonResult<Object> updateInterview(EngageInterview interview) {

        Integer checkStatus = interview.getCheckStatus();

        switch (checkStatus) {
            case 1: // 筛选通过, 建议录用
                // do upd
                interview.setResult("通过");
                interview.setCheckComment("建议录用");
                interviewMapper.updateById(interview);
                break;
            case 2: // 2. 建议面试 3. 建议笔试 4. 建议录用 5. 删除面试
                EngageResume resume = new EngageResume();
                resume.setResId(interview.getResumeId());
                resume.setInterviewStatus(0); // 重新设置需要面试
                resumeMapper.updateById(resume);

                interview.setResult("未通过");
                interview.setCheckComment("建议面试");
                interviewMapper.updateById(interview);
                break;
            case 3:
                System.out.println("这边建议笔试呢...");
                break;
            case 4: // 删除简历
                resumeMapper.deleteById(interview.getResumeId());
                interviewMapper.deleteById(interview.getEinId());
                break;
            default:
                System.out.println("nothing to do ...");
                break;
        }


        return new CommonResult<>(200, "ok", "操作成功~");
    }


    @Override
    public DataGridView getInterviewByPageAndCondition(IPage<EngageInterview> iPage, EngageInterview interview) {

        QueryWrapper<EngageInterview> wrapper = new QueryWrapper<>();

        if (interview.getCheckStatus() != null) {
            wrapper.eq("check_status", interview.getCheckStatus());
        }

        // page info~
        IPage<EngageInterview> page = interviewMapper.selectPage(iPage, wrapper);

        return new DataGridView("", 0, page.getTotal(), page.getRecords());
    }

}
