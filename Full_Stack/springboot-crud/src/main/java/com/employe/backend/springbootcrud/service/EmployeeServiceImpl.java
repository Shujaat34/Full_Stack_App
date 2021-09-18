package com.employe.backend.springbootcrud.service;

import com.employe.backend.springbootcrud.bean.EmployeeBean;
import com.employe.backend.springbootcrud.exception.GenericException;
import com.employe.backend.springbootcrud.model.Employee;
import com.employe.backend.springbootcrud.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public EmployeeBean addEmployee(EmployeeBean employeeBean) {
        Employee emp = employeeRepository.save(mapper.map(employeeBean, Employee.class));
        return mapper.map(emp, EmployeeBean.class);
    }


    @Override
    public EmployeeBean updateEmployee(EmployeeBean employeeBean) {
        Employee emp = employeeRepository.findById(employeeBean.getId())
                .orElseThrow(() -> new GenericException("Employee Not Found"));
        emp.setFirstName(employeeBean.getFirstName());
        emp.setLastName(employeeBean.getLastName());
        emp.setEmailId(employeeBean.getEmailId());
        emp = employeeRepository.save(emp);
        return mapper.map(emp, EmployeeBean.class);
    }

    @Override
    public EmployeeBean getEmployeeById(Long id) {
        Employee emp = employeeRepository.findById(id).orElseThrow(
                () -> new GenericException("Employee Not Found With Id " + id));
        return mapper.map(emp, EmployeeBean.class);
    }

    @Override
    public List<EmployeeBean> getAllEmployees() {
        return employeeRepository.findAll().stream().map(emp -> mapper.map(emp, EmployeeBean.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEmployee(Long id) {
        try {
            employeeRepository.deleteById(id);
        } catch (Exception e) {
            throw new GenericException("Employee Not Found With Id " + id + " " + e.getMessage());
        }

    }
}
