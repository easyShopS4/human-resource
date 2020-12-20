package com.hr.ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.hr.ssm.entity.SalaryGrant;
import com.hr.ssm.entity.SalaryGrantBatch;
import com.hr.ssm.entity.SalaryGrantDetails;
import com.hr.ssm.mapper.SalaryGrantDetailsMapper;
import com.hr.ssm.mapper.SalaryGrantMapper;
import com.hr.ssm.service.SalaryGrantDetailsService;
import com.hr.ssm.service.SalaryGrantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hr.ssm.service.SalaryStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
@Service
public class SalaryGrantServiceImpl extends ServiceImpl<SalaryGrantMapper, SalaryGrant> implements SalaryGrantService {
   @Autowired
  private  SalaryGrantMapper sgm;
    @Autowired
    private SalaryGrantDetailsService sgd;
    @Autowired
    private SalaryStandardService sss;

    public void saveBatch(SalaryGrantBatch sg){
        List<SalaryGrant> list=sg.getListsg();
        for (int i=0;i<list.size();i++){
            list.get(i).setCheckStatus(1);
            System.out.println("没处理的实发工资"+ list.get(i).getSalaryPaidSum());
            list.get(i).setSalaryPaidSum(list.get(i).getSalaryStandardSum()+list.get(i).getBounsSum()+list.get(i).getSaleSum()-list.get(i).getDeductSum());
             System.out.println("处理后的实发工资" + list.get(i).getSalaryPaidSum());
        }
        sgm.saveBatch(sg);//salary_grant薪酬发放登记表(add)
        sgd.saveBatch(sg);//salary_grant_details薪酬发放详细信息(add)
        sss.updateBatch(sg); //修改状态
    }

    public List<SalaryGrant> findListCheck(){

        return sgm.findListCheck();

    }
    public SalaryGrant findById(Integer sgrId){
       return sgm.findById(sgrId);
    }
    public void Updates(SalaryGrant sg){
        sgm.updateCheckStatus(sg); //salary_grant的状态修改

    }
}
