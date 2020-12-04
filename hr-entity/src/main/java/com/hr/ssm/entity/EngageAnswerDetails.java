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
public class EngageAnswerDetails implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "and_id", type = IdType.AUTO)
    private Integer andId;

    private String answerNumber;

    private Integer subjectId;

    private String answer;


}
