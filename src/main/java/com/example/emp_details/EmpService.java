package com.example.emp_details;

import java.util.List;

public interface EmpService {
 String createEmployee(Employee employee);
 List<Employee> getAllEmployees();
 boolean deleteEmployee(Long i); 
 String updateEmployee(Long i, Employee employee);
} 
