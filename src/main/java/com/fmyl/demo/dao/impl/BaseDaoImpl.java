package com.fmyl.demo.dao.impl;

import com.fmyl.demo.service.BaseService;
import com.fmyl.demo.utils.LoggerUtils;

/**
 * base dao impl
 * Created by fuzq on 17/7/12.
 */
public abstract class BaseDaoImpl implements BaseService {
    LoggerUtils logger = LoggerUtils.getInstance(this.getClass());
}
