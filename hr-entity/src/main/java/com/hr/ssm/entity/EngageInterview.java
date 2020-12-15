package com.hr.ssm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date registerTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date checkTime;

    private Integer resumeId;

    private String result; // 面试结果  通过, 不通过

    private String interviewComment; // 面试评价~

    private String checkComment;

    private Integer interviewStatus; // 1. 已经面试

    private Integer checkStatus; // 0, 未被筛选  1, 筛选通过 建议录用 2. 建议面试 3. 建议笔试 5. 删除面试


}
