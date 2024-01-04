package com.javaguides.departmentservice.service.impl;

import com.javaguides.departmentservice.dto.DepartmentDto;
import com.javaguides.departmentservice.entity.Department;
import com.javaguides.departmentservice.exception.ResourceNotFoundException;
import com.javaguides.departmentservice.mapper.AutoDepartmentMapper;
import com.javaguides.departmentservice.repository.DepartmentRepository;
import com.javaguides.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        DepartmentDto savedDepartmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {

        Department department = departmentRepository.findByDepartmentCode(code);

        if (department == null){
            throw new ResourceNotFoundException("Department", "id", Long.valueOf(code));
        }

        DepartmentDto departmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(department);
        return departmentDto;
    }
}
