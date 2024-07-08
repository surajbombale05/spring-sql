package com.example.emp_details;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImp implements EmpService {
    
    @Autowired
    private EmployeeREpository employeeRepository;

    List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
       EmployeeEntity employeeEntity = new EmployeeEntity();
       BeanUtils.copyProperties(employee, employeeEntity);
       employeeRepository.save(employeeEntity);
       //employees.add(employee);
        return "Saved successfully";
    }

    @Override
    public List<Employee> getAllEmployees() {
         List<EmployeeEntity> employeesList = employeeRepository.findAll();
         List<Employee> employees = new ArrayList<>();
         for (EmployeeEntity employeeEntity :employeesList) {
            
            Employee emp = new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setPhone(employeeEntity.getEmail());

            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity exestingEmployee = employeeRepository.findById(id).get();
      
        exestingEmployee.setEmail(employee.getEmail());
        exestingEmployee.setPhone(employee.getPhone());
        exestingEmployee.setName(employee.getName());
        


        employeeRepository.save(exestingEmployee);
    return "update successfully";
    }

}
