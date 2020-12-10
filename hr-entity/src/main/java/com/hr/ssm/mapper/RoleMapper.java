package com.hr.ssm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hr.ssm.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author 不言语OvO
 * @Date 2020/12/8 16:04
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 查询所有角色
     */

    @Select("SELECT * FROM role")
    List<Role> findAllRole();


}
