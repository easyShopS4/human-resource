package com.hr.ssm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
//@Data
//@EqualsAndHashCode(callSuper = false)
public class SalaryStandard implements Serializable {

    private static final long serialVersionUID=1L;

    /* 	"ssd_id" : 主键，自动增长列                                                                       */
    /* 	"standard_id" : 薪酬标准单编号                                                                   */
    /* 	"standard_name" : 薪酬标准单名称                                                                 */
    /* 	"designer" : 制定者名字                                                                        */
    /* 	"register" : 登记人                                                                          */
    /* 	"checker" : 复核人                                                                           */
    /* 	"changer" : 变更人                                                                           */
    /* 	"register_time" : 登记时间                                                                      */
    /* 	"check_time" : 复核时间                                                                       */
    /* 	"change_time" : 变更时间                                                                      */
    /* 	"salary_sum" : 薪酬总额                                                                       */
    /* 	"check_status" : 是否经过复核                                                                   */
    /* 	"change_status" : 更改状态                                                                    */
    /* 	"check_comment" : 复核意见                                                                   */
        /* 	"remark" : 备注
select * from   salary_standard                                                          */

    // standardId=1353752304959&standardName=&
    // salarySum=0.0&designer=&register=batter&registerTime=&remark=&title=
    @TableId(value = "ssd_id", type = IdType.AUTO)
    private Integer ssdId;

    private String standardId;

    private String standardName;

    private String designer;

    private String register;

    private String checker;

    private String changer;
    //日期格式
    //前台-->>后台
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //后台-->>前台
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date registerTime;

    private Date checkTime;

    private Date changeTime;

    private Double salarySum;

    private Integer checkStatus;

    private Integer changeStatus;

    private String checkComment;

    private String remark;

   //项目需要
    private Double  mission ;//出差补贴

    private Double travel  ; //交通补贴

    private Double housing ;//住房补贴

    private Double base ; //基本工资

    private Double year ;//年终奖

    private Double  missed ; //误餐补助

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getSsdId() {
        return ssdId;
    }

    public void setSsdId(Integer ssdId) {
        this.ssdId = ssdId;
    }

    public String getStandardId() {
        return standardId;
    }

    public void setStandardId(String standardId) {
        this.standardId = standardId;
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getChanger() {
        return changer;
    }

    public void setChanger(String changer) {
        this.changer = changer;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public Double getSalarySum() {
        return salarySum;
    }

    public void setSalarySum(Double salarySum) {
        this.salarySum = salarySum;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Integer getChangeStatus() {
        return changeStatus;
    }

    public void setChangeStatus(Integer changeStatus) {
        this.changeStatus = changeStatus;
    }

    public String getCheckComment() {
        return checkComment;
    }

    public void setCheckComment(String checkComment) {
        this.checkComment = checkComment;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

  /*  @Override
    public String toString() {
        return "SalaryStandard{" +
                "ssdId=" + ssdId +
                ", standardId='" + standardId + '\'' +
                ", standardName='" + standardName + '\'' +
                ", designer='" + designer + '\'' +
                ", register='" + register + '\'' +
                ", checker='" + checker + '\'' +
                ", changer='" + changer + '\'' +
                ", registerTime=" + registerTime +
                ", checkTime=" + checkTime +
                ", changeTime=" + changeTime +
                ", salarySum=" + salarySum +
                ", checkStatus=" + checkStatus +
                ", changeStatus=" + changeStatus +
                ", checkComment='" + checkComment + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }*/

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
        return "SalaryStandard{" +
                "ssdId=" + ssdId +
                ", standardId='" + standardId + '\'' +
                ", standardName='" + standardName + '\'' +
                ", designer='" + designer + '\'' +
                ", register='" + register + '\'' +
                ", checker='" + checker + '\'' +
                ", changer='" + changer + '\'' +
                ", registerTime=" + registerTime +
                ", checkTime=" + checkTime +
                ", changeTime=" + changeTime +
                ", salarySum=" + salarySum +
                ", checkStatus=" + checkStatus +
                ", changeStatus=" + changeStatus +
                ", checkComment='" + checkComment + '\'' +
                ", remark='" + remark + '\'' +
                ", mission=" + mission +
                ", travel=" + travel +
                ", housing=" + housing +
                ", base=" + base +
                ", year=" + year +
                ", missed=" + missed +
                '}';
    }
}
