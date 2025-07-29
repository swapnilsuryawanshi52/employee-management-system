package com.microservices.organizationservice.controller;

import com.microservices.organizationservice.dto.OrganizationDTO;
import com.microservices.organizationservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/organization")
    public ResponseEntity<OrganizationDTO> saveOrganization(@RequestBody OrganizationDTO organizationDTO) {
        OrganizationDTO savedOrganizationDTO = organizationService.saveOrganization(organizationDTO);
        return new ResponseEntity<>(savedOrganizationDTO, HttpStatus.CREATED);
    }

    @GetMapping("/organization/{organizationCode}")
    public ResponseEntity<OrganizationDTO> getOrganizationByCode(@PathVariable String organizationCode) {
        OrganizationDTO organizationDTO = organizationService.getOrganizationByCode(organizationCode);
        return new ResponseEntity<>(organizationDTO, HttpStatus.OK);
    }
}
