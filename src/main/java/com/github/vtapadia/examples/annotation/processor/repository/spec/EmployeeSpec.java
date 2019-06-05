package com.github.vtapadia.examples.annotation.processor.repository.spec;

import com.github.vtapadia.examples.annotation.processor.repository.entity.Employee;
import com.github.vtapadia.examples.annotation.processor.repository.entity.Employee_;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 */
public class EmployeeSpec {
    public static Specification<Employee> nameLike(String name) {
        return (root, query, cb) -> cb.like(root.get(Employee_.NAME), name);
    }
    public static Specification<Employee> companyLike(String company) {
        return (root, query, cb) -> cb.like(root.get(Employee_.COMPANY), company);
    }
    public static Specification<Employee> ageLessThanOrEqualTo(Integer age) {
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get(Employee_.AGE), age);
    }
}

