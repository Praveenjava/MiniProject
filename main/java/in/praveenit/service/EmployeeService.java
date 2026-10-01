package in.praveenit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.praveenit.entity.Employee;
import in.praveenit.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	// Create Employee
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);

	}

	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	public Employee getEmployeeId(int id) {
		return employeeRepo.findById(id).orElse(null);
	}

	public Employee updateEmployee(int id, Employee employee) {
		Employee existingEmployee = employeeRepo.findById(id).orElse(null);

		if (existingEmployee != null) {
			existingEmployee.setName(employee.getName());
			existingEmployee.setSalary(employee.getSalary());
			return employeeRepo.save(existingEmployee);
		}

		return null;
	}

	public String deleteEmployee(int id) {
		Employee emp = employeeRepo.findById(id).orElse(null);

		if (emp != null) {
			employeeRepo.deleteById(id);
			return "Employee Deleted Successfully";
		}
		return "Employee Not Found";
	}

}
