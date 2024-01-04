package com.javaguides.employeeservice.service.impl;

import com.javaguides.employeeservice.dto.EmployeeDto;
import com.javaguides.employeeservice.entity.Employee;
import com.javaguides.employeeservice.exception.EmailAlreadyExistsException;
import com.javaguides.employeeservice.exception.ResourceNotFoundException;
import com.javaguides.employeeservice.mapper.AutoEmployeeMapper;
import com.javaguides.employeeservice.repository.EmployeeRepository;
import com.javaguides.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Optional<Employee> employee = employeeRepository.findByEmail(employeeDto.getEmail());
        if (employee.isPresent()){
            throw new EmailAlreadyExistsException("Email AlreadyExists for Employee");
        }
        Employee savedEmployee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        employeeRepository.save(savedEmployee);
        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );
        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
        return employeeDto;
    }
}
