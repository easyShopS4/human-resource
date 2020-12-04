package com.hr.ssm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
public class SalaryGrant implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "sgr_id", type = IdType.AUTO)
    private Integer sgrId;

    private String salaryGrantId;

    private String salaryStandardId;

    private Integer firstKindId;

    private String firstKindName;

    private Integer secondKindId;

    private String secondKindName;

    private Integer thirdKindId;

    private String thirdKindName;

    private Integer humanAmount;

    private Double salaryStandardSum;

    private Double salaryPaidSum;

    private String register;

    private Date registTime;

    private String checker;

    private Date checkTime;

    private Integer checkStatus;


}
