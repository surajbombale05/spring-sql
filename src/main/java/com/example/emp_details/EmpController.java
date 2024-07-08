package com.example.emp_details;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
    @Autowired
    EmpService empService;

    // get all employees Controller
    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return empService.getAllEmployees();
    }

    // creat a new employee Controller
    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
     return empService.createEmployee(employee);
    }

    // delete API controller
    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id ){
      if(empService.deleteEmployee(id)){
         return "Employee deleted";
      }
      return  "Employee not found";
        
    }

    @PutMapping("employees/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return empService.updateEmployee(id, employee);
    }
}
