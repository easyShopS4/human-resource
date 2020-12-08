package com.hr.ssm.service.impl;

import com.hr.ssm.entity.ConfigFileFirstKind;
import com.hr.ssm.entity.ConfigFileSecondKind;
import com.hr.ssm.entity.ConfigFileThirdKind;
import com.hr.ssm.mapper.ConfigFileFirstKindMapper;
import com.hr.ssm.mapper.ConfigFileSecondKindMapper;
import com.hr.ssm.mapper.ConfigFileThirdKindMapper;
import com.hr.ssm.service.ConfigFileFirstKindService;
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
public class ConfigFileFirstKindServiceImpl extends ServiceImpl<ConfigFileFirstKindMapper, ConfigFileFirstKind> implements ConfigFileFirstKindService {

    @Resource
    private ConfigFileFirstKindMapper firstKindMapper;

    @Resource
    private ConfigFileSecondKindMapper secondKindMapper;

    @Resource
    private ConfigFileThirdKindMapper thirdKindMapper;

    @Override
    public List<ConfigFileFirstKind> getAllFistKind() {

        return firstKindMapper.selectList(null);
    }

    // 根据一级机构id查询, 非主键值
    @Override
    public List<Object> getAllFistKindById(Integer firstKindId) {

        Map<String, Object> colMap = new HashMap<>();

        colMap.put("first_kind_id", firstKindId);
        List<ConfigFileFirstKind> list1 = firstKindMapper.selectByMap(colMap);
        colMap.clear();

        colMap.put("first_kind_id", firstKindId);
        List<ConfigFileSecondKind> list2 = secondKindMapper.selectByMap(colMap);
        colMap.clear();

        colMap.put("first_kind_id", firstKindId);
        List<ConfigFileThirdKind> list3 = thirdKindMapper.selectByMap(colMap);

        List<Object> res = new ArrayList<>();
        res.add(list1);
        res.add(list2);
        res.add(list3);

        return res;
    }

}
