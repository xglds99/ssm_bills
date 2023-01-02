package com.bdqn.service.impl;

import com.bdqn.dao.UserMapper;
import com.bdqn.entity.User;
import com.bdqn.service.UserService;
import com.bdqn.utils.PasswordUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 登录
     *
     * @param loginName
     * @param password
     * @return
     */
    public User login(String loginName, String password) {
        //调用根据用户名查询用户信息的方法
        User user = userMapper.findUserByLoginName(loginName);
        if(user!=null){
            //加密
            String newPassword = PasswordUtil.md5(password, user.getLoginName(), 5);
            //比较密码是否一致
            if(user.getPwd().equals(newPassword)){
                return user;
            }
        }
        return null;
    }
}
