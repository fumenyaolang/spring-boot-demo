package com.fmyl.demo.service;

import com.fmyl.demo.handers.ServiceResultHander;
import com.fmyl.demo.model.User;

/**
 * user service
 * Created by fuzq on 17/7/6.
 */
public interface UserService extends BaseService {

    ServiceResultHander getPage(int pn, String name);

    ServiceResultHander insert(User user);

    ServiceResultHander update(Integer id, String name, Integer age);

    ServiceResultHander delete(Integer id);
}
