package com.javaguides.departmentservice.controller;

import com.javaguides.departmentservice.dto.DepartmentDto;
import com.javaguides.departmentservice.service.impl.DepartmentServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Department Service - Department Controller",
        description = "Department Controller Exposes REST APIs for Department-Service"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
@CrossOrigin("*")
public class DepartmentController {

    private DepartmentServiceImpl departmentService;

    @Operation(
            summary = "Save department REST API",
            description = "Save department REST API is used save department object in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http status 201 CREATED"
    )
    @PostMapping
    private ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get department REST API",
            description = "Get department REST API is used get department object from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 SUCCESS"
    )
    @GetMapping("{department-code}")
    private ResponseEntity<DepartmentDto> getDepartmentByDepartmentCode(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}
