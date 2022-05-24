package com.egs.egs_employee.mapper;

import com.egs.egs_employee.dto.EmployeeDTO;
import com.egs.egs_employee.entity.EmployeeEntity;

import java.util.Base64;

public class MappingEmployee {


    public static EmployeeDTO convertToDto(EmployeeEntity employee) {

        if (employee == null) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setUsername(employee.getUsername());
        employeeDTO.setPassword(Base64.getEncoder().encodeToString(employee.getPassword().getBytes()));

        return employeeDTO;
    }

    public static EmployeeEntity convertToEntity(EmployeeDTO employeeDTO) {

        if (employeeDTO == null) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setId(employeeDTO.getId());
        employeeEntity.setFirstName(employeeDTO.getFirstName());
        employeeEntity.setLastName(employeeDTO.getLastName());
        employeeEntity.setSalary(employeeDTO.getSalary());
        employeeEntity.setUsername(employeeDTO.getUsername());
        byte[] decodedBytes = Base64.getDecoder().decode(employeeDTO.getPassword());
        String decodedString = new String(decodedBytes);
        employeeEntity.setPassword(decodedString);

        return employeeEntity;

    }
}
