package com.javaguides.organizationservice.mapper;

import com.javaguides.organizationservice.dto.OrganizationDto;
import com.javaguides.organizationservice.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoOrganizationDto {
    AutoOrganizationDto MAPPER = Mappers.getMapper(AutoOrganizationDto.class);

    OrganizationDto mapOrganizationToOrganizationDto(Organization organization);
    Organization mapOrganizationToOrganizationDto(OrganizationDto organizationDto);
}
