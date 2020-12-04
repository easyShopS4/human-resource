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
public class ConfigPrimaryKey implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "prk_id", type = IdType.AUTO)
    private Integer prkId;

    private String primaryKeyTable;

    private String primaryKey;

    private String keyName;

    private Integer primaryKeyStatus;


}
