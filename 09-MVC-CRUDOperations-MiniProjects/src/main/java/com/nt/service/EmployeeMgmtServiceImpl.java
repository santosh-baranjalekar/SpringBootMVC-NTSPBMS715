package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepository empRepo;

	@Override
	public Iterable<Employee> getAllEmployees() {

		Iterable<Employee> emp = empRepo.findAll();

		emp.forEach(e -> {
			System.out.println(e);
		});

		return empRepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {
		return "Employeee is saved with id value:: " + empRepo.save(emp).getEno();
	}

	@Override
	public Employee getEmployeeByNo(int eno) {
		Employee emp = empRepo.findById(eno).orElseThrow(() -> new IllegalArgumentException());
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) {
		return "Employee is updated with having Id value:: " + empRepo.save(emp).getEno();
	}

	@Override
	public String deleteEmployeeById(int eno) {
		empRepo.deleteById(eno);
		return eno + "Employee Id is employee deleted";
	}

}