package org.example.playground.Controller;

import org.example.playground.Model.Department;
import org.example.playground.Service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @RequestMapping("/departments")
    @ResponseBody
    public List<Department> findAll() {
        return departmentService.findAll();
    }
}
