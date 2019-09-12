package com.example.testdemo.controller;

import com.example.testdemo.domain.Employee;
import com.example.testdemo.domain.User;
import com.example.testdemo.service.EmployeeService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/user")
    public ModelAndView get() {
        ModelAndView mav = new ModelAndView("userList");
        List<Employee> list = employeeService.get();
        mav.addObject("list", list);
        return mav;
    }
}
