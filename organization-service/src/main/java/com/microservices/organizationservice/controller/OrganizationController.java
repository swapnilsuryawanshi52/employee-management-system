package com.microservices.organizationservice.controller;

import com.microservices.organizationservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;
}
