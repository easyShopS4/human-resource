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
public class EngageExam implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "exa_id", type = IdType.AUTO)
    private Integer exaId;

    private String examNumber;

    private Integer majorKindId;

    private String majorKindName;

    private Integer majorId;

    private String majorName;

    private String register;

    private Date registerTime;

    private Integer limitTime;


}
