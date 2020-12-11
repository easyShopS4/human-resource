package com.hr.ssm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Users implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "u_id", type = IdType.AUTO)
    private Integer uId;

    private String uName;

    private String uTrueName;

    private String uPassword;

    /**
     * 盐
     */
    private String uSalt;

    // 它在表中不存在`
    @TableField(exist = false)
    private List<Role> roleList;


}
