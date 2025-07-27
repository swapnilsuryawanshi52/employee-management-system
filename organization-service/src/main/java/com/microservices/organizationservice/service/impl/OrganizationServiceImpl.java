package com.microservices.organizationservice.service.impl;

import com.microservices.organizationservice.repository.OrganizationRepository;
import com.microservices.organizationservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;
}
