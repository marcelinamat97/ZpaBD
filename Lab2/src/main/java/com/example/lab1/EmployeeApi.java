package com.example.lab1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApi {

    private EmployeeManager employeeManager;

    @Autowired
    public EmployeeApi(EmployeeManager employeeManager) {
        super();
        this.employeeManager = employeeManager;
    }

    @GetMapping("/all")
    public Iterable<Employee> getAll() {
        return employeeManager.findAll();
    }

    @GetMapping("/id")
    public Optional<Employee> getById(@RequestParam Long index) {
        return employeeManager.findById(index);
    }

    @PostMapping("/save")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeManager.save(employee);
    }

    @DeleteMapping("/del")
    public void deleteEmployee(@RequestParam Long index) {
        employeeManager.deleteById(index);
    }

    @PostMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeManager.save(employee);
    }

    @GetMapping("/lastname")
    public Iterable<Employee> getByLastName(@RequestParam String name) {
        return employeeManager.findByLastName(name);
    }

    @DeleteMapping("/delDepartment")
    public void deleteDepartment(@RequestParam Long index) {
        employeeManager.deleteByIdDepartment(index);
    }

    @GetMapping("/allDepartment")
    public Iterable<Department> getAllDepartment() {
        return employeeManager.findAllDepartment();
    }

    @GetMapping("/idDepartment")
    public Optional<Department> getByIdDepartment(@RequestParam Long index) {
        return employeeManager.findByIdDepartment(index);
    }

    @PostMapping("/saveDepartment")
    public Department addDepartment(@RequestBody Department department) {
        return employeeManager.save(department);
    }

    @GetMapping("/deptname")
    public Iterable<Department> getByDeptName(@RequestParam String name) {
        return employeeManager.findByDeptName(name);
    }

}