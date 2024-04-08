package org.patika.logservice.repository;

import org.patika.logservice.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ILogRepository extends MongoRepository<Log,String> { }
