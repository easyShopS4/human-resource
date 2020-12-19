package com.hr.ssm.mapper;

import com.hr.ssm.entity.SalaryGrant;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hr.ssm.entity.SalaryGrantBatch;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
public interface SalaryGrantMapper extends BaseMapper<SalaryGrant> {

    public void saveBatch(SalaryGrantBatch list);

    public List<SalaryGrant> findListCheck();

    public SalaryGrant findById(Integer sgrId);
}
