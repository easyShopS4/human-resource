package com.hr.ssm.service;

import com.hr.ssm.entity.SalaryGrantBatch;
import com.hr.ssm.entity.SalaryGrantDetails;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hr.ssm.service.impl.SalaryGrantDetailsServiceImpl;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
public interface SalaryGrantDetailsService extends IService<SalaryGrantDetails> {

    public void saveBatch(SalaryGrantBatch sg);


}
