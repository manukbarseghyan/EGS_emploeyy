package com.egs.egs_employee.service;

import com.egs.egs_employee.dto.EmployeeDTO;
import com.egs.egs_employee.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    EmployeeEntity createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> findAllEmployee();

    EmployeeDTO getById(Long id);

    String deleteEmployeeById(Long id);


    EmployeeDTO loginEmployee(String username,String pass);
}
