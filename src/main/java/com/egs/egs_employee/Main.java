package com.egs.egs_employee;

import com.egs.egs_employee.dao.EmployeeDAO;
import com.egs.egs_employee.dto.EmployeeDTO;
import com.egs.egs_employee.entity.EmployeeEntity;
import com.egs.egs_employee.mapper.MappingEmployee;
import com.egs.egs_employee.service.EmployeeService;
import com.egs.egs_employee.service.EmployeeServiceImpl;

public class Main {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO();

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName("manuk");
        employeeEntity.setLastName("barseghyan");
        employeeEntity.setUsername("lnksb");
        employeeEntity.setPassword("lnksb");
        employeeEntity.setSalary(200000);

        EmployeeDTO employeeDTO = MappingEmployee.convertToDto(employeeEntity);
        EmployeeEntity employeeEntity1 = MappingEmployee.convertToEntity(employeeDTO);
        System.out.println(employeeDTO);
        System.out.println(employeeEntity1);
        employeeDAO.save(employeeEntity1);

        EmployeeService employeeService = new EmployeeServiceImpl();
        System.out.println(employeeService.loginEmployee("lnksb", "lnksb"));

    }

}
