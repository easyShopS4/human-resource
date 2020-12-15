package com.hr.ssm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hr.api.base.CommonResult;
import com.hr.api.base.DataGridView;
import com.hr.ssm.entity.EngageInterview;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
public interface EngageInterviewService extends IService<EngageInterview> {

    CommonResult<Object> updateInterview(EngageInterview interview);

    DataGridView getInterviewByPageAndCondition(IPage<EngageInterview> iPage, EngageInterview interview);

}
