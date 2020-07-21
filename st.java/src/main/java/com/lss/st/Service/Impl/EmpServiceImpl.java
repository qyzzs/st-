package com.lss.st.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @Override
    public IPage<Employee> FindAllByPage(Integer pageIndex, Integer pageSize,Employee employee) {
//        QueryWrapper<Employee> queryWrapper=new QueryWrapper<>();
//        if(!employee.getName().isEmpty()){
//            queryWrapper.eq("name",employee.getName());
//        }
//        if (!employee.getPhone().isEmpty()){
//            queryWrapper.eq("phone",employee.getPhone());
//        }

        IPage<Employee> page = new Page<>(pageIndex,pageSize);
        return empsDao.selectPage(page,null);
    }
}
