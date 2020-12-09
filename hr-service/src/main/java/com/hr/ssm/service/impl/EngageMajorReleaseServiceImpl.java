package com.hr.ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hr.api.base.CommonResult;
import com.hr.api.base.DataGridView;
import com.hr.ssm.entity.EngageMajorRelease;
import com.hr.ssm.mapper.EngageMajorReleaseMapper;
import com.hr.ssm.service.EngageMajorReleaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
public class EngageMajorReleaseServiceImpl extends ServiceImpl<EngageMajorReleaseMapper, EngageMajorRelease> implements EngageMajorReleaseService {

    @Resource
    private EngageMajorReleaseMapper majorReleaseMapper;

    @Override
    public CommonResult<Object> addMajorRelease(EngageMajorRelease majorRelease) {

        majorRelease.setChanger(null);
        majorRelease.setChangeTime(null);
        majorRelease.setRegisterTime(new Date());

        int res = majorReleaseMapper.insert(majorRelease);

        return new CommonResult<>(200, "ok", res);
    }

    @Override
    public DataGridView getMajorReleaseByPage
            (IPage<EngageMajorRelease> page, Wrapper<EngageMajorRelease> wrapper) {

        // 分页的所有数据
        IPage<EngageMajorRelease> pageInfo = majorReleaseMapper.selectPage(page, wrapper);
        // 集合
        List<EngageMajorRelease> dataList = pageInfo.getRecords();

        // 返回消息 状态码 当前条件下的行数 数据
        return new DataGridView("", 0, pageInfo.getTotal(), dataList);
    }

}
