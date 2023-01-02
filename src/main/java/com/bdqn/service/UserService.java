package com.bdqn.service;

import com.bdqn.entity.User;

public interface UserService {

    /**
     * 登录
     * @param loginName
     * @param password
     * @return
     */
    User login(String loginName,String password);

}
