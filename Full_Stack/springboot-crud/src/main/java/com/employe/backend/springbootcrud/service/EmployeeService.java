package com.employe.backend.springbootcrud.service;

import com.employe.backend.springbootcrud.bean.EmployeeBean;
import com.employe.backend.springbootcrud.model.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeBean addEmployee(EmployeeBean employeeBean);
    EmployeeBean updateEmployee(EmployeeBean employeeBean);
    EmployeeBean getEmployeeById(Long id);
    List<EmployeeBean> getAllEmployees();
    void deleteEmployee(Long id);
}
