package com.test.myapp2.jdbc.employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.test.myapp2.jdbc.model.Employee;

@Repository
public class EmployeeJDBCRepository {

    // DAO(Data Access Object) -> CRUD
    // @Repository 
    @Autowired
    JdbcTemplate jdbcTemplate;

    class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setEmailId(rs.getString("email_address"));
            return employee;
        }
    }
    public List<Employee> findAll() {
         return jdbcTemplate.query("select * from employees", new EmployeeRowMapper());

    }
    
    @SuppressWarnings("deprecation")
    public Optional<Employee> findById(long id) {
        return Optional.of(jdbcTemplate.queryForObject("select * from employees where id=?", new Object[] {
                id
            },
            new BeanPropertyRowMapper <Employee> (Employee.class)));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from employees where id=?", new Object[] {
            id
        });
    }

    public int insert(Employee employee) {
        return jdbcTemplate.update("insert into employees (id, first_name, last_name, email_address) " + "values(?, ?, ?, ?)",
            new Object[] {
                employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmailId()
            });
    }

    public int update(Employee employee) {
        return jdbcTemplate.update("update employees " + " set first_name = ?, last_name = ?, email_address = ? " + " where id = ?",
            new Object[] {
                employee.getFirstName(), employee.getLastName(), employee.getEmailId(), employee.getId()
            });
    }
}
