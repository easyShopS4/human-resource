package com.hr.ssm.mapper;

import com.hr.ssm.entity.ConfigFileFirstKind;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
public interface ConfigFileFirstKindMapper extends BaseMapper<ConfigFileFirstKind> {

    // 查询所有的一级机构
    @Select("select * from config_file_first_kind")
    List<ConfigFileFirstKind> getAllFistKind();

    @Select("select * from config_file_first_kind where first_kind_id = #{firstKindId}")
    List<ConfigFileFirstKind> getAllFistKindById(Integer firstKindId);

}
