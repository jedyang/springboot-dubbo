package com.yunsheng.service;

import com.github.pagehelper.PageInfo;
import com.yunsheng.model.User;

/**
 * @author yunsheng
 */
public interface UserService {

    int addUser(User user);

    int addUserRollBack(User user);

    PageInfo<User> findAllUser(int pageNum, int pageSize);
}
