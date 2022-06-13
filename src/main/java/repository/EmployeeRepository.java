package repository;

import model.Employee;

import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> findByID(String number);
    void update(Employee employee);
    void delete(Employee employee);
    void save(Employee employee);
}
