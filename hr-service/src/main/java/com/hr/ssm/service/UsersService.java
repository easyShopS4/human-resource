package com.hr.ssm.service;

import com.hr.api.base.CommonResult;
import com.hr.ssm.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
public interface UsersService extends IService<Users> {

    CommonResult<Users> doLogin(Users user);

}
