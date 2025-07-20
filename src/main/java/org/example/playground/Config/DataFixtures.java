package org.example.playground.Config;

import org.example.playground.Model.Department;
import org.example.playground.Model.Log;
import org.example.playground.Model.User;
import org.example.playground.Repo.DepartmentRepo;
import org.example.playground.Repo.Mongo.LogRepository;
import org.example.playground.Repo.UserRepo;
import org.example.playground.utils.LogType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataFixtures {

    @Bean
    CommandLineRunner loadData(UserRepo userRepo, DepartmentRepo departmentRepo, LogRepository logRepository) {
        return args -> {
            logRepository.deleteAll();
            Department marketing = departmentRepo.save(Department.builder().name("marketing").build());
            Department finances = departmentRepo.save(Department.builder().name("finances").build());

            userRepo.save(User.builder().name("jaja").department(marketing).build());
            userRepo.save(User.builder().name("pedro").department(finances).build());
            userRepo.save(User.builder().name("theo").department(marketing).build());

            for(User user : userRepo.findAll()) {
                logRepository.save(Log.builder().type(LogType.Creation).userId(user.getId()).timestamp(LocalDateTime.now()).build());
            }
        };
    }
}
