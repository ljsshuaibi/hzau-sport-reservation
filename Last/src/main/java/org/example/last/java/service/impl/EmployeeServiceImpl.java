package org.example.last.java.service.impl;




import org.example.last.java.entity.Employee;
import org.example.last.java.entity.SportDto;
import org.example.last.java.mapper.EmployeeMapper;
import org.example.last.java.mapper.SportMapper;
import org.example.last.java.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;



    public Employee login(Employee employeeDTO) {
        String username = employeeDTO.getUsername();
        String password = employeeDTO.getPassword();

        //1、根据用户名查询数据库中的数据
        Employee employee = employeeMapper.getByUsername(username);


        //3、返回实体对象
        return employee;
    }



}
