package com.hr.ssm.service;

import com.hr.ssm.entity.ConfigFileFirstKind;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
public interface ConfigFileFirstKindService extends IService<ConfigFileFirstKind> {

    List<ConfigFileFirstKind> getAllFistKind();

    List<ConfigFileFirstKind> getAllFistKindById(Integer firstKindId);

}
