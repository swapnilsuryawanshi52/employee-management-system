package com.microservices.employeeservice.service;

import com.microservices.employeeservice.dto.APIResponseDTO;
import com.microservices.employeeservice.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    //List<EmployeeDTO> getAllEmployees();

    APIResponseDTO getEmployeeById(Long employeeId);
}
