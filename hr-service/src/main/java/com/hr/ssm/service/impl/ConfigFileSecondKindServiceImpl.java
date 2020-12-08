package com.hr.ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hr.api.base.CommonResult;
import com.hr.ssm.entity.ConfigFileSecondKind;
import com.hr.ssm.entity.ConfigFileThirdKind;
import com.hr.ssm.mapper.ConfigFileSecondKindMapper;
import com.hr.ssm.mapper.ConfigFileThirdKindMapper;
import com.hr.ssm.service.ConfigFileSecondKindService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    private ConfigFileThirdKindMapper thirdKindMapper;

    @Override
    public CommonResult<Object> getAllSecondKind() {
        List<ConfigFileSecondKind> list = secondKindMapper.selectList(null);

        return new CommonResult<>(200, "ok", list);
    }

    // 根据二级id查询对应的集合
    @Override
    public CommonResult<Object> getSecondKindBySecondKindId(Integer secondKindId) {

        Map<String, Object> colMap = new HashMap<>();

        // 二级和一级机构~
        colMap.put("second_kind_id", secondKindId);
        List<ConfigFileSecondKind> list = secondKindMapper.selectByMap(colMap);
        colMap.clear();

        // 三级机构
        colMap.put("second_kind_id", secondKindId);
        List<ConfigFileThirdKind> list1 = thirdKindMapper.selectByMap(colMap);

        List<Object> res = new ArrayList<>();
        res.add(list);
        res.add(list1);

        return new CommonResult<>(200, "ok", res);
    }
}
