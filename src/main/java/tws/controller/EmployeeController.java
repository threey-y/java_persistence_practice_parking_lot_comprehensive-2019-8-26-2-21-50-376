package tws.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

//    @GetMapping("")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<List<Employee>> getAll() {
//        return ResponseEntity.ok(employeeMapper.selectAll());
//    }
//
//    @PostMapping("")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<Employee> insert(@RequestBody Employee employee) {
//        employeeMapper.insert(employee);
//        return ResponseEntity.created(URI.create("/employees/" + employee.getId())).body(employee);
//    }
    
    
    
    
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addEmployee(@RequestBody Employee employee) {
		employeeMapper.insertEmployee(employee);
	}
	
	@GetMapping 
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> serchEmployees(){
		return employeeMapper.searchEmployees();
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateEmployee(@Param("id") int id,@RequestBody Employee employee) {
		employeeMapper.updateEmployee(id,employee);
	}
}
