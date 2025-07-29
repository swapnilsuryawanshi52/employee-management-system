package com.microservices.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDTO {
    private Long organizationId;
    private String organizationName;
    private String organizationDescription;
    private String organizationCode;
    private LocalDate createdDate;
}
