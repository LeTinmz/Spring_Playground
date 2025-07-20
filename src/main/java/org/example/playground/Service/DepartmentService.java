package org.example.playground.Service;

import org.example.playground.Model.Department;
import org.example.playground.Repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepo departmentRepo;

    @Autowired
    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public List<Department> findAll() {
        return departmentRepo.findAll();
    }

    public Optional<Department> findByName(String name) {
        return departmentRepo.findByName(name);
    }
}
