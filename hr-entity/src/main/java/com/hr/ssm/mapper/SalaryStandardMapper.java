package com.hr.ssm.mapper;

import com.hr.ssm.entity.SalaryStandard;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
public interface SalaryStandardMapper extends BaseMapper<SalaryStandard> {
    public List<SalaryStandard> findSalaryStandard(SalaryStandard ss);
}
