package com.example.BBVA2.Rest;

import com.example.BBVA2.DoMain.Employee;
import com.example.BBVA2.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/empleados")
public class EmployeeController {

    @Autowired
    @Qualifier("employeeService")
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll(){

        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable int id){
        return employeeService.get(id);
    }

    @PostMapping
    public List<Employee> add(@RequestBody Employee employee){
        return employeeService.add(employee);
    }

    @PutMapping("/{id}")
    public Set<Employee> update(@PathVariable int id, @RequestBody Employee employee) throws Exception { return employeeService.update(id, employee); }

    @DeleteMapping("/{id}")
    public Set<Employee> deleteByPosition(@PathVariable int id){
        return employeeService.delete(id);
    }
}