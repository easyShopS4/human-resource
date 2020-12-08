package com.hr.ssm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hr.ssm.entity.Users;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
public interface UsersMapper extends BaseMapper<Users> {

    /**
     * 系统登录 根据用户名称查询单个用户
     * @param user 登录用户
     */
    @Select("select * from users where u_name = #{uName}")
    Users doLogin(Users user);




}
