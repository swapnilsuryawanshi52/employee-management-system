package com.microservices.organizationservice.service.impl;

import com.microservices.organizationservice.dto.OrganizationDTO;
import com.microservices.organizationservice.entity.Organization;
import com.microservices.organizationservice.mapper.OrganizationMapper;
import com.microservices.organizationservice.repository.OrganizationRepository;
import com.microservices.organizationservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO) {
        // Convert OrganizationDTO to Organization JPA Entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDTO);

        Organization savedOrganization = organizationRepository.save(organization);

        OrganizationDTO savedOrganizationDTO = OrganizationMapper.mapToOrganizationDTO(savedOrganization);

        return savedOrganizationDTO;
    }

    @Override
    public OrganizationDTO getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDTO(organization);
    }
}
