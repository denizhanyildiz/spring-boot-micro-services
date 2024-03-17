package com.javaguides.organizationservice.service.impl;

import com.javaguides.organizationservice.dto.OrganizationDto;
import com.javaguides.organizationservice.entity.Organization;
import com.javaguides.organizationservice.mapper.AutoOrganizationDto;
import com.javaguides.organizationservice.repository.OrganizationRepository;
import com.javaguides.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        Organization organization = AutoOrganizationDto.MAPPER.mapOrganizationToOrganizationDto(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);

        return AutoOrganizationDto.MAPPER.mapOrganizationToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);

        return AutoOrganizationDto.MAPPER.mapOrganizationToOrganizationDto(organization);
    }
}
