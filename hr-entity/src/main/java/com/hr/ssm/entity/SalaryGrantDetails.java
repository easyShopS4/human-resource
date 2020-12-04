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
public class SalaryGrantDetails implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "grd_id", type = IdType.AUTO)
    private Integer grdId;

    private String salaryGrantId;

    private String humanId;

    private String humanName;

    private Double bounsSum;

    private Double saleSum;

    private Double deductSum;

    private Double salaryStandardSum;

    private Double salaryPaidSum;


}
