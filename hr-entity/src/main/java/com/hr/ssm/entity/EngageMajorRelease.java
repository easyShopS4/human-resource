package com.hr.ssm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class EngageMajorRelease implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "mre_id", type = IdType.AUTO)
    private Integer mreId;

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

    private Integer humanAmount;

    private String engageType;

    // 响应到页面的格式 应该多8小时
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deadline;

    private String register;

    private String changer;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date registerTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date changeTime;

    private String majorDescribe;

    private String engageRequired;


}
