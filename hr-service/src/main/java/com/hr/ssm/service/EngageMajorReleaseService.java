package com.hr.ssm.service;

import com.hr.api.base.CommonResult;
import com.hr.ssm.entity.EngageMajorRelease;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
public interface EngageMajorReleaseService extends IService<EngageMajorRelease> {

    // 职位发布登记~
    CommonResult<Object> addMajorRelease(EngageMajorRelease majorRelease);

}
