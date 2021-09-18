package com.employe.backend.springbootcrud.controller;

import com.employe.backend.springbootcrud.bean.EmployeeBean;
import com.employe.backend.springbootcrud.service.EmployeeServiceImpl;
import com.employe.backend.springbootcrud.uri.Uri;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Uri.API)
@Api(tags = "Employee Api")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @ApiOperation(value = "Save Employee", response = ResponseEntity.class)
    @PostMapping(value = Uri.EMPLOYEES, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeBean> saveEmployee(@RequestBody EmployeeBean employeeBean) {
        return new ResponseEntity<>(employeeService.addEmployee(employeeBean), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update Employee", response = ResponseEntity.class)
    @PutMapping(value = Uri.EMPLOYEES, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeBean> updateEmployee(@RequestBody EmployeeBean employeeBean) {
        return new ResponseEntity<>(employeeService.updateEmployee(employeeBean), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete Employee")
    @DeleteMapping(value = Uri.EMPLOYEES + "/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Get all Employees")
    @GetMapping(value = Uri.EMPLOYEES, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeBean>> getEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @ApiOperation(value = "Get Employee By Id")
    @GetMapping(value = Uri.EMPLOYEES + "/{id}")
    public ResponseEntity<EmployeeBean> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

}
