package com.example.lab1;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RunAtStart {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public RunAtStart(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        super();
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @PostConstruct
    public void runAtStart() {
        Department department = new Department();
        department.setDeptName("Accounting");
        department.setJob("Assistant");
        departmentRepository.save(department);

        Department department1 = new Department();
        department1.setDeptName("Sales");
        department1.setJob("Manager");
        departmentRepository.save(department1);

        Department department2 = new Department();
        department2.setDeptName("Support Services");
        department2.setJob("Engineer");
        departmentRepository.save(department2);

        Department department3 = new Department();
        department3.setDeptName("Human Resources");
        department3.setJob("Boss");
        departmentRepository.save(department3);

        Employee employee = new Employee();
        employee.setDepartment(department);
        employee.setFirstName("Jan");
        employee.setLastName("Nowacki");
        employee.setSalary(new BigDecimal("4300"));
        employeeRepository.save(employee);

        Employee employee2 = new Employee();
        employee2.setDepartment(department1);
        employee2.setFirstName("Aleksandra");
        employee2.setLastName("Kot");
        employee2.setSalary(new BigDecimal("4500"));
        employeeRepository.save(employee2);

        Employee employee3 = new Employee();
        employee3.setDepartment(department2);
        employee3.setFirstName("Jan");
        employee3.setLastName("Kowalski");
        employee3.setSalary(new BigDecimal("4200"));
        employeeRepository.save(employee3);

        Employee employee4 = new Employee();
        employee4.setDepartment(department3);
        employee4.setFirstName("Tadeusz");
        employee4.setLastName("Kowal");
        employee4.setSalary(new BigDecimal("9200"));
        employeeRepository.save(employee4);

        System.out.println(employee);
        System.out.println(employee2);
        System.out.println(employee3);
        System.out.println(employee4);

        //Iterable<Employee> em = employeeRepository.findAllWhereName("K%");
        //Employee p = em.iterator().next();
        //System.out.println("Pracownik z k: " + p);
        //for (Employee e : em) {
        //System.out.println(e);
        //}
    }

}