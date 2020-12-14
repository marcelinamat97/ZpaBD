package com.example.lab1;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class EmployeeManager {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeManager(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        super();
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }
    //wyszukiwanie pracownika po id
    //http://localhost:8080/api/employees/id/?index=7
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    //zwracanie wszystkich pracownikow
    //http://localhost:8080/api/employees/all
    public Iterable<Employee> findAll(){
        return employeeRepository.findAll();
    }

    //dodanie nowego pracownika
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    //usuwanie pracownika o danym identyfikatorze
    //http://localhost:8080/api/employees/del/?index=61
    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }

    /*aktualizacja pracownika
    http://localhost:8080/api/employees/update/
    {
        "id": 9,
            "lastName": "Kowalik",
            "firstName": "Marzena",
            "salary": 4200.00,
            "employmentDate": "2020-11-10"
    }*/
    public Employee update(Employee employee){
        return employeeRepository.save(employee);
    }

    //wyszukiwanie pracownika po nazwisku
    //http://localhost:8080/api/employees/lastname/?name=Kot
    public Iterable<Employee> findByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    //usuwanie departamentu o danym identyfikatorze
    //http://localhost:8080/api/employees//delDepartment/?index=5
    public void deleteByIdDepartment(Long id){
        departmentRepository.deleteById(id);
    }
    //zwracanie wszystkich departamentow
    //http://localhost:8080/api/employees/allDepartment
    public Iterable<Department> findAllDepartment(){
        return departmentRepository.findAll();
    }
    //wyszkiwanie pracownikow po id departamentu
    //http://localhost:8080/api/employees/idDepartment/?index=1
    public Optional<Department> findByIdDepartment(Long id) {
        return departmentRepository.findById(id);
    }

    /*dodanie nowego departamentu
    http://localhost:8080/api/employees/saveDepartment
    {
        "deptName": "Laboratory",
            "job": "Lab technician",
            "idDept": 5
    }*/
    public Department save(Department department){
        return departmentRepository.save(department);
    }
    //wyszukiwanie departamentu po nazwie
    //http://localhost:8080/api/employees/deptname/?name=Accounting
    public Iterable<Department> findByDeptName(String deptName) {
        return departmentRepository.findByDeptName(deptName);
    }

    @PostConstruct
    public void EmployeeManager() {
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
        employee.setEmploymentDate(LocalDate.of(2020, 12, 14));
        employeeRepository.save(employee);

        Employee employee2 = new Employee();
        employee2.setDepartment(department1);
        employee2.setFirstName("Aleksandra");
        employee2.setLastName("Kot");
        employee2.setSalary(new BigDecimal("4500"));
        employee2.setEmploymentDate(LocalDate.of(2020, 11, 13));
        employeeRepository.save(employee2);

        Employee employee3 = new Employee();
        employee3.setDepartment(department2);
        employee3.setFirstName("Jan");
        employee3.setLastName("Kowalski");
        employee3.setSalary(new BigDecimal("4200"));
        employee3.setEmploymentDate(LocalDate.of(2020, 12, 10));
        employeeRepository.save(employee3);

        Employee employee4 = new Employee();
        employee4.setDepartment(department3);
        employee4.setFirstName("Tadeusz");
        employee4.setLastName("Kowal");
        employee4.setSalary(new BigDecimal("9200"));
        employee4.setEmploymentDate(LocalDate.of(2020, 12, 11));
        employeeRepository.save(employee4);

        System.out.println(employee);
        System.out.println(employee2);
        System.out.println(employee3);
        System.out.println(employee4);


        /*Iterable<Employee> a = employeeRepository.findByFirstName("Tadeusz");
        for (Employee e : a) {
        System.out.println(e);
        }*/

        /*Iterable<Employee> em = employeeRepository.findAllWhereName("K%");
        Employee p = em.iterator().next();
        System.out.println("Pracownik z k: " + p);
        for (Employee e : em) {
        System.out.println(e);
        }*/
    }

}