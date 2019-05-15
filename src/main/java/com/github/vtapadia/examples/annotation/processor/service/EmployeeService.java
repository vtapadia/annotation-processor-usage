package com.github.vtapadia.examples.annotation.processor.service;

import com.github.vtapadia.examples.annotation.processor.repository.EmployeeRepo;
import com.github.vtapadia.examples.annotation.processor.service.mapper.EmployeeMapper;
import com.github.vtapadia.examples.annotation.processor.web.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    EmployeeMapper employeeMapper;

    public void save(EmployeeDto employeeDto) {
        Optional.ofNullable(employeeDto).map(employeeMapper::toEntity).map(employeeRepo::save);
    }

    public Optional<EmployeeDto> find(Long id) {
        return employeeRepo.findById(id).map(employeeMapper::toResource);
    }

}
