package com.employe.backend.springbootcrud.repository;

import com.employe.backend.springbootcrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
