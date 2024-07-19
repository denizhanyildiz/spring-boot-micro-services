package com.javaguides.organizationservice.controller;

import com.javaguides.organizationservice.dto.OrganizationDto;
import com.javaguides.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Organization Service - Organization Controller",
        description = "Organization Controller Exposes REST APIs for Organization-Service"
)
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
@CrossOrigin("*")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Operation(
            summary = "Save organization REST API",
            description = "Save organization REST API is used save organization object in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto savedOrganizationDto = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganizationDto, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get organization REST API",
            description = "Get organization REST API is used get organization object from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 SUCCESS"
    )
    @GetMapping("/{organizationCode}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("organizationCode") String organizationCode) {
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return ResponseEntity.ok(organizationDto);
    }
}
