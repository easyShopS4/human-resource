package com.hr.ssm.service.impl;

import com.hr.api.base.CommonResult;
import com.hr.ssm.entity.ConfigFileThirdKind;
import com.hr.ssm.mapper.ConfigFileThirdKindMapper;
import com.hr.ssm.service.ConfigFileThirdKindService;
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
public class ConfigFileThirdKindServiceImpl extends ServiceImpl<ConfigFileThirdKindMapper, ConfigFileThirdKind> implements ConfigFileThirdKindService {

    @Resource
    private ConfigFileThirdKindMapper thirdKindMapper;

    @Override
    public CommonResult<Object> getAllThirdKind() {

        return new CommonResult<>(200, "ok", thirdKindMapper.selectList(null));
    }

    @Override
    public CommonResult<Object> getAllThirdKindByThirdId(Integer thirdId) {

        Map<String, Object> colMap = new HashMap<>();

        colMap.put("third_kind_id", thirdId);

        // 包含了1 2 3级机构~
        List<ConfigFileThirdKind> list = thirdKindMapper.selectByMap(colMap);

        return new CommonResult<>(200, "ok", list);
    }
}
