package com.employe.backend.springbootcrud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeBean {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
