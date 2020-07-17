package com.lss.st.Service;

import com.lss.st.model.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findById(Integer id);
    public int Add(User user);
    public int Delete(Integer id);
    public User selectOne(User user);
}
