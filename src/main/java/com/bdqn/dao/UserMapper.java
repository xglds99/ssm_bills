package com.bdqn.dao;

import com.bdqn.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    /**
     * 根据登录名称查询用户信息
     * @param loginName
     * @return
     */
    @Select("select * from user where loginName = #{loginName}")
    User findUserByLoginName(String loginName);

}
