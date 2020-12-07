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
public class ConfigFileFirstKind implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 一级机构主键
     */
    @TableId(value = "ffk_id", type = IdType.AUTO)
    private Integer ffkId;

    /**
     * 一级机构id
     */
    private Integer firstKindId;

    /**
     * 一级机构名称
     */
    private String firstKindName;

    /**
     * 一级机构薪酬发放人编号
     */
    private Integer firstKindSalaryId;

    /**
     * 一级机构销售负责人编号
     */
    private Integer firstKindSaleId;


}
