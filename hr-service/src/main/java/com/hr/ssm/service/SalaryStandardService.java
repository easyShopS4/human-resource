package com.hr.ssm.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hr.api.base.DataGridView;
import com.hr.ssm.entity.EngageMajorRelease;
import com.hr.ssm.entity.SalaryGrantBatch;
import com.hr.ssm.entity.SalaryStandard;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hr.ssm.mapper.SalaryStandardMapper;
import com.hr.ssm.service.impl.SalaryStandardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */

public interface SalaryStandardService extends IService<SalaryStandard> {
    List<SalaryStandard> fintChangeStatus(Integer changeStatus);

    List<SalaryStandard> fintBname();
    //变更四个条件查询
    DataGridView findSalaryStandardBG(IPage<SalaryStandard> page, SalaryStandard wrapper);
     //四个条件查询
     DataGridView findSalaryStandard(IPage<SalaryStandard> page, SalaryStandard wrapper);

    // 分页~
    DataGridView getSalaryStandardByPage(IPage<SalaryStandard> page, Wrapper<SalaryStandard> wrapper);

    public void updateBatch(SalaryGrantBatch sg); //状态修改

}
