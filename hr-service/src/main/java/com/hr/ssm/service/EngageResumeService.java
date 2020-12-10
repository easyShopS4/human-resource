package com.hr.ssm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hr.api.base.DataGridView;
import com.hr.ssm.entity.EngageResume;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
public interface EngageResumeService extends IService<EngageResume> {

    DataGridView getResumeByPageAndCondition(EngageResume resume, IPage<EngageResume> page);

}
