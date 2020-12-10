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
public class EngageResume implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "res_id", type = IdType.AUTO)
    private Integer resId;

    private String humanName;

    private String engageType;

    private String humanAddress;

    private String humanPostcode;

    private String humanMajorKindId;

    private String humanMajorKindName;

    private Integer humanMajorId;

    private String humanMajorName;

    private String humanTelephone;

    private String humanHomephone;

    private String humanMobilephone;

    private String humanEmail;

    private String humanHobby;

    private String humanSpecility;

    private Integer humanSex;

    private String humanReligion;

    private String humanParty;

    private String humanNationality;

    private String humanRace;

    private Date humanBirthday;

    private Integer humanAge;

    private String humanEducatedDegree;

    private Integer humanEducatedYears;

    private String humanEducatedMajor;

    private String humanCollege;

    private String humanIdcard;

    private String humanBirthplace;

    private Double demandSalaryStandard;

    private String humanHistoryRecords;

    private String remark;

    private String recomandation;

    private String humanPicture;

    private String attachmentName;

    private Integer checkStatus;

    private String register;

    private Date registTime;

    private String checker;

    private Date checkTime;

    private Integer interviewStatus;

    private Double totalPoints;

    private Integer testAmount;

    private String testChecker;

    private Date testCheckTime;

    private String passRegister;

    private Date passRegistTime;

    private String passChecker;

    private Date passCheckTime;

    private Integer passCheckStatus;

    @TableField("pass_checkComment")
    private String passCheckcomment;

    @TableField("pass_passComment")
    private String passPasscomment;

    /**
     * 开始的注册时间
     */
    private Date startDate;

    /**
     * 结束的注册时间
     */
    private Date endDate;

}
