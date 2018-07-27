package com.yunsheng.service;

import com.github.pagehelper.PageInfo;
import com.yunsheng.model.User;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface UserService {

    int addUser(User user);

    PageInfo<User> findAllUser(int pageNum, int pageSize);
}
