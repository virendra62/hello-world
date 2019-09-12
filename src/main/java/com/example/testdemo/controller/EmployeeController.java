package com.example.testdemo.controller;

import com.example.testdemo.domain.Employee;
import com.example.testdemo.domain.User;
import com.example.testdemo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = {"/", "/home", "/index"},method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> get() {
        ModelAndView mav = new ModelAndView("employeesList");
        List<Employee> list = employeeService.get();
        return list;
    }

/*    @RequestMapping("/openEmployeeView")
    public ModelAndView openEmployeeAddView() {
        ModelAndView mav = new ModelAndView("employeesAdd");
        mav.addObject("employee", new Employee());
        return mav;
    }*/

    @PostMapping("/save")
    public ResponseEntity  save(@ModelAttribute("employee") Employee employeeObj) {
        ModelAndView mav = new ModelAndView("employeesList");
        employeeService.save(employeeObj);
        List<Employee> list = employeeService.get();
        mav.addObject("list", list);
        ObjectMapper obj = new ObjectMapper();
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/employee/{id}")
    public Employee get(@PathVariable("id") int id) {

        User userObj = new User();

        ModelAndView mav = new ModelAndView("employeesAdd");
        Employee employeeObj = employeeService.get(id);
        if(employeeObj == null) {
            throw new RuntimeException("Employee not found"+id);
        }
        mav.addObject("employee", employeeObj);
        return employeeObj;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView("employeesList");
        employeeService.delete(id);
        List<Employee> list = employeeService.get();
        mav.addObject("list", list);
        return mav;
    }
}
