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
public class Training implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "tra_id", type = IdType.AUTO)
    private Integer traId;

    private Integer majorKindId;

    private String majorKindName;

    private Integer majorId;

    private String majorName;

    private String humanId;

    private String humanName;

    private String trainingItem;

    private Date trainingTime;

    private Integer trainingHour;

    private String trainingDegree;

    private String register;

    private String checker;

    private Date registTime;

    private Date checkTime;

    private Integer checkstatus;

    private String remark;


}
