package com.microservices.organizationservice.mapper;

import com.microservices.organizationservice.dto.OrganizationDTO;
import com.microservices.organizationservice.entity.Organization;

public class OrganizationMapper {
    public static OrganizationDTO mapToOrganizationDTO(Organization organization) {
        OrganizationDTO organizationDTO = new OrganizationDTO(
                organization.getOrganizationId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getCreatedDate()
        );
        return organizationDTO;
    }

    public static Organization mapToOrganization(OrganizationDTO organizationDTO) {
        Organization organization = new Organization(
                organizationDTO.getOrganizationId(),
                organizationDTO.getOrganizationName(),
                organizationDTO.getOrganizationDescription(),
                organizationDTO.getOrganizationCode(),
                organizationDTO.getCreatedDate()
        );
        return organization;
    }
}
