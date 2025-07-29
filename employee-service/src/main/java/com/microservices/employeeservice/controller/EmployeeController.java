package com.microservices.employeeservice.controller;

import com.microservices.employeeservice.dto.APIResponseDTO;
import com.microservices.employeeservice.dto.EmployeeDTO;
import com.microservices.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Save an employee
    @PostMapping("/employee")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployeeDTO = employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployeeDTO, HttpStatus.CREATED);
    }

    // Get employee by ID
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<APIResponseDTO> getEmployeeById(@PathVariable Long employeeId) {
        APIResponseDTO apiResponseDTO = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDTO, HttpStatus.OK);
    }
}
