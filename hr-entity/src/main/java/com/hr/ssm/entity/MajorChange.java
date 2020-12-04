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
public class MajorChange implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "mch_id", type = IdType.AUTO)
    private Integer mchId;

    private Integer firstKindId;

    private String firstKindName;

    private Integer secondKindId;

    private String secondKindName;

    private Integer thirdKindId;

    private String thirdKindName;

    private Integer majorKindId;

    private String majorKindName;

    private Integer majorId;

    private String majorName;

    private Integer newFirstKindId;

    private String newFirstKindName;

    private Integer newSecondKindId;

    private String newSecondKindName;

    private Integer newThirdKindId;

    private String newThirdKindName;

    private Integer newMajorKindId;

    private String newMajorKindName;

    private Integer newMajorId;

    private String newMajorName;

    private String humanId;

    private String humanName;

    private String salaryStandardId;

    private String salaryStandardName;

    private Double salarySum;

    private String newSalaryStandardId;

    private String newSalaryStandardName;

    private Double newSalarySum;

    private String changeReason;

    private String checkReason;

    private Integer checkStatus;

    private String register;

    private String checker;

    private Date registTime;

    private Date checkTime;


}
