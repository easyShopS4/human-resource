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
public class SalaryStandard implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ssd_id", type = IdType.AUTO)
    private Integer ssdId;

    private String standardId;

    private String standardName;

    private String designer;

    private String register;

    private String checker;

    private String changer;

    private Date registerTime;

    private Date checkTime;

    private Date changeTime;

    private Double salarySum;

    private Integer checkStatus;

    private Integer changeStatus;

    private String checkComment;

    private String remark;


}
