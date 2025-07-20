package org.example.playground.Service;

import org.example.playground.Model.Department;
import org.example.playground.Model.Log;
import org.example.playground.Model.User;
import org.example.playground.Repo.DepartmentRepo;
import org.example.playground.Repo.Mongo.LogRepository;
import org.example.playground.Repo.UserRepo;
import org.example.playground.utils.LogType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepo userRepo;
    private final DepartmentRepo departmentRepo;
    private final LogRepository logRepository;
    @Autowired
    public UserService(UserRepo userRepo, DepartmentRepo departmentRepo, LogRepository logRepository) {
        this.userRepo = userRepo;
        this.departmentRepo = departmentRepo;
        this.logRepository = logRepository;
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public String sayHello() {
        return "wesh";
    }

    public User saveUser(User user) {
            logRepository.save(Log.builder().timestamp(LocalDateTime.now()).userId(user.getId()).type(LogType.Creation).build());
            return userRepo.save(user);

    }

    public List<User> getUsersFromGivenDepartment(String departmentName) {
        Optional<Department> departmentOpt = departmentRepo.findByName(departmentName);

        if (departmentOpt.isEmpty()) {
            return new ArrayList<>(); //
        }

        Department department = departmentOpt.get();
        return userRepo.findAll().stream()
                .filter(user -> user.getDepartment() != null && user.getDepartment().equals(department))
                .toList();
    }
}
