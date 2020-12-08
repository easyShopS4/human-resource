package com.hr.ssm.service.impl;

import com.hr.api.base.CommonResult;
import com.hr.ssm.entity.ConfigMajor;
import com.hr.ssm.mapper.ConfigMajorMapper;
import com.hr.ssm.service.ConfigMajorService;
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
public class ConfigMajorServiceImpl extends ServiceImpl<ConfigMajorMapper, ConfigMajor> implements ConfigMajorService {

    @Resource
    private ConfigMajorMapper majorMapper;

    @Override
    public CommonResult<Object> getAllConfigMajor() {
        List<ConfigMajor> list = majorMapper.selectList(null);

        return new CommonResult<>(200, "ok", list);
    }
}
