package com.project.employeesystem.dto;

import com.project.employeesystem.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private int empId;
    private String empNIC;
    private String empName;
    private String empAddress;
    private String empMNumber;



}
