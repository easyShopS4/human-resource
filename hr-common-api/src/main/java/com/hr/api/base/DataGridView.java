package com.hr.api.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * lay_ui 分页需要下面的数据类型~
 * 分页收集数据用~
 * @author echo lovely
 * @date 2020/12/5 09:41
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataGridView {

    /**
     * 消息 一般给null
     */
    private String msg;
    /**
     * 响应码 默认给200
     */
    private Integer code = 0;
    /**
     * 当前页数共有多少条数据~
     */
    private Long count;

    /**
     * 数据集合
     */
    private Object data;

}
