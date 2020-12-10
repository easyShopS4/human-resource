package com.hr.ssm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hr.api.base.CommonResult;
import com.hr.ssm.entity.Role;
import com.hr.ssm.mapper.RoleMapper;
import com.hr.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 不言语OvO
 * @Date 2020/12/8 16:06
 */
@Service
public class RoleServiceImpl  extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public CommonResult<Object> findAllRole() throws Exception {
        CommonResult<Object> result;
        List<Role> role = roleMapper.findAllRole();
        result = new CommonResult<>(0, "ok", role);
        return result;
    }


}
