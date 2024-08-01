package com.test.myapp2;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test.myapp2.jdbc.employee.EmployeeJDBCRepository;
import com.test.myapp2.jdbc.model.Employee;

@SpringBootApplication
public class Myapp2Application implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EmployeeJDBCRepository employeeJDBCRepository;

	@Override
	public void run(String... args) throws Exception {
		// logger.info("All users -> {}", employ eeJDBCRepository.findAll());

		employeeJDBCRepository.insert(new Employee(
			101L, "Dennis", "Lee", "test@gmail.com"));
		
		Optional<Employee> e1 = employeeJDBCRepository.findById(100L);
		employeeJDBCRepository.deleteById(1);

		List<Employee> emps = employeeJDBCRepository.findAll();
		for(Employee e : emps) {
			System.out.println(e.getId() 
				+ ", " + e.getFirstName()
				+ ", " + e.getLastName()
				+ ", " + e.getEmailId());
		}
 
	}

	public static void main(String[] args) {
		SpringApplication.run(Myapp2Application.class, args);		
	}

}
