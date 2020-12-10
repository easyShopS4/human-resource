package com.hr.ssm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hr.api.base.CommonResult;
import com.hr.ssm.entity.Role;

/**
 * @Author 不言语OvO
 * @Date 2020/12/8 16:05
 */
public interface RoleService  extends IService<Role> {

    CommonResult<Object> findAllRole() throws Exception;

}
