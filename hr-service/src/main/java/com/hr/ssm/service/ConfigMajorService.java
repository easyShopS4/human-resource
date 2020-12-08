package com.hr.ssm.service;

import com.hr.api.base.CommonResult;
import com.hr.ssm.entity.ConfigMajor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  职位设置 职位名称~
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
public interface ConfigMajorService extends IService<ConfigMajor> {

    CommonResult<Object> getAllConfigMajor();

}
