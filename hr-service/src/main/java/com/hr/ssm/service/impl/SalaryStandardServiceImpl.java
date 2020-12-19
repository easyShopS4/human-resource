package com.hr.ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hr.api.base.DataGridView;
import com.hr.ssm.entity.EngageMajorRelease;
import com.hr.ssm.entity.SalaryGrantBatch;
import com.hr.ssm.entity.SalaryStandard;
import com.hr.ssm.mapper.SalaryStandardMapper;
import com.hr.ssm.service.SalaryStandardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class SalaryStandardServiceImpl extends ServiceImpl<SalaryStandardMapper, SalaryStandard> implements SalaryStandardService {
    @Autowired
  private  SalaryStandardMapper  SsalaryStandardMapper;

    public DataGridView findSalaryStandard(IPage<SalaryStandard> page,SalaryStandard wrapper){
        // 分页的所有数据(多条件)
        IPage<SalaryStandard> pageInfo = SsalaryStandardMapper.findSalaryStandard(page, wrapper);

        // 集合
        List<SalaryStandard> dataList = pageInfo.getRecords();


        // 返回消息 状态码 当前条件下的行数 数据
        return new DataGridView("", 0, pageInfo.getTotal(), dataList);
    }

    public DataGridView findSalaryStandardBG(IPage<SalaryStandard> page,SalaryStandard wrapper){
        // 分页的所有数据(多条件)变更
        IPage<SalaryStandard> pageInfo = SsalaryStandardMapper.findSalaryStandardBG(page, wrapper);

        // 集合
        List<SalaryStandard> dataList = pageInfo.getRecords();


        // 返回消息 状态码 当前条件下的行数 数据
        return new DataGridView("", 0, pageInfo.getTotal(), dataList);
    }


    public DataGridView getSalaryStandardByPage
            (IPage<SalaryStandard> page, Wrapper<SalaryStandard> wrapper) {

        SalaryStandard ss = new SalaryStandard();
        ss.setCheckStatus(1);
        Wrapper<SalaryStandard> w = new QueryWrapper<>(ss);

        // 分页的所有数据
        IPage<SalaryStandard> pageInfo = SsalaryStandardMapper.selectPage(page, w);

        // 集合
        List<SalaryStandard> dataList = pageInfo.getRecords();
        for(int i=0;i<dataList.size();i++){
                    System.out.println("打印数据"+dataList.get(i));

        }


        // 返回消息 状态码 当前条件下的行数 数据
        return new DataGridView("", 0, pageInfo.getTotal(), dataList);
    }

    public List<SalaryStandard> fintBname(){
            return SsalaryStandardMapper.fintBname();
    }
    public List<SalaryStandard> fintChangeStatus(Integer changeStatus){
       return SsalaryStandardMapper.fintChangeStatus(changeStatus);

    }
    //状态修改
    public void updateBatch(SalaryGrantBatch sg){
        SsalaryStandardMapper.updateBatch(sg);
    }
}
