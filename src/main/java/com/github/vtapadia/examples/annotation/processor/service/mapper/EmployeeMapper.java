package com.github.vtapadia.examples.annotation.processor.service.mapper;

import com.github.vtapadia.examples.annotation.processor.repository.entity.Employee;
import com.github.vtapadia.examples.annotation.processor.web.EmployeeDto;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {
    Employee toEntity(EmployeeDto resource);
    EmployeeDto toResource(Employee entity);
}
