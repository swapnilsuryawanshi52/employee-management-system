package com.microservices.departmentservice.controller;

import com.microservices.departmentservice.dto.DepartmentDTO;
import com.microservices.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // Create a department
    @PostMapping("/department")
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO savedDepartmentDTO = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartmentDTO, HttpStatus.CREATED);
    }

    // Get department by code
    @GetMapping("/department/{departmentCode}")
    public ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable String departmentCode) {
        DepartmentDTO departmentDTO = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }
}
