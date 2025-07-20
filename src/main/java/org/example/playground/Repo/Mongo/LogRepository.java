package org.example.playground.Repo.Mongo;

import org.example.playground.Model.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface LogRepository extends MongoRepository<Log, UUID> {
}
