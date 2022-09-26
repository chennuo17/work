package com.cn.dao;

import com.cn.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface EmployeeDao {
    //员工列表
    List<Employee> lists();

    //保存员工信息
    void save(Employee employee);

    //根据ID查询一个
    Employee findById(Integer id);

    //更新员工信息
    void update(Employee employee);

    //删除员工信息
    void delete(Integer id);
}
