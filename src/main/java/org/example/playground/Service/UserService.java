package org.example.playground.Service;

import org.example.playground.Model.Log;
import org.example.playground.Model.User;
import org.example.playground.Repo.Mongo.LogRepository;
import org.example.playground.Repo.UserRepo;
import org.example.playground.utils.LogType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {


    private final UserRepo userRepo;
    private final LogRepository logRepository;
    @Autowired
    public UserService(UserRepo userRepo, LogRepository logRepository) {
        this.userRepo = userRepo;
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
}
