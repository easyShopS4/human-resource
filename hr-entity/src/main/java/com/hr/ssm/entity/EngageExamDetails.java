package com.hr.ssm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class EngageExamDetails implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "exd_id", type = IdType.AUTO)
    private Integer exdId;

    private String examNumber;

    private Integer firstKindId;

    private String firstKindName;

    private Integer secondKindId;

    private String secondKindName;

    private Integer questionAmount;


}
