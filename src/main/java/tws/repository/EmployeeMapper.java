package tws.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
   
   @Insert("insert into employee values(#{employee.id},#{employee.name},#{employee.age})")
	void insertEmployee(@Param("employee") Employee employee);
	
	@Select("select * from employee")
	List<Employee> searchEmployees();

	@Update("update ")
	void updateEmployee(Employee employee);
}
