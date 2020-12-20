package com.hr.ssm.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.beans.Transient;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
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
/* "salary_grant" : 薪酬发放登记表                                                                   */
/* 	"sgr_id" : 主键，自动增长列                                                                       */
/* 	"salary_grant_id" : 薪酬发放编号主键id                                                                */
/* 	"salary_standard_id" : 薪酬标准单编号                                                            */
/* 	"first_kind_id" : 一级机构编号                                                                  */
/* 	"first_kind_name" : 一级机构名称                                                                */
/* 	"second_kind_id" : 二级机构编号                                                                 */
/* 	"second_kind_name" : 二级机构名称                                                               */
/* 	"third_kind_id" : 三级机构编号                                                                  */
/* 	"third_kind_name" : 三级机构名称                                                                */
/* 	"human_amount" : 总人数                                                                      */
/* 	"salary_standard_sum" : 标准薪酬总金额                                                           */
/* 	"salary_paid_sum" : 实发总金额                                                                 */
/* 	"register" : 登记人                                                                          */
/* 	"regist_time" : 登记时间                                                                 */
/* 	"checker" : 复核人                                                                           */
/* 	"check_time" : 复核时间                                                                      */
/* 	"check_status" : 复核状态
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

    // "salary_grant_details" : 薪酬发放详细信息
/* 	"bouns_sum" : 奖励金额
    "sale_sum" : 销售绩效金额                                                                       */
/* 	"deduct_sum" : 应扣金额
*                                                                      */
    @TableField(exist = false)
    private Double bounsSum;
    @TableField(exist = false)
    private Double saleSum;
    @TableField(exist = false)
    private Double deductSum;
    // "salary_standard" : 标准酬薪
    @TableField(exist = false)
    private Double  mission ;
    @TableField(exist = false)
    private Double  travel;
    @TableField(exist = false)
    private Double  housing;
    @TableField(exist = false)
    private Double  base;
    @TableField(exist = false)
    private Double year;
    @TableField(exist = false)
    private Double  missed ;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getSgrId() {
        return sgrId;
    }

    public void setSgrId(Integer sgrId) {
        this.sgrId = sgrId;
    }

    public String getSalaryGrantId() {
        return salaryGrantId;
    }

    public void setSalaryGrantId(String salaryGrantId) {
        this.salaryGrantId = salaryGrantId;
    }

    public String getSalaryStandardId() {
        return salaryStandardId;
    }

    public void setSalaryStandardId(String salaryStandardId) {
        this.salaryStandardId = salaryStandardId;
    }

    public Integer getFirstKindId() {
        return firstKindId;
    }

    public void setFirstKindId(Integer firstKindId) {
        this.firstKindId = firstKindId;
    }

    public String getFirstKindName() {
        return firstKindName;
    }

    public void setFirstKindName(String firstKindName) {
        this.firstKindName = firstKindName;
    }

    public Integer getSecondKindId() {
        return secondKindId;
    }

    public void setSecondKindId(Integer secondKindId) {
        this.secondKindId = secondKindId;
    }

    public String getSecondKindName() {
        return secondKindName;
    }

    public void setSecondKindName(String secondKindName) {
        this.secondKindName = secondKindName;
    }

    public Integer getThirdKindId() {
        return thirdKindId;
    }

    public void setThirdKindId(Integer thirdKindId) {
        this.thirdKindId = thirdKindId;
    }

    public String getThirdKindName() {
        return thirdKindName;
    }

    public void setThirdKindName(String thirdKindName) {
        this.thirdKindName = thirdKindName;
    }

    public Integer getHumanAmount() {
        return humanAmount;
    }

    public void setHumanAmount(Integer humanAmount) {
        this.humanAmount = humanAmount;
    }

    public Double getSalaryStandardSum() {
        return salaryStandardSum;
    }

    public void setSalaryStandardSum(Double salaryStandardSum) {
        this.salaryStandardSum = salaryStandardSum;
    }

    public Double getSalaryPaidSum() {
        return salaryPaidSum;
    }

    public void setSalaryPaidSum(Double salaryPaidSum) {
        this.salaryPaidSum = salaryPaidSum;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Double getBounsSum() {
        return bounsSum;
    }

    public void setBounsSum(Double bounsSum) {
        this.bounsSum = bounsSum;
    }

    public Double getSaleSum() {
        return saleSum;
    }

    public void setSaleSum(Double saleSum) {
        this.saleSum = saleSum;
    }

    public Double getDeductSum() {
        return deductSum;
    }

    public void setDeductSum(Double deductSum) {
        this.deductSum = deductSum;
    }

    public Double getMission() {
        return mission;
    }

    public void setMission(Double mission) {
        this.mission = mission;
    }

    public Double getTravel() {
        return travel;
    }

    public void setTravel(Double travel) {
        this.travel = travel;
    }

    public Double getHousing() {
        return housing;
    }

    public void setHousing(Double housing) {
        this.housing = housing;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getYear() {
        return year;
    }

    public void setYear(Double year) {
        this.year = year;
    }

    public Double getMissed() {
        return missed;
    }

    public void setMissed(Double missed) {
        this.missed = missed;
    }

    @Override
    public String toString() {
        return "SalaryGrant{" +
                "sgrId=" + sgrId +
                ", salaryGrantId='" + salaryGrantId + '\'' +
                ", salaryStandardId='" + salaryStandardId + '\'' +
                ", firstKindId=" + firstKindId +
                ", firstKindName='" + firstKindName + '\'' +
                ", secondKindId=" + secondKindId +
                ", secondKindName='" + secondKindName + '\'' +
                ", thirdKindId=" + thirdKindId +
                ", thirdKindName='" + thirdKindName + '\'' +
                ", humanAmount=" + humanAmount +
                ", salaryStandardSum=" + salaryStandardSum +
                ", salaryPaidSum=" + salaryPaidSum +
                ", register='" + register + '\'' +
                ", registTime=" + registTime +
                ", checker='" + checker + '\'' +
                ", checkTime=" + checkTime +
                ", checkStatus=" + checkStatus +
                ", bounsSum=" + bounsSum +
                ", saleSum=" + saleSum +
                ", deductSum=" + deductSum +
                ", mission=" + mission +
                ", travel=" + travel +
                ", housing=" + housing +
                ", base=" + base +
                ", year=" + year +
                ", missed=" + missed +
                '}';
    }
}
