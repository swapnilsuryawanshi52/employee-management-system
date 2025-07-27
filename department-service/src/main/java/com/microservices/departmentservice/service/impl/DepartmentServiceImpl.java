package com.microservices.departmentservice.service.impl;

import com.microservices.departmentservice.dto.DepartmentDTO;
import com.microservices.departmentservice.entity.Department;
import com.microservices.departmentservice.mapper.DepartmentMapper;
import com.microservices.departmentservice.repository.DepartmentRepository;
import com.microservices.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

        // Convert DepartmentDTO to Department JPA Entity
        Department department = DepartmentMapper.mapToDepartment(departmentDTO);

        Department savedDepartment = departmentRepository.save(department);

        // // Convert Saved Department to DepartmentDTO
        DepartmentDTO savedDepartmentDTO =  DepartmentMapper.mapToDepartmentDTO(savedDepartment);

        return savedDepartmentDTO;
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDTO departmentDTO =  DepartmentMapper.mapToDepartmentDTO(department);

        return departmentDTO;
    }
}
