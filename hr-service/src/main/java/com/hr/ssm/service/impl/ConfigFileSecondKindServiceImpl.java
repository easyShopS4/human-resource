package com.hr.ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hr.api.base.CommonResult;
import com.hr.ssm.entity.ConfigFileSecondKind;
import com.hr.ssm.mapper.ConfigFileSecondKindMapper;
import com.hr.ssm.service.ConfigFileSecondKindService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
@Service
public class ConfigFileSecondKindServiceImpl extends ServiceImpl<ConfigFileSecondKindMapper, ConfigFileSecondKind> implements ConfigFileSecondKindService {

    @Resource
    private ConfigFileSecondKindMapper secondKindMapper;

    @Override
    public CommonResult<Object> getAllSecondKind() {
        List<ConfigFileSecondKind> list = secondKindMapper.selectList(null);

        return new CommonResult<>(200, "ok", list);
    }

    // 根据二级id查询对应的集合
    @Override
    public CommonResult<Object> getSecondKindBySecondKindId(Integer secondId) {

        Map<String, Object> colMap = new HashMap<>();

        colMap.put("second_kind_id", secondId);

        List<ConfigFileSecondKind> list = secondKindMapper.selectByMap(colMap);
        return new CommonResult<>(200, "ok", list);
    }
}
