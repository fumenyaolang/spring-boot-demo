package com.fmyl.demo.service.impl;

import com.fmyl.demo.service.BaseService;
import com.fmyl.demo.utils.LoggerUtils;

/**
 * Created by fuzq on 17/7/6.
 */
public abstract class BaseServiceImpl implements BaseService {
    LoggerUtils logger = LoggerUtils.getInstance(this.getClass());
}
