package com.hr.ssm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class EngageInterview implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ein_id", type = IdType.AUTO)
    private Integer einId;

    private String humanName;

    private Integer interviewAmount;

    private Integer humanMajorKindId;

    private String humanMajorKindName;

    private Integer humanMajorId;

    private String humanMajorName;

    private String imageDegree;

    private String nativeLanguageDegree;

    private String foreignLanguageDegree;

    private String responseSpeedDegree;

    @TableField("EQ_degree")
    private String eqDegree;

    @TableField("IQ_degree")
    private String iqDegree;

    private String multiQualityDegree;

    private String register;

    private String checker;

    private Date registerTime;

    private Date checkTime;

    private Integer resumeId;

    private String result;

    private String interviewComment; // 面试评价~

    private String checkComment;

    private Integer interviewStatus; // 1. 已经面试

    private Integer checkStatus;


}
