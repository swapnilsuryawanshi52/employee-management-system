package com.microservices.employeeservice.service.impl;

import com.microservices.employeeservice.dto.APIResponseDTO;
import com.microservices.employeeservice.dto.DepartmentDTO;
import com.microservices.employeeservice.dto.EmployeeDTO;
import com.microservices.employeeservice.dto.OrganizationDTO;
import com.microservices.employeeservice.entity.Employee;
import com.microservices.employeeservice.mapper.EmployeeMapper;
import com.microservices.employeeservice.repository.EmployeeRepository;
import com.microservices.employeeservice.service.APIClient;
import com.microservices.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

//    @Autowired
//    private RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private WebClient webClient;

//    @Autowired
//    private APIClient apiClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        // Convert EmployeeDTO to Employee JPA Entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDTO savedEmployeeDTO = EmployeeMapper.mapToEmployeeDTO(savedEmployee);

        return savedEmployeeDTO;
    }

    @Override
    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    public APIResponseDTO getEmployeeById(Long employeeId) {
        LOGGER.info("inside getEmployeeById() method");
        Employee employee = employeeRepository.findById(employeeId).orElse(null);

//        ResponseEntity<DepartmentDTO> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/v1/department/" +
//                employee.getDepartmentCode(), DepartmentDTO.class);
//
//        DepartmentDTO departmentDTO = responseEntity.getBody();

        DepartmentDTO departmentDTO = webClient.get()
                .uri("http://localhost:8080/api/v1/department/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDTO.class)
                .block();

        OrganizationDTO organizationDTO = webClient.get()
                .uri("http://localhost:8083/api/v1/organization/" + employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDTO.class)
                .block();

//        DepartmentDTO departmentDTO = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        // Convert Employee JPA Entity to EmployeeDTO
        EmployeeDTO employeeDTO = EmployeeMapper.mapToEmployeeDTO(employee);

        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDTO);
        apiResponseDTO.setDepartmentDTO(departmentDTO);
        apiResponseDTO.setOrganizationDTO(organizationDTO);

        return apiResponseDTO;
    }

    public APIResponseDTO getDefaultDepartment(Long emloyeeId, Exception exception) {

        LOGGER.info("inside getDefaultDepartment() method");

        Employee employee = employeeRepository.findById(emloyeeId).get();

        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentName("R&D Department");
        departmentDTO.setDepartmentDescription("Research and Development Department");
        departmentDTO.setDepartmentCode("R&D-001");

        EmployeeDTO employeeDTO = EmployeeMapper.mapToEmployeeDTO(employee);

        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDTO);
        apiResponseDTO.setDepartmentDTO(departmentDTO);

        return apiResponseDTO;
    }
}
