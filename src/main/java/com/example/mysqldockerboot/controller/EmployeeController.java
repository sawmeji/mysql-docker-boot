package com.example.mysqldockerboot.controller;

import com.example.mysqldockerboot.dao.EmployeeDao;
import com.example.mysqldockerboot.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("creation")
    public String init(){
        List<Employee> list = List.of(
          new Employee("Wendy","Alice","wendy@gmail.com"),
                new Employee("Mary","James","mary@gmail.com"),
                new Employee("Chloe","Docker","chloe@gmail.com"),
                new Employee("Domanic","Toretto","dom@gmail.com")
        );
        list.forEach(employeeDao::save);
        return "success";
    }

    @GetMapping("/employees")
    public Iterable<Employee> listEmployees(){
        return employeeDao.findAll();
    }

}
