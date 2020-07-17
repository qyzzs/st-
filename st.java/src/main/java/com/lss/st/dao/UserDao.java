package com.lss.st.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lss.st.model.User;

public interface UserDao extends BaseMapper<User> {
    User selectOne(User user);
}
