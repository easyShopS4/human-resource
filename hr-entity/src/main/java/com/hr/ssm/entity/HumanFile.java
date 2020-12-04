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
public class HumanFile implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "huf_id", type = IdType.AUTO)
    private Integer hufId;

    private String humanId;

    private String firstKindId;

    private String firstKindName;

    private Integer secondKindId;

    private String secondKindName;

    private Integer thirdKindId;

    private String thirdKindName;

    private String humanName;

    private String humanAddress;

    private String humanPostcode;

    private String humanProDesignation;

    private Integer humanMajorKindId;

    private String humanMajorKindName;

    private Integer humanMajorId;

    private String hunmanMajorName;

    private String humanTelephone;

    private String humanMobilePhone;

    private String humanBank;

    private String humanAccount;

    private String humanQq;

    private String humanEmail;

    private String humanHobby;

    private String humanSpeciality;

    private Integer humanSex;

    private String humanReligion;

    private String humanParty;

    private String humanNationality;

    private String humanRace;

    private Date humanBirthday;

    private String humanBirthplace;

    private Integer humanAge;

    private String humanEducatedDegree;

    private Integer humanEducatedYears;

    private String humanEducatedMajor;

    private String humanSocietySecurityId;

    private String humanIdCard;

    private String remark;

    private String salaryStandardId;

    private String salaryStandardName;

    private Double salarySum;

    private String demandSalarySum;

    private Double paidSalarySum;

    private Integer majorChangeAmount;

    private Integer bonusAmount;

    private Integer trainingAmount;

    private Integer fileChangAmount;

    private String humanHistoryRecords;

    private String humanFamilyMembership;

    private String humanPicture;

    private String attachmentName;

    private Integer checkStatus;

    private String register;

    private String checker;

    private String changer;

    private Date registerTime;

    private Date checkTime;

    private Date changeTime;

    private Date lastlyChangeTime;

    private Date deleteTime;

    private Date recoveryTime;

    private Integer humanFileStatus;


}
