package com.lss.st.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lss.st.model.Employee;

import java.util.List;

public interface EmpService {
    public List<Employee> findAll();
    public Employee findById(Integer id);
    public int Add(Employee employee);
    public int Delete(Integer id);
    public IPage<Employee> FindAllByPage(Integer pageIndex,Integer pageSize,Employee employee);
}
