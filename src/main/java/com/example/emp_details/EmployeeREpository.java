package com.example.emp_details;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeREpository extends JpaRepository<EmployeeEntity,Long>{

    
}
