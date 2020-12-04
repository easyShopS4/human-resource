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
public class EngageAnswer implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ans_id", type = IdType.AUTO)
    private Integer ansId;

    private String answerNumber;

    private String examNumber;

    private Integer resumeId;

    private Integer interviewId;

    private String humanName;

    private String humanIdcard;

    private Integer majorKindId;

    private Integer majorKindName;

    private Integer majorId;

    private Integer majorName;

    private Date testTime;

    private String useTime;

    private Double totalPoint;


}
