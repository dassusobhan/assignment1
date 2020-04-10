package com.assignment.employee.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.employee.models.Employee;
import com.assignment.employee.models.EmployeeModel;
import com.assignment.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	public List<EmployeeModel> get_all_employees_name_birth_date_by_dept_no(String deptNo){
		return repository.get_all_employees_name_birth_date_by_dept_no(deptNo);
		
	}
	
	
	public List<Employee> get_employees_hired_after_date_and_min_salary(Integer vSalary, String hire_date) {
		return repository.get_employees_hired_after_date_and_min_salary(vSalary, hire_date);
	}
	
	
	public void delete_employee_of_salaries_hire_date_before_given_date(String hireDate) {
		repository.delete_employee_of_salaries_hire_date_before_given_date(hireDate);
	}
	
}
