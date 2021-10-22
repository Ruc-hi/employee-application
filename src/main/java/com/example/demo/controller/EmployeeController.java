package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/list")
    public String listAllEmployees(Model model)
    {
        List<Employee> list=employeeService.listEmployees();
        model.addAttribute("employees",list);
        return "list-employees";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
// create model attribute to bind form data
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employee-form";
    }
    @PostMapping("/save")
    public String saveEmployee(
            @ModelAttribute("employee") @Valid Employee theEmployee,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "employee-form";
        }
        else {
            // save the employee
            employeeService.createEmployee(theEmployee);

            // use a redirect to prevent duplicate submissions
            return "redirect:/employees/list";
        }
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,
                                    Model theModel) {
// get the employee from the service
        Employee theEmployee = employeeService.getById(theId);
// set employee as a model attribute to pre-populate the form
        theModel.addAttribute("employee", theEmployee);
// send over to our form
        return "employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {

        // delete the employee
        employeeService.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/employees/list";

    }
}