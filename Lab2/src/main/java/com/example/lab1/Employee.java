package com.example.lab1;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String lastName;
    private String firstName;
    private BigDecimal salary;
    private LocalDate employmentDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="departmentId")
    private Department department;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public BigDecimal getSalary() {
        return salary;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", salary=" + salary +
                ", employmentDate=" + employmentDate +
                ", department=" + department +
                '}';
    }


}