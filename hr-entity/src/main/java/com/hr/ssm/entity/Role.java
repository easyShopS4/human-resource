package com.hr.ssm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Author 不言语OvO
 * @Date 2020/12/8 16:02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Role implements Serializable {

    @TableId(value = "r_id", type = IdType.AUTO)
    private Integer rId;

    private String rName;

    private String rExplain;


}
