package com.microservices.employeeservice.mapper;

import com.microservices.employeeservice.dto.EmployeeDTO;
import com.microservices.employeeservice.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO(
                employee.getEmployeeId(),
                employee.getEmployeeName(),
                employee.getEmployeeEmail(),
                employee.getEmployeePhoneNumber(),
                employee.getDepartmentCode()
        );
        return employeeDTO;
    }

    public static Employee mapToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getEmployeeId(),
                employeeDTO.getEmployeeName(),
                employeeDTO.getEmployeeEmail(),
                employeeDTO.getEmployeePhoneNumber(),
                employeeDTO.getDepartmentCode()
        );
        return employee;
    }
}
