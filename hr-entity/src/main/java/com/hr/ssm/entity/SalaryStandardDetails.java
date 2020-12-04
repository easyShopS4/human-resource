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
public class SalaryStandardDetails implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "sdt_id", type = IdType.AUTO)
    private Integer sdtId;

    private String standardId;

    private String standardName;

    private Integer itemId;

    private String itemName;

    private Double salary;


}
