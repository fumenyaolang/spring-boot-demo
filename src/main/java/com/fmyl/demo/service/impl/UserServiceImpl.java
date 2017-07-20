package com.fmyl.demo.service.impl;


import com.fmyl.demo.handers.ServiceResultHander;
import com.fmyl.demo.model.Page;
import com.fmyl.demo.model.User;
import com.fmyl.demo.service.UserService;
import com.fmyl.demo.utils.LoggerUtils;
import org.springframework.stereotype.Service;

/**
 * Created by fuzq on 17/7/6.
 */
@Service
public class UserServiceImpl  extends BaseServiceImpl implements UserService {

    @Override
    public ServiceResultHander<Page<User>> getPage(int pn, String name) {

        return new ServiceResultHander(ServiceResultHander.RESULT_SUCCESS,1,null,1);
    }

    @Override
    public ServiceResultHander insert(User user) {
        return null;
    }

    @Override
    public ServiceResultHander update(Integer id, String name, Integer age) {
        return null;
    }

    @Override
    public ServiceResultHander delete(Integer id) {
        return null;
    }

    public void getLogger() {
        LoggerUtils.getInstance(this.getClass());
    }
}
