package com.mongo.demo.adapters.out.persistence;


import com.mongo.demo.adapters.in.rest.LogsController;
import com.mongo.demo.core.model.LogsDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MongoDBRespository extends MongoRepository<LogsDTO, String> {


    List<LogsDTO> findByServiceName(String serviceName);
}