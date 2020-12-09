package com.hr.ssm.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hr.api.base.CommonResult;
import com.hr.api.base.DataGridView;
import com.hr.ssm.entity.Users;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
public interface UsersService extends IService<Users> {

     //用户登录
    CommonResult<Object> doLogin(Users user) throws Exception;

    //用户分页
    DataGridView getUserByPage(IPage<Users> page, Wrapper<Users> wrapper);

    //查询所有用户
    CommonResult<Object> findAllUser() throws Exception;


}
