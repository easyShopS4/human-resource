package com.hr.ssm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class ConfigPublicChar implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "pbc_id", type = IdType.AUTO)
    private Integer pbcId;

    private String attributeKind;

    private String attributeName;


}
