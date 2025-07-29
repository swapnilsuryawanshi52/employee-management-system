package com.microservices.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDTO {
    private EmployeeDTO employeeDTO;
    private DepartmentDTO departmentDTO;
    private OrganizationDTO organizationDTO;
}
