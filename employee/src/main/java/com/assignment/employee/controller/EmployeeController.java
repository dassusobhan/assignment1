package com.assignment.employee.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.employee.models.Employee;
import com.assignment.employee.models.EmployeeModel;
import com.assignment.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employees/dept/{deptNo}")
	public ResponseEntity<List<EmployeeModel>> get_all_employees_name_birth_date_by_dept_no(@PathVariable("deptNo") String deptNo){
		List<EmployeeModel> employees= service.get_all_employees_name_birth_date_by_dept_no(deptNo);
		return ResponseEntity.ok(employees);
		
	}
	
	@GetMapping("/employees/hiredate/{hiredate}/salary/{salary}")
	public ResponseEntity<List<Employee>> get_employees_hired_after_date_and_min_salary(@PathVariable("salary") Integer vSalary,@PathVariable("hiredate") String hire_date) {
		List<Employee> employees=service.get_employees_hired_after_date_and_min_salary(vSalary, hire_date);
		return ResponseEntity.ok(employees);
	}
	
    @DeleteMapping("employees/salaries/employee/hiredate/{hiredate}")
	public ResponseEntity<?> delete_employee_of_salaries_hire_date_before_given_date(@PathVariable("hiredate") String hireDate) {
		service.delete_employee_of_salaries_hire_date_before_given_date(hireDate);
		
		return ResponseEntity.noContent().build();
	}
	
}
