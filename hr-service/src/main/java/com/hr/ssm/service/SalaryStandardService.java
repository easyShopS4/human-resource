package com.hr.ssm.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hr.api.base.DataGridView;
import com.hr.ssm.entity.EngageMajorRelease;
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
     //四个条件查询
  public List<SalaryStandard> findSalaryStandard(SalaryStandard ss);

    // 职位变更分页~
    DataGridView getSalaryStandardByPage(IPage<SalaryStandard> page, Wrapper<SalaryStandard> wrapper);


}
