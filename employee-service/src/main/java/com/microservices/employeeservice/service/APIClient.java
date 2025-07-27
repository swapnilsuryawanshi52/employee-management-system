package com.microservices.employeeservice.service;

import com.microservices.employeeservice.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    // Get department by code
    @GetMapping("/api/v1/department/{departmentCode}")
    DepartmentDTO getDepartmentByCode(@PathVariable String departmentCode);
}
