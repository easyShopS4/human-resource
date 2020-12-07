package com.hr.ssm.service.impl;

import com.hr.api.base.CommonResult;
import com.hr.api.util.UserUtil;
import com.hr.ssm.entity.Users;
import com.hr.ssm.mapper.UsersMapper;
import com.hr.ssm.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    // 用户登录加密工具~
    @Resource
    private UserUtil userUtil;

    @Override
    public CommonResult<Users> doLogin(Users user) {

        CommonResult<Users> result;

        Users tmpUser = usersMapper.doLogin(user);

        if (tmpUser == null) {
            // 账号不存在~
            result = new CommonResult<>(404, "账号不存在");
            return result;
        }

        // 用户的真实密码
        String password = tmpUser.getUPassword();

        // 验证用户的密码
        String tmpPassword = userUtil.generatePassword(user.getUPassword(), tmpUser.getUSalt());

        if (password.equals(tmpPassword)) {
            // 密码正确
            result = new CommonResult<>(200, "ok");
        } else {
            // 密码错误
            result = new CommonResult<>(403, "密码错误");
        }
        return result;
    }



}
