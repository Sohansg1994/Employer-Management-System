package com.project.employeesystem.service;

import com.project.employeesystem.dto.EmployeeDTO;
import com.project.employeesystem.entity.Employee;
import com.project.employeesystem.repo.EmployeeRepo;
import com.project.employeesystem.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveEmployee(EmployeeDTO employeeDTO){
       if (employeeRepo.existsEmployeeByEmpNIC(employeeDTO.getEmpNIC())){
           return VarList.RSP_DUPLICATED;
       }else {
           employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
           return VarList.RSP_SUCCESS;
       }

    }

    public String updateEmployee(EmployeeDTO employeeDTO){
        if (employeeRepo.existsEmployeeByEmpNIC(employeeDTO.getEmpNIC())){
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }

    }

    public EmployeeDTO findEmployee(String empNIC){
        if (employeeRepo.existsEmployeeByEmpNIC(empNIC)) {
            Employee employee = employeeRepo.findEmployeeByEmpNIC(empNIC);
            return modelMapper.map(employee,EmployeeDTO.class);
        }else {
            return null;
        }


    }

    public String deleteEmployee(String empNIC){
        if (employeeRepo.existsEmployeeByEmpNIC(empNIC)){
            employeeRepo.deleteEmployeeByEmpNIC(empNIC);
            System.out.println("true");
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }






}
