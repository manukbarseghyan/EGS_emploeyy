package com.egs.egs_employee.service;

import com.egs.egs_employee.dao.EmployeeDAO;
import com.egs.egs_employee.dto.EmployeeDTO;
import com.egs.egs_employee.entity.EmployeeEntity;
import com.egs.egs_employee.mapper.MappingEmployee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    public EmployeeEntity createEmployee(EmployeeDTO employeeDTO) {

        EmployeeEntity employee = MappingEmployee.convertToEntity(employeeDTO);

        return employeeDAO.save(employee);
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public List<EmployeeDTO> findAllEmployee() {
        return null;
    }

    @Override
    public EmployeeDTO getById(Long id) {
        return null;
    }

    @Override
    public String deleteEmployeeById(Long id) {
        return null;
    }

    @Override
    public EmployeeDTO loginEmployee(String username, String pass) {

        EmployeeEntity employee = employeeDAO.getByUsername(username);
        EmployeeDTO employeeDTO = MappingEmployee.convertToDto(employee);
        if (employeeDTO.getPassword().equals(pass)) {
           return employeeDTO;
        }
       else return null;
    }
}
