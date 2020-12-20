package com.hr.ssm.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.hr.ssm.entity.SalaryGrant;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hr.ssm.entity.SalaryGrantBatch;
import com.hr.ssm.service.impl.SalaryGrantServiceImpl;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
public interface SalaryGrantService extends IService<SalaryGrant> {

    public void saveBatch(SalaryGrantBatch sg);

    public List<SalaryGrant> findListCheck();

    public SalaryGrant findById(Integer sgrId);

    public void Updates(SalaryGrant sg);

}
