package com.hr.ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hr.api.base.DataGridView;
import com.hr.ssm.entity.EngageResume;
import com.hr.ssm.mapper.EngageResumeMapper;
import com.hr.ssm.service.EngageResumeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
public class EngageResumeServiceImpl extends ServiceImpl<EngageResumeMapper, EngageResume> implements EngageResumeService {

    @Resource
    private EngageResumeMapper resumeMapper;

    @Override
    public DataGridView getResumeByPageAndCondition(EngageResume resume, IPage<EngageResume> page) {

        QueryWrapper<EngageResume> queryWrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(resume.getCheckStatus())) {
            queryWrapper.eq("check_status", resume.getCheckStatus());
        }

        if (!StringUtils.isEmpty(resume.getInterviewStatus())) {
            queryWrapper.eq("interview_status", resume.getInterviewStatus());
        }

        if (!StringUtils.isEmpty(resume.getHumanMajorId())) {
            queryWrapper.eq("human_major_id", resume.getHumanMajorId());  // 根据职位名称查询~
        }

        if (!StringUtils.isEmpty(resume.getHumanMajorKindId())) {
            queryWrapper.eq("human_major_kind_id", resume.getHumanMajorKindId()); //  根据职位分类模糊查询~
        }

        if (resume.getStartDate() != null) {
            queryWrapper.ge("register_time", resume.getStartDate()); // 根据时间查询~ register_time
        }

        if (resume.getEndDate() != null) {
            queryWrapper.le("register_time", resume.getEndDate()); // 根据时间查询~ register_time
        }

        IPage<EngageResume> resumeIPage = resumeMapper.selectPage(page, queryWrapper);

        return new DataGridView("", 0, resumeIPage.getTotal(), resumeIPage.getRecords());
    }
}
