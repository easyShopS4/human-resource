package com.hr.ssm.service;

import com.hr.api.base.CommonResult;
import com.hr.ssm.entity.ConfigMajorKind;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  职位分类~ 销售，软件开发，hr, 生产部~
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
public interface ConfigMajorKindService extends IService<ConfigMajorKind> {

    CommonResult<Object> getAllMajorKind();

}
