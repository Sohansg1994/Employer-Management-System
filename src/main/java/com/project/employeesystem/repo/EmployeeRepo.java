package com.project.employeesystem.repo;

import com.project.employeesystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    boolean existsEmployeeByEmpNIC(String empNIC);

    Employee findEmployeeByEmpNIC(String empNIC);

    void deleteEmployeeByEmpNIC(String empNIC);

}
