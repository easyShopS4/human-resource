package com.hr.ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hr.api.base.CommonResult;
import com.hr.api.base.DataGridView;
import com.hr.api.util.JwtUtil;
import com.hr.api.util.UserUtil;
import com.hr.ssm.entity.Users;
import com.hr.ssm.mapper.UsersMapper;
import com.hr.ssm.service.UsersService;
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
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    // 用户登录加密工具~
    @Resource
    private UserUtil userUtil;

    @Override
    public CommonResult<Object> doLogin(Users user) throws Exception {

        CommonResult<Object> result;

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
            // 对用户的业务数据进行签名。
            String jwtToken = JwtUtil.createToken(tmpUser);
            result = new CommonResult<>(200, "ok", jwtToken);
        } else {
            // 密码错误
            result = new CommonResult<>(403, "密码错误");
        }
        return result;
    }



    @Override
    public DataGridView getUserByPage
            (IPage<Users> page, Wrapper<Users> wrapper) {

        // 分页的所有数据
        IPage<Users> pageInfo = usersMapper.selectPage(page, wrapper);
        // 集合
        List<Users> dataList = pageInfo.getRecords();

        // 返回消息 状态码 当前条件下的行数 数据
        return new DataGridView("", 0, pageInfo.getTotal(), dataList);
    }

    @Override
    public CommonResult<Object> findAllUser() throws Exception {
        CommonResult<Object> result;
        List<Users> users = usersMapper.findAllUser();
        result = new CommonResult<>(0, "ok", users);
        return result;
    }
}


