package com.hr.ssm.mapper;

import com.hr.ssm.entity.SalaryGrant;
import com.hr.ssm.entity.SalaryGrantBatch;
import com.hr.ssm.entity.SalaryGrantDetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
public interface SalaryGrantDetailsMapper extends BaseMapper<SalaryGrantDetails> {

    void saveBatch(SalaryGrantBatch sg);

    void updateSum(SalaryGrant sg);
}
