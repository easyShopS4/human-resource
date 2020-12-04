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
public class EngageSubjects implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "sub_id", type = IdType.AUTO)
    private Integer subId;

    private Integer firstKindId;

    private String firstKindName;

    private Integer secondKindId;

    private String secondKindName;

    private String register;

    private Date registTime;

    private String derivation;

    private String content;

    private String keyA;

    private String keyB;

    private String keyC;

    private String keyD;

    private String keyE;

    private String correctKey;

    private String changer;

    private Date changeTime;


}
