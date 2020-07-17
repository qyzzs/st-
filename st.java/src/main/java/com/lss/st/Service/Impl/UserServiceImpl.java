package com.lss.st.Service.Impl;

import com.lss.st.Service.UserService;
import com.lss.st.dao.UserDao;
import com.lss.st.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.selectList(null);
    }

    @Override
    public User findById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public int Update(User user) {
        return userDao.insert(user);
    }

    @Override
    public int Delete(Integer id) {
        return userDao.deleteById(id);
    }

    @Override
    public User selectOne(User user) {
        return userDao.selectOne(user);
    }
}
