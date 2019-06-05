package com.github.vtapadia.examples.annotation.processor.web;

import com.github.vtapadia.examples.annotation.processor.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Objects;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/api/v1/employee",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.save(employeeDto);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri()).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long id) {
        return employeeService.find(id).map(ResponseEntity::ok).orElseThrow(() -> new RuntimeException("EntityNotFound"));
    }

    @GetMapping
    public ResponseEntity<EmployeeDto> searchEmployee(@RequestParam(value = "name", required = false) String name,
                                                      @RequestParam(value = "company", required = false) String company,
                                                      @RequestParam(value = "age", required = false) Integer age) {
        Stream.of(name, company, age).filter(Objects::nonNull).findFirst().orElseThrow(IllegalArgumentException::new);
        return employeeService.search(name, company, age).map(ResponseEntity::ok).orElseThrow(() -> new RuntimeException("EntityNotFound"));
    }
}
