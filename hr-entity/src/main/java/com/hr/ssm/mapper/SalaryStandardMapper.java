package com.hr.ssm.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hr.ssm.entity.SalaryGrantBatch;
import com.hr.ssm.entity.SalaryStandard;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 *
 *  change
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
public interface SalaryStandardMapper extends BaseMapper<SalaryStandard> {
    List<SalaryStandard> fintChangeStatus(Integer changeStatus);
    public  List<SalaryStandard> fintBname();
    public  IPage<SalaryStandard> findSalaryStandard(IPage<SalaryStandard> page, @Param("ss") SalaryStandard ss);
    public  IPage<SalaryStandard> findSalaryStandardBG(IPage<SalaryStandard> page, @Param("ss") SalaryStandard ss);

    void updateBatch(SalaryGrantBatch sg);//状态修改
}
