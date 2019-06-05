package com.github.vtapadia.examples.annotation.processor.repository;

import com.github.vtapadia.examples.annotation.processor.repository.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployeeRepo extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
}
