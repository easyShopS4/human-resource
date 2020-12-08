package com.hr.ssm.service.impl;

import com.hr.api.base.CommonResult;
import com.hr.ssm.entity.EngageMajorRelease;
import com.hr.ssm.mapper.EngageMajorReleaseMapper;
import com.hr.ssm.service.EngageMajorReleaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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
}
