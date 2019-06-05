package com.github.vtapadia.examples.annotation.processor.service;

import com.github.vtapadia.examples.annotation.processor.repository.EmployeeRepo;
import com.github.vtapadia.examples.annotation.processor.repository.entity.Employee;
import com.github.vtapadia.examples.annotation.processor.repository.spec.EmployeeSpec;
import com.github.vtapadia.examples.annotation.processor.service.mapper.EmployeeMapper;
import com.github.vtapadia.examples.annotation.processor.web.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public Optional<EmployeeDto> search(String name, String company, Integer age) {
        List<Specification<Employee>> allSpecs = new ArrayList<>();
        Optional.ofNullable(name).map(EmployeeSpec::nameLike).ifPresent(allSpecs::add);
        Optional.ofNullable(company).map(EmployeeSpec::companyLike).ifPresent(allSpecs::add);
        Optional.ofNullable(age).map(EmployeeSpec::ageLessThanOrEqualTo).ifPresent(allSpecs::add);
        final Optional<Specification<Employee>> specification = allSpecs.stream().reduce(Specification::and);

        final Optional<List<Employee>> employees = specification.map(employeeRepo::findAll);

        return employees.map(e -> e.stream().findFirst().map(employeeMapper::toResource)).flatMap(a -> a);
    }
}
