package com.hr.ssm.service.impl;

import com.hr.api.base.CommonResult;
import com.hr.ssm.entity.ConfigMajorKind;
import com.hr.ssm.mapper.ConfigMajorKindMapper;
import com.hr.ssm.service.ConfigMajorKindService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class ConfigMajorKindServiceImpl extends ServiceImpl<ConfigMajorKindMapper, ConfigMajorKind> implements ConfigMajorKindService {

    @Resource
    private ConfigMajorKindMapper majorKindMapper;

    @Override
    public CommonResult<Object> getAllMajorKind() {

        List<ConfigMajorKind> list = majorKindMapper.selectList(null);

        return new CommonResult<>(200, "ok", list);
    }
}
