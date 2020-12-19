package com.hr.ssm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hr.ssm.entity.EngageResume;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
public interface EngageResumeMapper extends BaseMapper<EngageResume> {


    /**
     select er.human_name, er.human_age, er.human_sex, er.human_major_kind_name, er.human_major_name, er.human_college, er.human_educated_major
     from engage_resume er right join engage_interview ei
     on er.res_id = ei.resume_id
     where ei.check_status = 1 and er.interview_status = 1;

     ei checkStatus为面试表
     */

    // 简历过了 需要提交录用申请
    @Select("select er.res_id, er.human_name, er.human_age, er.human_sex, er.human_major_kind_name, er.human_major_name, er.human_college, er.human_educated_major, ei.ein_id as einId" +
            "     from engage_resume er right join engage_interview ei" +
            "     on er.res_id = ei.resume_id" +
            "     where ei.check_status = #{resume.interviewCheckStatus} and er.interview_status = #{resume.interviewStatus}") // er.interview_status已经完全通过面试的.为1 ----> er.interviewStatus 1 是通过面试的
    @Result(column = "einId", property = "einId")
    IPage<EngageResume> getAllPassResume(IPage<EngageResume> iPage, @Param("resume") EngageResume resume);

}
