package org.example.playground.Config;

import org.example.playground.Model.Department;
import org.example.playground.Model.User;
import org.example.playground.Repo.DepartmentRepo;
import org.example.playground.Repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataFixtures {

    @Bean
    CommandLineRunner loadData(UserRepo userRepo, DepartmentRepo departmentRepo) {
        return args -> {
            Department marketing = departmentRepo.save(Department.builder().name("marketing").build());
            Department finances = departmentRepo.save(Department.builder().name("finances").build());

            userRepo.save(User.builder().name("jaja").department(marketing).build());
            userRepo.save(User.builder().name("pedro").department(finances).build());
            userRepo.save(User.builder().name("theo").department(marketing).build());
        };
    }
}
