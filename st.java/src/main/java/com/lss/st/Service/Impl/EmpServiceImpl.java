package com.lss.st.Service.Impl;

import com.lss.st.Service.EmpService;
import com.lss.st.dao.EmpsDao;
import com.lss.st.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpsDao empsDao;
    @Override
    public List<Employee> findAll() {
        return empsDao.selectList(null);
    }

    @Override
    public Employee findById(Integer id) {
        return empsDao.selectById(id);
    }

    @Override
    public int Add(Employee employee) {
        return empsDao.insert(employee);
    }

    @Override
    public int Delete(Integer id) {
        return empsDao.deleteById(id);
    }
}
